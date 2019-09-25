function calcSpeed(input) {
    let x1 = input[0];
    let y1 = input[1];
    let x2 = input[2];
    let y2 = input[3];

    if(Number.isInteger(calcDistance(x1, y1, 0, 0))){
        console.log(`{${x1}, ${y1}} to {0, 0} is valid`);
    }
    else{
        console.log(`{${x1}, ${y1}} to {0, 0} is invalid`);
    } 

    if(Number.isInteger(calcDistance(x2, y2, 0, 0))){
        console.log(`{${x2}, ${y2}} to {0, 0} is valid`);
    }
    else{
        console.log(`{${x2}, ${y2}} to {0, 0} is invalid`);
    }

    if(Number.isInteger(calcDistance(x1, y1, x2, y2))){
        console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is valid`);
    }
    else{
        console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is invalid`);
    }

    function calcDistance(x1, y1, x2, y2){
        let result = Math.sqrt((Math.pow((Math.abs(x1 - x2)), 2) + (Math.pow((Math.abs(y1 - y2)), 2))));
        return result;
    } 
}