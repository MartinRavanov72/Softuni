function orbit(input) {
    let usernames = new Set;
    for (let name of input) {
        usernames.add(name);
    }

    function compareNames(nameA,nameB) {
        if (nameA.length < nameB.length) {
            return -1;
        }
        if (nameA.length > nameB.length) {
            return 1;
        }
        return nameA.localeCompare(nameB);
    }

    console.log([...usernames].sort(compareNames).join('\n'));
}