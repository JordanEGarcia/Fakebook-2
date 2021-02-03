const Sequelize = require("sequelize");

const sequelize = new Sequelize('FakebookDb', 'root', '123', {
  host: 'localhost',
  port: 3306,
  dialect: 'mysql'
});

async function testConnection() {
  try {
    await sequelize.authenticate();
    const [results,metadata] = await sequelize.query('Select * From user where id=1');
    console.log("We are connected again")
    return results[0];
  }
  catch(err) {
    console.log("Cant connect to database!")
  }
}

exports.login = function () {
  return testConnection();
}
