const { homeController } = require('../controllers/index');
const { isAuthNeededMiddleware } = require("../utils");

module.exports = (router) => {
    router.get('/', isAuthNeededMiddleware(),  homeController.get.home);

    
    return router;
};