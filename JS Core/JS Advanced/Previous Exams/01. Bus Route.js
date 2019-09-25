function busRoute() {
            let firstStop = +$($("#enter-stops label input")[0]).val();
            let secondStop = +$($("#enter-stops label input")[1]).val();
            let resultTable = $('#selected-bus-stops');
            let listBusStopsLength = $('#bus-stops').children().length;

            if (!((!firstStop && !secondStop) || (firstStop >= secondStop) || (firstStop <= 0) || (secondStop > listBusStopsLength))) {
                $("#selected-bus-stops").empty();
                $($("#enter-stops label input")[0]).val("");
                $($("#enter-stops label input")[1]).val("");
                $("#selected-route span").text(firstStop + "-" + secondStop);
                for (let i = firstStop - 1; i <= secondStop - 1; i++) {
                    $("#selected-bus-stops").append($("<li>").text(
                        $($("#bus-stops li")[i]).text()
                    ))
                }
            }
        }