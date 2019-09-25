function attachEvents() {
  let button = $("#btnLoadTowns");
  button.on("click", loadTowns);

  function loadTowns() {
    let source = $("#towns-template").html();
    let template = Handlebars.compile(source);
    let container = $("#root");

    let data = $("#towns")
      .val()
      .split(", ")
      .filter(x => !(!x || 0 === x.length));

    if (data.length !== 0) {
      let townsObj = {
        towns: []
      };

      data.forEach(town => {
        townsObj.towns.push({
          name: town
        });
      });

      let html = template(townsObj);
      container.html(html);
    }

    $("#towns").val("");
  }
}