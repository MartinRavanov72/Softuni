const { userModel, tokenBlacklistModel } = require('../models');
const utils = require('../utils');
const { authCookieName } = require('../app-config');

const bsonToJson = (data) => { return JSON.parse(JSON.stringify(data)) };

const removePassword = (data) => {
    const { password, __v, ...userData } = data;
    return userData
}

function register(req, res, next) {
    const { email, name, password, imgUrl, genre } = req.body;

    return userModel.create({ email, name, password, imgUrl, genre })
        .then((createdUser) => {
            createdUser = bsonToJson(createdUser);
            createdUser = removePassword(createdUser);

            const token = utils.jwt.createToken({ id: createdUser._id });

            if (process.env.NODE_ENV === 'production') {
                res.cookie(authCookieName, token, { httpOnly: true, sameSite: 'none', secure: true })
            } else {
                res.cookie(authCookieName, token, { httpOnly: true })
            }

            res.status(200).send(createdUser);
        })
        .catch(err => {
            if (err.name === 'MongoError' && err.code === 11000) {
                let field = err.message.split("index: ")[1];

                field = field.split(" dup key")[0];
                field = field.substring(0, field.lastIndexOf("_"));

                res.status(409).send({ message: `This ${field} is already registered!` });
                return;
            }

            next(err);
        });
}

function login(req, res, next) {
    const { email, password } = req.body;

    userModel.findOne({ email })
        .then(user => {
            return Promise.all([user, user ? user.matchPassword(password) : false]);
        })
        .then(([user, match]) => {
            if (!match) {
                res.status(401).send({ message: 'Wrong email or password' });
                return;
            }

            user = bsonToJson(user);
            user = removePassword(user);

            const token = utils.jwt.createToken({ id: user._id });

            if (process.env.NODE_ENV === 'production') {
                res.cookie(authCookieName, token, { httpOnly: true, sameSite: 'none', secure: true })
            } else {
                res.cookie(authCookieName, token, { httpOnly: true })
            }

            res.status(200).send(user);
        })
        .catch(next);
}

function logout(req, res) {
    const token = req.cookies[authCookieName];
    res.clearCookie(authCookieName).status(200).send({ message: 'Logged out!' });
}

function getProfileInfo(req, res, next) {
    const { _id: userId } = req.user;

    userModel.findOne({ _id: userId }, { password: 0, __v: 0 })
        .then(user => {
            res.status(200).json(user)
        })
        .catch(next);
}

function getUser(req, res, next) {
    const { userId } = req.params;
   
    userModel.findById(userId)
        .populate('posts')
        .then(user => res.status(200).json(user))
        .catch(next);
}

function getUsers(req, res, next) {
    userModel.find()
        .populate('posts')
        .then(user => res.status(200).json(user))
        .catch(next);
}

function editProfileInfo(req, res, next) {
    const { _id: userId } = req.user;
    const { id: id } = req.user;
    const { name, email, imgUrl, genre } = req.body;

    var done = false;

    userModel.findOne({ email })
        .then((user) => {
            if (!user || user.id === id) {
                done = true;
                userModel.findOneAndUpdate({ _id: userId }, { name, email, imgUrl, genre }, { runValidators: true, new: true })
                    .then(x => {
                        res.status(200).json(x);
                    })
                    .catch(next);
            }
            if (!done && user.userId !== userId) {
                res.status(401)
                    .send({ message: 'There is already a user, registered with that email address' });
            }
        })
        .catch(next);
}

module.exports = {
    login,
    register,
    logout,
    getProfileInfo,
    editProfileInfo,
    getUser,
    getUsers
}
