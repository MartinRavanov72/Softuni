function orbit(input) {
    let systems = new Map;
    for (let i = 0; i < input.length; i++) {
        let line = input[i].split(' | ');
        let system = line[0];
        let comp = line[1];
        let subcomp = line[2];
        if (!systems.has(system)) {
            systems.set(system, new Map())
        }
        if (!systems.get(system).has(comp)) {
            systems.get(system).set(comp, [])
        }
        systems.get(system).get(comp).push(subcomp);
    }

    function sortSystemComparator(sysA, sysB, systems) {
        let aComponents = systems.get(sysA).size;
        let bComponents = systems.get(sysB).size;
        if (aComponents > bComponents){
            return -1;
        } 
        if (aComponents < bComponents){
            return 1;
        }
        return sysA.toLowerCase().localeCompare(sysB.toLowerCase());
    }

    let sortedSystems = [...systems.keys()].sort((a, b) => sortSystemComparator(a, b, systems));
    for (let system of sortedSystems) {
        console.log(system);
        let components = [...systems.get(system).keys()].sort((s1, s2) => systems.get(system).get(s2).length - systems.get(system).get(s1).length);
        for (let component of components) {
            console.log(`|||${component}`);
            for (let subComponent of systems.get(system).get(component)) {
                console.log(`||||||${subComponent}`);
            }
        }
    }
}