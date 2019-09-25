const home = (function () {
    const index = function (ctx) {
        ctx.partial('views/home/home.hbs');
        if (userModel.isAuthorized()) {
            $("#profile").show();
            $("#all-listings").show();
            $("#my-listings").show();
            $("#create-listing").show();
        } else {
            $("#profile").hide();
            $("#all-listings").hide();
            $("#my-listings").hide();
            $("#create-listing").hide();
        }
    };

    return {
        index
    };
}());