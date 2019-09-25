const home = (function () {
    const index = function (ctx) {
        if (userModel.isAuthorized()) {
            $(".first-bar").show();
            $(".second-bar").show();
            $(".navbar-anonymous").hide();
        } else {
            $(".first-bar").hide();
            $(".second-bar").hide();
            $(".navbar-anonymous").show();
        }
        ctx.partial('views/home/home.hbs');
    };

    return {
        index
    };
}());