const { Course } = require('../models');

module.exports = {
    get: {
        home(req, res, next) {
            Course
                .find()
                .sort({ usersEnrolled: -1 })
                .limit(3)
                .lean()           
                .then((courses) => {
                    res.render('./home/home-guest.hbs', { courses });
                })
                .catch((e) => res.render('./home/home-guest.hbs', { message: e }));
        }
    },
    post: {}
};

