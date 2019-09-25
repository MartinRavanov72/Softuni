const user = (function () {
    const getLogin = function (ctx) {
        ctx.partial('views/user/login.hbs');
    };

    const postLogin = function (ctx) {
        var username = ctx.params.username;
        var password = ctx.params.password;

        userModel.login(username, password).then(function (data) {
            storage.saveUser(data);
            $(".first-bar").show();
            $(".second-bar").show();
            $(".navbar-anonymous").hide();

            ctx.redirect('#/home');
            showInfo("Login successful.");
            $($(".second-bar ul li")[0]).text("Welcome, " + username + "!");
        }).catch(error => handleError(error));

    };

    const logout = function (ctx) {
        userModel.logout().done(function () {
            storage.deleteUser();
            showInfo("Logout successful.");
            $(".first-bar").hide();
            $(".second-bar").hide();
            $(".navbar-anonymous").show();

            ctx.redirect('#/home');
        });
    }

    const getRegister = function (ctx) {
        ctx.partial('views/user/register.hbs');
    };

    const postRegister = function (ctx) {
        userModel.register(ctx.params).then(function (data) {
            storage.saveUser(data);
            $(".first-bar").show();
            $(".second-bar").show();
            $(".navbar-anonymous").hide();

            ctx.redirect('#/home');
            showInfo("User registration successful.");
            $($(".second-bar ul li")[0]).text("Welcome, " + ctx.params.username + "!");
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