function printWinningKingdom(inputGenerals, battles) {
    let kingdoms = new Map();
    for (let line of inputGenerals) {
        if (!kingdoms.has(line.kingdom)) {
            kingdoms.set(line.kingdom, []);
        }
        let allGeneralsInKingdom = kingdoms.get(line.kingdom);
        let currentGeneral = allGeneralsInKingdom.filter(g => g.general === line.general)[0];
        if (!currentGeneral) {
            currentGeneral = {
                general: line.general,
                army: line.army,
                kingdom: line.kingdom,
                wins: 0,
                loses: 0
            }
            kingdoms.get(line.kingdom).push(currentGeneral);
        } else {
            currentGeneral.army += line.army;
        }
    }
    function getGeneral(kingdomName, generalName) {
        let currentKingdom = kingdoms.get(kingdomName);
        if (!currentKingdom) {
            return null;
        }
        let general = currentKingdom.filter(g => g.general === generalName);
        if (general.length === 0) {
            return null;
        }
        return general[0];
    }

    for (let i = 0; i < battles.length; i++) {
        let attacker = getGeneral(battles[i][0], battles[i][1]);
        let defender = getGeneral(battles[i][2], battles[i][3]);
        if (attacker === null || defender === null ||
            attacker.kingdom === defender.kingdom ||
            attacker.army === defender.army) {
            continue;
        }
        if (attacker.army > defender.army) {
            attacker.wins++;
            attacker.army = Math.floor(attacker.army * 1.10);
            defender.loses++;
            defender.army = Math.floor(defender.army * 0.90);
        } else {
            defender.wins++;
            defender.army = Math.floor(defender.army * 1.10);
            attacker.loses++;
            attacker.army = Math.floor(attacker.army * 0.90);
        }
    }

    let winningKingdom = [...kingdoms.keys()].sort((a, b) => {
            let secondWins = kingdoms.get(b).map(g => g.wins).reduce((g1, g2) => g1 + g2);
            let firstWins = kingdoms.get(a).map(g => g.wins).reduce((g1, g2) => g1 + g2);
            let winsDiff = secondWins - firstWins;
            if (winsDiff !== 0) {
                return winsDiff;
            }
            let firstLosses = kingdoms.get(a).map(g => g.loses).reduce((g1, g2) => g1 + g2);
            let secondLosses = kingdoms.get(b).map(g => g.loses).reduce((g1, g2) => g1 + g2);
            let lossesDif = firstLosses - secondLosses;
            if (lossesDif !== 0) {
                return lossesDif;
            }
            return a.localeCompare(b);
        })[0];

    console.log("Winner: " + winningKingdom);
    let winningGenerals = kingdoms.get(winningKingdom).sort((a, b) => b.army - a.army)
    for (let general of winningGenerals) {
        console.log("/\\general: " + general.general);
        console.log("---army: " + general.army);
        console.log("---wins: " + general.wins);
        console.log("---losses: " + general.loses);
    }
}