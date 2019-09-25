const home = (function () {
    const index = function (ctx) {
        ctx.partial('views/home/home.hbs');
        if (userModel.isAuthorized()) {
            $("#profile").show();
            $("#create-meme").show();
        } else {
            $("#profile").hide();
            $("#create-meme").hide();
        }
    };

    return {
        index
    };
}());