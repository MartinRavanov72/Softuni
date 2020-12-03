const { Course, User } = require('../models');
const { values } = require('../utils/loginMiddlewareValidator');
const { formValidator } = require('../utils');

module.exports = {
    get: {
        all(req, res, next) {
            Course
                .find()
                .sort({ "createdAt": 1 })
                .lean()
                .then((courses) => {
                    res.render('./home/home-user.hbs', { courses });
                })
                .catch((e) => res.render('./home/home-user.hbs', { message: e }));
        },

        
        create(req, res, next) {
            res.render('./courses/create.hbs');
        },

        details(req, res, next) {
            Course.findOne({ _id: req.params.courseId })
                .lean()
                .then((course) => {
                    var condition = false;
                    for (let i = 0; i < course.usersEnrolled.length; i++) {
                        const element = (String)(course.usersEnrolled[i]);
                        if(element === (String)(req.user._id)){
                            condition = true;
                            break;
                        }
                    }

                    res.render('./courses/details.hbs', { ...course, isCreator: (String)(course.creator) == (String)(req.user._id), isEnrolled: condition });
                })   
                .catch((e) => res.render('./courses/details.hbs', { message: e }));
        },

        edit(req, res, next) {
            Course.findOne({ _id: req.params.courseId})
                .lean()
                .then((course) => {
                    if ((String)(req.user._id) == (String)(course.creator)) {
                        res.render('./courses/edit.hbs', { ...course});
                    } else {
                        throw new Error("Only creators can edit this");
                    }
                }).catch((e) => res.render('./home/home-user.hbs', { message: e }));
        },

        delete(req, res, next) {
            Course.findOne({ _id: req.params.courseId })
                .then((course) => {
                    if((String)(req.user._id) == (String)(course.creator)){
                        Course.deleteOne({ _id: req.params.courseId })
                            .then((result) => {
                                res.redirect('/courses/all');
                            }).catch((e) => console.log(e));
                    } else {
                        throw new Error("Only creators can delete this");
                    } 
                }).catch((e) => res.render('./home/home-user.hbs', { message: e }));
        },

        enroll(req, res, next) {
            const { courseId } = req.params;

            Course.findOne({ _id: req.params.courseId })
                .then((course) => {
                    if ((String)(req.user._id) != (String)(course.creator)) {
                        var condition = false;
                        for (let i = 0; i < course.usersEnrolled.length; i++) {
                            const element = (String)(course.usersEnrolled[i]);
                            if(element === (String)(req.user._id)){
                                condition = true;
                                break;
                            }
                        }
                        if (!condition) {
                            Promise.all([
                                Course.updateOne({ _id: req.params.courseId }, { $push: { usersEnrolled: req.user._id } }),
                                User.updateOne({ _id: req.user._id }, { $push: { enrolledCourses: req.params.courseId } })
                            ])
                                .then((result) => {
                                    res.redirect(`/courses/details/${courseId}`);
                                }).catch((e) => res.render('./home/home-user.hbs', { message: e }));
                        } else {
                            throw new Error("You can enroll in the course only once");
                        }
                    } else {
                        throw new Error("Creators cannot enroll in their courses");
                    } 
                }).catch((e) => res.render('./home/home-user.hbs', { message: e }));
        }
    },
    
    post: {
        allQuery(req, res, next) {
            Course
                .find({ title: { $regex: `.*${req.body.query}.*`, $options: "i" } })
                .sort({ "createdAt": 1 })
                .lean()
                .then((courses) => {
                    res.render('./home/home-user.hbs', { courses });
                })
                .catch((e) => res.render('./home/home-user.hbs', { message: e }));
        },

        create(req, res, next) {
            const formValidations = formValidator(req);
            
            if(!formValidations.isOK){
                res.render('./courses/create.hbs', formValidations.contextOptions);
                return;
            }

            const { title } = { ...req.body };

            Course
                .findOne({ title })
                .then((course) => {
                    if (course) {
                        res.render('./courses/create.hbs', { message: "The given title is already being used" });
                    }

                    const { courseId } = req.params;

                    return Course.create({ ...req.body, creator: req.user._id, createdAt: Date.now() });
                })
                .then((createdCourse) => {
                    res.redirect('/courses/all');
                })
                .catch((e) => {
                    console.log(e);
                    res.render('./courses/create.hbs', { message: e });
                });     
        },

        edit(req, res, next) {
            const formValidations = formValidator(req);
            
            if (!formValidations.isOK) {
                res.render('./courses/edit.hbs', { ...formValidations.contextOptions, _id: req.params.courseId});
                console.log(formValidations.contextOptions);
                return;
            }

            const { title } = { ...req.body };
            
            Course
                .findOne({ title })
                .then((course) => {
                    if (course) {
                        res.render('./courses/edit.hbs', { message: "The given title is already being used" , _id: req.params.courseId });
                    }

                    const { courseId } = req.params;
                    return Course.updateOne({ _id: req.params.courseId }, { $set: {...req.body}})                    
                })
                .then((updatedCourse) => {
                    res.redirect(`/courses/details/${req.params.courseId}`);
                })
                .catch((e) => {
                    console.log(e);
                    res.render('./courses/edit.hbs', { message: e });
                });   
        }
    }
};