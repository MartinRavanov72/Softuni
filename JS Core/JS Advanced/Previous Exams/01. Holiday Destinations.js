function addDestination() {
  let city = $($(".inputData")[0]).val();
  let country = $($(".inputData")[1]).val();
  let season = $("#seasons").val();
  if (!(country && country)) {
  } else {
    $("#destinationsList").append(
      $("<tr>")
        .append($("<td>").text(city + ", " + country))
        .append($("<td>").text(season.charAt(0).toUpperCase() + season.slice(1)))
    );

    if (season === "summer") {
      $("#summer").val(+$("#summer").val() + 1);
    } else if (season === "autumn") {
      $("#autumn").val(+$("#autumn").val() + 1);
    } else if (season === "winter") {
      $("#winter").val(+$("#winter").val() + 1);
    } else {
      $("#spring").val(+$("#spring").val() + 1);
    }

    $($(".inputData")[0]).val("");
    $($(".inputData")[1]).val("");
  }
}
