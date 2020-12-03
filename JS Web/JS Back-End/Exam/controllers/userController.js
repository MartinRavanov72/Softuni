const { User } = require("../models");
const { jwt, formValidator } = require("../utils");
const { cookie } = require("../config");


module.exports = {
    get: {
        login(req, res, next) {
            res.render('./user/login.hbs');
        },

        register(req, res, next) {
            res.render('./user/register.hbs');
        },

        logout(req, res, next) {
            res
                .clearCookie(cookie)
                .redirect('/home');        
        }, 
    },

    post: {
        login(req, res, next) {
            const formValidations = formValidator(req);
            
            if(!formValidations.isOK){
                res.render('./user/login.hbs', formValidations.contextOptions);
                return;
            }

            const { username, password } = { ...req.body };
            User
                .findOne({ username })
                .then((user) => {
                    return Promise.all([
                        user.passwordsMatch(password),
                        user
                    ])
                })
                .then(([isPasswordsMatch, user]) => {
                    if (!isPasswordsMatch) {
                        throw new Error("Wrong password");
                    }
                     
                    const token = jwt.createToken(user._id);
                    
                    res
                        .status(200)
                        .cookie(cookie, token, { maxAge: 3600000} )
                        .redirect('/courses/all');
                })
                .catch((e) => {
                    console.log(formValidations.contextOptions);
                    res.render('./user/login.hbs', { message: e });
                });          
        },

        register(req, res, next) {
            const formValidations = formValidator(req);
            
            if(!formValidations.isOK){
                res.render('./user/register.hbs', formValidations.contextOptions);
                return;
            }

            const { username, password } = { ...req.body };
            
            User
                .findOne({ username })
                .then((user) => {
                    if (user) {
                        res.render('./user/register.hbs', { message: "The given username is already being used" });
                    }

                    return User.create({ username, password });
                })
                .then((createdUser) => {
                    const token = jwt.createToken(createdUser._id);
                    
                    res
                        .status(200)
                        .cookie(cookie, token, { maxAge: 3600000} )
                        .redirect('/courses/all');
                })
                .catch((e) => {
                    console.log(e);
                    res.render('./user/register.hbs', { message: e });
                }); 
            
        }
    }
};