const { body } = require("express-validator");

function customPasswordCheck(repeatPassword, { req }) {
    if((repeatPassword !== req.body.password)){
        throw new Error('The passwords should match');
    } 
    return true;
}

module.exports = [
    body('username', 'Username should be at least 5 chars long').isLength({ min: 5 }),
    body('username', 'Username should only consist of digits and letters').isAlphanumeric(),
    body('password', 'Password should be at least 5 chars long').isLength({ min: 5 }),
    body('password', 'Password should only consist of digits and letters').isAlphanumeric(),
    body('repeatPassword').custom(customPasswordCheck),
];

