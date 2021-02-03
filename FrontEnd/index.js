'use strict';

const Hapi = require('@hapi/hapi');
const Inert = require('@hapi/inert');
const Vision = require('@hapi/vision')
const fetch = require('node-fetch');

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
        const user = await fetch("http://localhost:8080/api/v1/user/1");
        let data = await user.json();
        console.log(data)
        return h.view('newsfeed', data)
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
