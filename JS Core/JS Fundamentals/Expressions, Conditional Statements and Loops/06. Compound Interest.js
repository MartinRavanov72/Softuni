function printName(params) {
    let result = params[0]*(Math.pow((1 + params[1]/((12/params[2])*100)), (12/params[2])*params[3]));
    console.log(Math.round(result * 100)/100);
}