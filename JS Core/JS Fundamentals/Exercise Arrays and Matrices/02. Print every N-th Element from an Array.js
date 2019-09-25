function calc(arr) {
    let n = arr.pop();
    for(let i = 0; i < arr.length; i++){
        if(i%n === 0){
            console.log(arr[i]);
        }
    }
}