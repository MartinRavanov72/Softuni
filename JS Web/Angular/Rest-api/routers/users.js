const express = require('express');
const router = express.Router();
const { authController } = require('../controllers');
const { auth } = require('../utils');


router.post('/register', authController.register);
router.post('/login', authController.login);
router.post('/logout', auth(), authController.logout);

router.get('/profile', auth(), authController.getProfileInfo);
router.put('/profile', auth(), authController.editProfileInfo);

router.get('/:userId', auth(), authController.getUser);
router.get('/', authController.getUsers);


module.exports = router