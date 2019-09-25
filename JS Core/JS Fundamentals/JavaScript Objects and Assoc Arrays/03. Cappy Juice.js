function orbit(input) {
    let juices = new Map();
    let bottles = new Map();
    for (let line of input){
        let lineParams = line.split(" => ");
        if(juices.has(lineParams[0])){
            juices.set(lineParams[0], juices.get(lineParams[0]) + +lineParams[1]);
        } else {
            juices.set(lineParams[0], +lineParams[1]);
        }
        if(juices.get(lineParams[0]) >= 1000){
            let bottle = (parseInt(juices.get(lineParams[0]) / 1000));
            if(bottles.has(lineParams[0])){
                bottles.set(lineParams[0], bottles.get(lineParams[0]) + bottle);
            } else {
                bottles.set(lineParams[0], +bottle);
            }
            juices.set(lineParams[0], (juices.get(lineParams[0]) % 1000));
        }
    }
    for (let [key, value] of bottles){
        console.log(key + " => " + value);
    }
}