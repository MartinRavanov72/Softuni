function printCatalogue(input) {
    let flights = new Map;
    for(let i = 0; i < input.length; i++){
        if(i == 0){
            for (let line of input[i]){
                let inputParams = line.split(" ");
                let code = inputParams[0];
                let destination = inputParams[1];
                if(!flights.has(code)){
                    flights.set(code, new Map);
                    flights.get(code).set(destination, "Ready to fly");
                }
            }
        } else if(i == 1){
            for (let line of input[i]){
                let inputParams = line.split(" ");
                let code = inputParams[0];
                let status = inputParams[1];
                if(flights.has(code)){
                    let key = [...flights.get(code).keys()][0];
                    flights.get(code).set(key, status);
                }
            }
        } else {
            for (let searched of input[i]){
                let codesSearched = [...flights.keys()].filter(a => [...flights.get(a).values()][0] == searched);
                for (let code of codesSearched){
                    let str = "{ Destination: \'" + [...flights.get(code).keys()][0] + "\', Status: \'" + [...flights.get(code).values()][0] + "\' }";
                    console.log(str);
                }
            }
        }
    }
}