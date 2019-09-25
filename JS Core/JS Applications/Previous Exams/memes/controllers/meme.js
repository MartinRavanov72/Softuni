const meme = (function () {
    const getCreate = function (ctx) {
        if (!userModel.isAuthorized()) {
            ctx.redirect('#/login');
        } else {
            ctx.partial('views/memes/createMeme.hbs');
        }
    };

    const postCreate = function (ctx) {
        memeModel.create(ctx.params).then(function () {
            ctx.redirect('#/memes/all');
            showInfo("Meme created.");
        });
    };

    const getEdit = function (ctx) {
        ctx.partial('views/memes/editMeme.hbs').then(function () {
            let form = $('#editForm');
            memeModel.getItem(ctx.params.id).then(function (data) {
                form.find('input[name="memeId"]').val(ctx.params.id);
                form.find('input[name="title"]').val(data.title);
                form.find('input[name="description"]').val(data.description);
                form.find('input[name="imageUrl"]').val(data.imageUrl);
            });
        });
    };

    const postEdit = function (ctx) {
        memeModel.edit(ctx.params, ctx.params.memeId).then(function () {
            ctx.redirect('#/memes/all');
            showInfo(`Meme ${ctx.params.title} updated.`);
        });
    };

    const all = function (ctx) {
        memeModel.getAll().then(function (data) {
            ctx.memes = data;
            for (let i = 0; i < data.length; i++) {
                if (data[i].creator === storage.getData('userInfo').username) {
                    ctx.memes[i].mine = true;
                } else {
                    ctx.memes[i].mine = false;
                }
                ctx.memes[i].creatorId = data[i]._acl.creator;
            }
            ctx.partial('views/memes/allMemes.hbs');
        });
    };

    const details = function (ctx) {
        memeModel.getItem(ctx.params.id).then(function (data) {
            ctx.item = data;
            if (data.creator === storage.getData('userInfo').username) {
                ctx.item.mine = true;
            } else {
                ctx.item.mine = false;
            }
            ctx.item.creatorId = data._acl.creator;
            ctx.partial('views/memes/memeDetails.hbs');
        });
    };

    const deleteItem = function (ctx) {
        memeModel.deleteItem(ctx.params.id).then(function () {
            ctx.redirect('#/memes/all');
            showInfo("Meme deleted.");
        });
    }

    return {
        getCreate,
        postCreate,
        getEdit,
        postEdit,
        all,
        details,
        deleteItem
    }
}());