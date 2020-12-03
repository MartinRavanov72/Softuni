const { body } = require("express-validator");

module.exports = [
    body('title', 'Title should be at least 4 chars long').isLength({ min: 4 }),
    body('description', 'Description should be at least 20 chars long').isLength({ min: 20 }),
    body('duration', 'Duration should not be empty').isLength({ min: 1 }),
    body('imageUrl', 'ImageUrl should start with http or https').matches(/(^http:\/\/|^https:\/\/).*/, "i")
];

