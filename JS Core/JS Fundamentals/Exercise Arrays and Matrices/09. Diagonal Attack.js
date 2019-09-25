function calc(arr) {
    let n = arr.length;
    let matrix = [];
    for(let i = 0; i < n; i++){
        matrix[i] = arr[i].split(" ");
    }
    let firstSum = 0;
    for(let row = 0; row < n; row++){
        for(let col = 0; col < n; col++){
            if(row === col){
                firstSum+= +matrix[row][col];
            }
        }
    }
    let secondSum = 0;
    for(let row = n - 1; row >= 0; row--){
        for(let col = n - 1; col >= 0; col--){
            if(row === col){
                secondSum+= +matrix[row][col];
            }
        }
    }
    if(firstSum !== secondSum){
        console.log(matrix.map(row => row.join(' ')).join('\n'));
    }else{
        for(let row = 0; row < n; row++){
            for(let col = 0; col < n; col++){
                if((row !== col) && (row !== n - 1 - col)){
                    matrix[row][col] = firstSum;
                }
            }
        }
        console.log(matrix.map(row => row.join(' ')).join('\n'));
    }
}