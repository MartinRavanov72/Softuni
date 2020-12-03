const env = process.env.Node_ENV || 'development';

const config = {
    development: {
        port: process.env.PORT || 9999,
        dbUrl: 'mongodb://localhost:27017/test',
        cookie: 'x-auth-token-887790',
        secret: 'SuperSecretSecret',
        saltRounds: 11
    }
};

module.exports = config[env];