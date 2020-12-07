const { userModel, postModel } = require('../models');

function newPost(text, userId) {
    return postModel.create({ text, userId })
        .then(post => {
            return Promise.all([
                userModel.updateOne({ _id: userId }, { $push: { posts: post._id } })
            ]);
        });
}

function getLatestsPosts(req, res, next) {
    const limit = Number(req.query.limit) || 0;

    postModel.find()
        .sort({ created_at: -1 })
        .limit(limit)
        .populate('userId')
        .then(posts => {
            res.status(200).json(posts)
        })
        .catch(next);
}

function createPost(req, res, next) {
    const { _id: userId } = req.user;
    const { postText } = req.body;

    newPost(postText, userId)
        .then((createdPost) => {
            res.status(200).send(createdPost)
        })
        .catch(next);
}

function editPost(req, res, next) {
    const { postId } = req.params;
    const { postText } = req.body;
    const { _id: userId } = req.user;

    postModel.findOneAndUpdate({ _id: postId, userId }, { text: postText }, { new: true })
        .then(updatedPost => {
            if (updatedPost) {
                res.status(200).json(updatedPost);
            }
            else {
                res.status(401).json({ message: `Not allowed to edit other bands' posts!` });
            }
        })
        .catch(next);
}

function deletePost(req, res, next) {
    const { postId } = req.params;
    const { _id: userId } = req.user;

    Promise.all([
        postModel.findOneAndDelete({ _id: postId, userId }),
        userModel.findOneAndUpdate({ _id: userId }, { $pull: { posts: postId } })
    ])
        .then(([deletedOne, _, __]) => {
            if (deletedOne) {
                res.status(200).json(deletedOne)
            } else {
                res.status(401).json({ message: `Not allowed to delete other bands' posts!` });
            }
        })
        .catch(next);
}

module.exports = {
    getLatestsPosts,
    newPost,
    createPost,
    editPost,
    deletePost
}
