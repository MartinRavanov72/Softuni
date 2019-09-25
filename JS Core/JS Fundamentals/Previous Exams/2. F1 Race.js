function print(input) {
    let pilots = [];
    for(let i = 0; i < input.length; i++){
        let inputParams = input[i].split(/\s+/g);
        if(i == 0){
            for (let pilot of inputParams){
                pilots.push(pilot);
            }
        }else {
            let action = inputParams[0];
            let pilot = inputParams[1];
            switch (action) {
                case "Join":
                    if(!pilots.includes(pilot)){
                        pilots.push(pilot);
                    }
                    break;
                case "Crash":
                    let index1 = pilots.indexOf(pilot);
                    if (index1 > -1) {
                    pilots.splice(index1, 1);
                    }
                break;
                case "Pit":
                    let index2 = pilots.indexOf(pilot);
                    if (index2 > -1 && index2 != pilots.length - 1) {
                        let pilotBehind = pilots[index2 + 1];
                        pilots[index2 + 1] = pilot;
                        pilots[index2] = pilotBehind;
                    }
                break;
                case "Overtake":
                    let index3 = pilots.indexOf(pilot);
                    if (index3 > -1 && index3 != 0) {
                        let pilotInFront = pilots[index3 - 1];
                        pilots[index3 - 1] = pilot;
                        pilots[index3] = pilotInFront;
                    }
                break;
            }
        }
    }
    console.log(pilots.join(" ~ "));
}