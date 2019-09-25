function printName(params) {
    let x = params[0];
    let y = params[1];
    let xMin = params[2];
    let xMax = params[3];
    let yMin = params[4];
    let yMax = params[5];
    let result = "outside";
    if(y >= yMin && y <= yMax && x >= xMin && x <= xMax){
        result = "inside";
    }
    console.log(result);
}