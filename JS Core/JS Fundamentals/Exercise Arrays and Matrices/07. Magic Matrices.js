function calc(matrix) {
    let isMagical = true;
    let sum = matrix[0].reduce((a, b) => a + b, 0);
    for(let row = 0; row < matrix.length; row++){
        let currentSum = matrix[row].reduce((a, b) => a + b, 0);
        if(currentSum !== sum){
            isMagical = false;
            break;
        } 
    }
    for(let  column = 0; column < matrix[0].length; column++){
        let currentSum = 0;
        for(let row = 0; row < matrix.length; row++){
            currentSum += matrix[row][column];
        }
        if(currentSum !== sum){
            isMagical = false;
            break;
        }
    }
    console.log(isMagical);
}