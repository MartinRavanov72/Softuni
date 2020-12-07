const mongoose = require('mongoose');
const { ObjectId } = mongoose.Schema.Types;

const postSchema = new mongoose.Schema({
    text: {
        type: String,
        required: true,
        minlength: [5, 'Text content should be at least 5 characters long']
    },
    userId: {
        type: ObjectId,
        ref: "User"
    }
},
    { timestamps: { createdAt: 'created_at' } });

module.exports = mongoose.model('Post', postSchema);
