const user = (function () {
    const getLogin = function (ctx) {
        ctx.partial('views/user/login.hbs');
    };

    const postLogin = function (ctx) {
        var username = ctx.params.username;
        var password = ctx.params.password;

        userModel.login(username, password).then(function (data) {
            storage.saveUser(data);
            $("#profile").show();
            $("#create-meme").show();
            $("#myProfileLink").attr("href", `#/users/profile?id=${storage.getData('userInfo').id}`);

            ctx.redirect('#/memes/all');
            showInfo("Login successful.");
            $($("#profile a")[0]).text("Welcome " + username);
        }).catch(error => handleError(error));

    };

    const logout = function (ctx) {
        userModel.logout().done(function () {
            storage.deleteUser();
            showInfo("Logout successful.");
            $("#profile").hide();
            $("#create-meme").hide();
            ctx.redirect('#/login');
        });
    }

    const getRegister = function (ctx) {
        ctx.partial('views/user/register.hbs');
    };

    const postRegister = function (ctx) {
        userModel.register(ctx.params).then(function (data) {
            storage.saveUser(data);
            $("#profile").show();
            $("#create-meme").show();
            $("#myProfileLink").attr("href", `#/users/profile?id=${storage.getData('userInfo').id}`);

            showInfo("User registration successful.");
            $($("#profile a")[0]).text("Welcome " + ctx.params.username);
            ctx.redirect('#/memes/all');
        }).catch(error => handleError(error));
    }

    const getProfile = function (ctx) {
        userModel.getUser(ctx.params.id).then(function (data) {
            ctx.item = data;
            if (ctx.params.id == storage.getData('userInfo').id) {
                ctx.item.myProfile = true;
            }
            memeModel.getByCreatorName(data.username).then(function (data2) {
                ctx.item.memes = data2;
                if (ctx.params.id == storage.getData('userInfo').id) {
                    for (let i = 0; i < data2.length; i++) {
                        ctx.item.memes[i].mine = true;
                    }
                }
                ctx.partial('views/user/profile.hbs');
            })
        });
    };

    const deleteProfile = function (ctx) {
        userModel.logout().done(function () {
            userModel.deleteUser(ctx.params.id).then(function () {
                storage.deleteUser();
                $("#profile").hide();
                $("#create-meme").hide();
                showInfo("User deleted.");
                ctx.redirect('#/login');
            });
        });
    };

    return {
        getLogin,
        postLogin,
        logout,
        getRegister,
        postRegister,
        getProfile,
        deleteProfile
    };
}());