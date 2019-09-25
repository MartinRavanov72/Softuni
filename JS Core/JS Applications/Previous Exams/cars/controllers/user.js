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
            $("#all-listings").show();
            $("#my-listings").show();
            $("#create-listing").show();

            ctx.redirect('#/cars/all');
            showInfo("Login successful.");
            $($("#profile a")[0]).text("Welcome " + username);
        }).catch(error => handleError(error));

    };

    const logout = function (ctx) {
        userModel.logout().done(function () {
            storage.deleteUser();
            showInfo("Logout successful.");
            $("#profile").hide();
            $("#all-listings").hide();
            $("#my-listings").hide();
            $("#create-listing").hide();
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
            $("#all-listings").show();
            $("#my-listings").show();
            $("#create-listing").show();

            showInfo("User registration successful.");
            $($("#profile a")[0]).text("Welcome " + ctx.params.username);
            ctx.redirect('#/cars/all');
        }).catch(error => handleError(error));
    }

    return {
        getLogin,
        postLogin,
        logout,
        getRegister,
        postRegister,
    };
}());