function printName(num) {
    let result = (num * 0.9) % 360;
    if(result < 0){
        result = 360 + result;
    }
    console.log(result);
}