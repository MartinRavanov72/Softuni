function calc(input) {
    let cnt = 1;
    let arr = [];
    for (let el of input){
        if (el === "add"){
            arr.push(cnt);
        } else {
            arr.pop();
        }
        cnt++;
    }
    if(arr.length === 0){
        console.log("Empty");
    }else {
        console.log(arr.join("\n"));
    }   
}

