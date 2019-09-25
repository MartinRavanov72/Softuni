function calcSpeed(input) {

    let speedLimit = calcSpeedLimit(input[1]);
    calcSpeeding(input[0], speedLimit);

    function calcSpeedLimit(area){
        switch(area){
            case "motorway": return 130;
            case "interstate": return 90;
            case "city": return 50;
            case "residential": return 20;
        }
    }

    function calcSpeeding(speed, limit){
        if(speed - limit <= 0){
            return;
        } else if(speed - limit <= 20){
            console.log("speeding");
        } else if(speed - limit <= 40){
            console.log("excessive speeding");
        } else {
            console.log("reckless driving");
        }
    }  
}