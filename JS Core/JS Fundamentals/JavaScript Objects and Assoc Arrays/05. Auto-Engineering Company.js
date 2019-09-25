function orbit(input) {
    let cars = new Map;
    for (let i = 0; i < input.length; i++) {
        let line = input[i].split(' | ');
        let brand = line[0];
        let model = line[1];
        let producedNum = +line[2];
        if (!cars.has(brand)) {
            cars.set(brand, new Map())
        }
        if (!cars.get(brand).has(model)) {
            cars.get(brand).set(model, 0)
        }
        cars.get(brand).set(model, cars.get(brand).get(model) + producedNum)
    }

    for (let [key,value] of cars) {
        console.log(key);
        for (let [model,number] of value) {
            console.log("###" + model + " -> " + number);
        }
    }
}