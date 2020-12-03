const { body } = require("express-validator");

module.exports = [
    body('username', 'Username should be at least 5 chars long').isLength({ min: 5 }),
    body('username', 'Username should only consist of digits and letters').isAlphanumeric(),
    body('password', 'Password should be at least 5 chars long').isLength({ min: 5 }),
    body('password', 'Password should only consist of digits and letters').isAlphanumeric()
];

