function calcSpeed(input) {
    let number = +input[0];

    function getFunction(operation, num){
        switch(operation){
            case "chop" : return chop(num);
            case "dice" : return dice(num);
            case "spice" : return spice(num);
            case "bake" : return bake(num);
            case "fillet" : return fillet(num);
        }
    }
    
    function chop(num){
        return num / 2;
    }

    function dice(num){
        return Math.sqrt(num);
    }

    function spice(num){
        return num + 1;
    }

    function bake(num){
        return num * 3;
    }

    function fillet(num){
        return num * 0.8;
    }

    for(let i = 1; i < input.length; i++){
        let result = getFunction(input[i], number);
        console.log(result);
        number = result;
    }

}