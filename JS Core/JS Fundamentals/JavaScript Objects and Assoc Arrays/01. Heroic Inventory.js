function orbit(input) {
    let result = [];
    for (let i = 0; i < input.length; i++) {
        let currentHeroArguments = input[i].split(' / ');
        let curentHeroName = currentHeroArguments[0];
        let curentHeroLevel = +currentHeroArguments[1];
        let curentHeroItems = [];
        if (currentHeroArguments.length > 2) {
            curentHeroItems = currentHeroArguments[2].split(', ');
        }
        let hero={
            name:curentHeroName,
            level:curentHeroLevel,
            items:curentHeroItems
        };
        result.push(hero);
    }
    console.log(JSON.stringify(result));
}