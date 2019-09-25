function solve() {
      let currentId = "depot";
      let currentStopName;
      let departButton = $("#depart");
      let arriveButton = $("#arrive");
      let span = $(".info");

      function depart(params) {
        $.get(`https://judgetests.firebaseio.com/schedule/${currentId}.json `)
          .then((resource) => {
            departButton.attr("disabled", true);
            arriveButton.attr("disabled", false);
            currentId = resource.next;
            currentStopName = resource.name;
            span.text("Next Stop " + currentStopName);
          })
          .catch(() => {
            span.text("Error");
            departButton.attr("disabled", true);
            arriveButton.attr("disabled", true);
          });
      }

      function arrive(params) {
        span.text("Arriving at " + currentStopName);
        departButton.attr("disabled", false);
        arriveButton.attr("disabled", true);
      }
      return {
        depart,
        arrive
      };
    }