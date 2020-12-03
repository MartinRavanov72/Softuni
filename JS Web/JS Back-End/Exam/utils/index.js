const jwt = require('./jwt');
const auth = require('./auth');
const registerMiddlewareValidator = require('./registerMiddlewareValidator');
const loginMiddlewareValidator = require('./loginMiddlewareValidator');
const isAuthNeededMiddleware = require('./isAuthNeededMiddleware');
const createPostMiddlewareValidator = require('./create-postMiddlewareValidator');
const formValidator = require('./formValidator');

module.exports = {
    jwt, auth, registerMiddlewareValidator, formValidator, loginMiddlewareValidator, isAuthNeededMiddleware, createPostMiddlewareValidator
};