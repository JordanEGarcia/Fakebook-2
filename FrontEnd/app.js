const Hapi = require('@hapi/hapi');
const server = new Hapi.Server();

server.connection({
  port: 8000,
  host: 'localhost'
});

server.start(error => {
  if(error) {
    throw error;
  }
  console.log("Listening at Port " + server.info.uri)
});
