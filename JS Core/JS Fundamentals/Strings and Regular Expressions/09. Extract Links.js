function orbit(arr) {
    let regex = /www\.[A-Za-z0-9-]+(\.[a-z]+)+/g;
    let result = [];
    for(let i = 0; i < arr.length; i++){
        let matches = arr[i].match(regex);
        if(matches != null){
            for (let el of matches){
                result.push(el);
            }
        }
    } 
    console.log(result.join("\n"));
}