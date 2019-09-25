function print(input) {
    let pilots = new Map;
    for (let line of input){
        let inputParams = line.split(" -> ");
        let team = inputParams[0];
        let pilot = inputParams[1];
        let points = +inputParams[2];
        if(!pilots.has(team)){
            pilots.set(team, new Map);
        }
        if(!pilots.get(team).has(pilot)){
            pilots.get(team).set(pilot, 0);
        }
        pilots.get(team).set(pilot, pilots.get(team).get(pilot) + points);
    }
 
    let allSortedTeams = [...pilots.keys()].sort((a, b) => [...pilots.get(b).values()].reduce((x, y) => x+y) - [...pilots.get(a).values()].reduce((x, y) => x+y));
    let sortedTeams = [];
    for(let i = 0; i < 3; i++){
        sortedTeams.push(allSortedTeams[i]);
    }
    for (let team of sortedTeams) {
        console.log(team + ": " + [...pilots.get(team).values()].reduce((a, b) => a + b));
        let sortedPilots = [...pilots.get(team).keys()].sort((a, b) => pilots.get(team).get(b) - pilots.get(team).get(a));
        for (let pilot of sortedPilots) {
            console.log("-- " + pilot + " -> " + pilots.get(team).get(pilot));
        }
    }
}