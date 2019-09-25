function attachEvents() {
  let symbols = {
    Sunny: "&#x2600;",
    "Partly sunny": "&#x26C5;",
    Overcast: "&#x2601;",
    Rain: "&#x2614;",
    Degrees: "&#176;"
  };

  $("#submit").on("click", getWeather);

  async function getWeather() {
    let cities = await $.get("https://judgetests.firebaseio.com/locations.json");
    let searchedCity = $("#location").val();
    for (let city of cities) {
      if (city.name === searchedCity) {
        searchedCity = city;
        break;
      }
    }
    if (typeof searchedCity === "string") {
      $("#forecast").empty();
      $("#forecast").text("Error");
    } else {
      let [todaysForecast, upcomingForecast] = await Promise.all([$.get(`https://judgetests.firebaseio.com/forecast/today/${searchedCity.code}.json`), $.get(`https://judgetests.firebaseio.com/forecast/upcoming/${searchedCity.code}.json`)]);
      getForecast(todaysForecast);
      getUpcomingForecast(upcomingForecast);
    }
  }



  function getForecast(todaysForecast) {
    $("#current")
      .empty()
      .append($('<div class="label">Current conditions</div>'));
    let conditionSymbol = $(
      `<span class="condition symbol">${symbols[todaysForecast.forecast.condition]}</span>`
    );
    let condition = $("<span>")
      .addClass("condition")
      .append($(`<span class="forecast-data">${todaysForecast.name}</span>`))
      .append(
        $(
          `<span class="forecast-data">${todaysForecast.forecast.low}${
            symbols["Degrees"]
          }/${todaysForecast.forecast.high}${symbols["Degrees"]}</span>`
        )
      )
      .append(
        $(`<span class="forecast-data">${todaysForecast.forecast.condition}</span>`)
      );
    $("#current")
      .append(conditionSymbol)
      .append(condition);
  }

  function getUpcomingForecast(upcomingForecast) {
    $("#upcoming")
      .empty()
      .append($('<div class="label">Three-day forecast</div>'));
    for (let forecast of upcomingForecast.forecast) {
      let upcoming = $("<span>")
        .addClass("upcoming")
        .append($(`<span class="symbol">${symbols[forecast.condition]}</span>`))
        .append(
          $(
            `<span class="forecast-data">${forecast.low}${symbols["Degrees"]}/${
              forecast.high
            }${symbols["Degrees"]}</span>`
          )
        )
        .append($(`<span class="forecast-data">${forecast.condition}</span>`));

      $("#upcoming").append(upcoming);
    }
    $("#forecast").css("display", "");
  }
}