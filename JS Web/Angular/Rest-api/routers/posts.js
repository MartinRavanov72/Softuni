const express = require('express');
const router = express.Router();
const { auth } = require('../utils');
const { postController } = require('../controllers');


router.get('/', auth(), postController.getLatestsPosts);
router.post('/', auth(), postController.createPost);

module.exports = router;