function print(input, commands) {
    let matrix = [];
    for(let i = 0; i < input.length; i++){
        matrix[i] = input[i].split(/\s+/g).map(x => parseInt(x));
    }
    for (let line of commands){
        let inputParams = line.split(/\s+/g);
        let index = +inputParams[1];
        let command = inputParams[0];
        if(command == "breeze"){
            let lineInMatrix = matrix[index];
            let newLineInMatrix = [];
            for (let el of lineInMatrix){
                newLineInMatrix.push(Math.max(0, el - 15));
            }
            matrix[index] = newLineInMatrix;
        }else if(command == "gale"){
            for(let i = 0; i < input.length; i++){
                for(let j = 0; j < input.length; j++){
                    if(j == index){
                        matrix[i][j] = Math.max(0, matrix[i][j] - 20);
                    }
                }
            }
        }else{
            for(let i = 0; i < input.length; i++){
                for(let j = 0; j < input.length; j++){
                    matrix[i][j] += index;
                }
            }
        }
    }
    let result = [];
    for(let i = 0; i < input.length; i++){
        for(let j = 0; j < input.length; j++){
            if(matrix[i][j] >= 50){
                result.push(`[${i}-${j}]`);
            }
        }
    }
    if(result.length == 0){
        console.log("No polluted areas");
    }else {
        console.log("Polluted areas: " + result.join(", "));
    }
}