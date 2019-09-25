$(function () {

    renderCatTemplate();
    attachEventHandlers();

    function renderCatTemplate() {
        let source = $("#cat-template").html();
        let template = Handlebars.compile(source);
        let container = $("#allCats");
        let catsData = {
            cats: window.cats
        };
        let html = template(catsData);
        container.html(html);
    }

    function attachEventHandlers() {
        $("#allCats").children().find('.btn-primary').on("click", showStatusCode);
    }

    function showStatusCode(event) {
        let divStatusCode = $(event.target.parentNode).children()[1];
        $(divStatusCode).css("display", "");
        $(event.target)
            .off()
            .text("Hide status code")
            .on("click", hideStatusCode);

    }

    function hideStatusCode(event) {
        let divStatusCode = $(event.target.parentNode).children()[1];
        $(divStatusCode).css("display", "none");
        $(event.target)
            .off()
            .text("Show status code")
            .on("click", showStatusCode);
    }
})