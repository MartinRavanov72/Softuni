function travellersLog(input) {
    let travellersMoney = new Map;
    let travellersCountries = new Map;
    for (let line of input) {
        let tokens = line.split(/\s+/);
        if (tokens.length === 3) {
            let [travellerName, money] = [tokens[0], Number(tokens[2])];
            if (travellersMoney.has(travellerName) === false) {
                travellersMoney.set(travellerName, 0);
                travellersCountries.set(travellerName, new Map());
            }
            travellersMoney.set(travellerName, travellersMoney.get(travellerName) + money);
        } else {
            let [travellerName, landmark, country, money] = [tokens[0], tokens[3], tokens[5], Number(tokens[7])];
            if (travellersMoney.has(travellerName) === false) {
                travellersMoney.set(travellerName, 0);
                travellersCountries.set(travellerName, new Map());
            }
            if (travellersCountries.get(travellerName).has(country) === false && travellersMoney.get(travellerName) >= money) {
                travellersCountries.get(travellerName).set(country, [landmark]);
                travellersMoney.set(travellerName, travellersMoney.get(travellerName) - money);
            } else if (travellersCountries.get(travellerName).has(country) === true && travellersMoney.get(travellerName) >= money) {
                if (travellersCountries.get(travellerName).get(country).includes(landmark) === false) {
                    travellersCountries.get(travellerName).get(country).push(landmark);
                    travellersMoney.set(travellerName, travellersMoney.get(travellerName) - money);
                }
            }else if (travellersCountries.get(travellerName).has(country) === true &&
                travellersCountries.get(travellerName).get(country).includes(landmark) === true){
                    continue;
            }else{
                console.log("Not enough money to visit %s", landmark);
            }
        }
    }
 
    [...travellersMoney.keys()].sort((x, y) => travellersCountries.get(y).size - travellersCountries.get(x).size)
        .forEach(x => {
            console.log("%s visited %s countries and has %s money left", x, travellersCountries.get(x).size, travellersMoney.get(x));
            [...travellersCountries.get(x).keys()].sort((a, b) => travellersCountries.get(x).get(b).length - travellersCountries.get(x).get(a).length)
                .forEach(y => {
                    console.log("- %s -> %s landmarks", y, travellersCountries.get(x).get(y).length);
                    travellersCountries.get(x).get(y).sort().forEach(z => console.log("-- %s", z))
                })
        });
}