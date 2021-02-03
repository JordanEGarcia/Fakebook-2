'use strict';

const Hapi = require('@hapi/hapi');
const Inert = require('@hapi/inert');
const Vision = require('@hapi/vision')
const fetch = require('node-fetch');
var user_service = require('./api/user_service')

const path = require('path')
const init = async () => {

    const server = Hapi.server({
        port: 3000,
        host: 'localhost',
        routes:  {
          files: {
            relativeTo: path.join(__dirname, 'static/html')
          }
        }
    });

    await server.register([
      {plugin:Inert},
      {plugin: Vision}
    ]);

    server.views({
      engines: {
        html: require('handlebars')
      },
      path: path.join(__dirname, 'views'),
      layout: 'default'
    })

    //////// routes for the website //////////////////
    server.route([{
        method: 'GET',
        path: '/',
        handler: (request, h) => {
            return h.view('index');
        }
    },
    {
      method: 'GET',
      path: '/dynamic',
      handler: (request, h) => {
        const data = {name:"jordan"}
        return h.view('test-handlebar', data)
      }
    },
    {
      method: 'GET',
      path: '/newsfeed',
      handler: async (request, h)  =>  {
        const posts = await fetch("http://localhost:8080/api/v1/post");
        const logged = await user_service.login();

        let postsJSON = await posts.json();

        const data = {
          user:logged,
          posts: postsJSON.reverse()
        }
        return h.view('newsfeed', data);
      }
    },
    {
    method: 'POST',
    path: '/newsfeed',
    handler: async (request,h) => {
      const jsonBody = {userId: request.payload.userId, content: request.payload.content}
      console.log(jsonBody)

      fetch('http://localhost:8080/api/v1/post', {
        method: 'POST',
        body: JSON.stringify(jsonBody),
        headers: { 'Content-Type': 'application/json' }
      })

      return h.redirect('/newsfeed')
    }
  }

  ]);
  //////// END //////////////////

    await server.start();
    console.log('Server running on %s', server.info.uri);
};

process.on('unhandledRejection', (err) => {

    console.log(err);
    process.exit(1);
});

init();
