function calc(arr) {
    let n = arr.pop();
    n = n % arr.length;
    for(let i = 0; i < n; i++){
        let el = arr.pop();
        arr.unshift(el);
    }
    console.log(arr.join(" "));
}

