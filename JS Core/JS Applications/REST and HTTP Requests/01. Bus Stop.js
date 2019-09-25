function getInfo() {
      $("#buses").empty();
      let stopID = $("#stopId").val();
      $.get(`https://judgetests.firebaseio.com/businfo/${stopID}.json`)
        .then(displayContent)
        .catch(displayError);

      function displayContent(busStop) {
        $("#stopName").text(busStop.name);
        for (let bus in busStop.buses) {
          $("#buses").append($("<li>").text(`Bus ${bus} arrives in ${busStop.buses[bus]} minutes`));
        }
      }

      function displayError() {
        $("#stopName").text("Error");
      }

    }