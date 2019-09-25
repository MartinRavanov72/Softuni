function printName(params) {
    if(params[1] > 15){
        params[1] = 15;
    }
    let result = Math.round(params[0] * Math.pow(10, params[1])) / Math.pow(10, params[1]);
    console.log(result);
}