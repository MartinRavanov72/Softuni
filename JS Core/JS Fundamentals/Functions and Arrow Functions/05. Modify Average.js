function calcSpeed(input) {
    let number = +input + "";
    let avg = calcAvg(number.split(""));
    if(avg > 5){
        console.log(number);
    }
    else{
        while(avg <= 5){
            number += "9";
            avg = calcAvg(number.split(""));
        }
        console.log(number);
    }

    function calcAvg(numberCharArr){
        let sum = 0;
        for(let i = 0; i < numberCharArr.length; i++){
            sum += +numberCharArr[i];
        }
        return sum / numberCharArr.length;
    } 
}