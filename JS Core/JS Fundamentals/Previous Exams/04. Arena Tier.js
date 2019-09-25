function run(arr){
    let gladiators = new Map;
    for (let line of arr){
        if(line === "Ave Cesar"){
            break;
        }
        
        if(line.includes(" -> ")){
            let inputParams = line.split(" -> ");
            let gladiator = inputParams[0].trim();
            let technique = inputParams[1].trim();
            let skill = +(inputParams[2].trim());
            if(!gladiators.has(gladiator)){
                gladiators.set(gladiator, new Map);
            }
            if(!gladiators.get(gladiator).has(technique)){
                gladiators.get(gladiator).set(technique, skill);
            }
            if(gladiators.get(gladiator).get(technique) < skill){
                gladiators.get(gladiator).set(technique, skill);
            }
        } else{
            let duelParams = line.split(" vs ");
            let gladiator1 = duelParams[0].trim();
            let gladiator2 = duelParams[1].trim();
            if (gladiators.has(gladiator1) && gladiators.has(gladiator2)){
                for (let [currentTechnique, currentSkill] of gladiators.get(gladiator1)){
                    if(gladiators.get(gladiator2).has(currentTechnique)){
                        if([...gladiators.get(gladiator1).values()].reduce((a, b) => a+b) > [...gladiators.get(gladiator2).values()].reduce((a, b) => a+b)){
                            gladiators.delete(gladiator2);
                            break;
                        } else{
                            gladiators.delete(gladiator1);
                            break;
                        }
                    }
                }
            }
        }
    }

    let sortedGladiators = [...gladiators.keys()].sort((a, b) => sortGladiators(a, b, gladiators));
    for (let gladiator of sortedGladiators) {
        console.log(gladiator + ": " + [...gladiators.get(gladiator).values()].reduce((a, b) => a + b) + " skill");
        let sortedTechniques = [...gladiators.get(gladiator).keys()].sort((a, b) => sortTechniques(a, b, gladiators, gladiator));
        for (let technique of sortedTechniques) {
            console.log("- " + technique + " <!> " + gladiators.get(gladiator).get(technique));
        }
    }


    function sortGladiators(g1, g2, gladiators) {
        let gladiatorSum1 = [...gladiators.get(g1).values()].reduce((a, b) => a+b);
        
        let gladiatorSum2 = [...gladiators.get(g2).values()].reduce((a, b) => a+b);
        if (gladiatorSum1 > gladiatorSum2){
            return -1;
        }
        if (gladiatorSum1 < gladiatorSum2){
            return 1;
        } 
        return g1.localeCompare(g2);
    }

    function sortTechniques(t1, t2, gladiators, currentGladiator) {
        if (gladiators.get(currentGladiator).get(t1) > gladiators.get(currentGladiator).get(t2)){
            return -1;
        } 
        if (gladiators.get(currentGladiator).get(t1) < gladiators.get(currentGladiator).get(t2)){
            return 1;
        } 
        return t1.localeCompare(t2);
    }
}