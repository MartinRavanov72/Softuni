function orbit(input) {
    let catalogue = new Map;
    for (let i = 0; i < input.length; i++) {
        let current = input[i].split(' : ');
        let productName = current[0];
        let productPrice = +current[1];
        let productFirstLetter = productName[0];
        if (!catalogue.has(productFirstLetter)) {
            catalogue.set(productFirstLetter, new Map())
        }
        if (!catalogue.get(productFirstLetter).has(productName)) {
            catalogue.get(productFirstLetter).set(productName, 0)
        }
        catalogue.get(productFirstLetter).set(productName, productPrice)
    }
    function alphabeticalSort(a, b) {
        return a.localeCompare(b);
    }
    let sortedInitials = [...catalogue.keys()].sort(alphabeticalSort);

    for (let key of sortedInitials) {
        console.log(key);
        let sortedProdcuts = [...catalogue.get(key).keys()].sort(alphabeticalSort);
        for (let product of sortedProdcuts) {
            console.log("  " + product + ": " + catalogue.get(key).get(product));
        }
    }
}