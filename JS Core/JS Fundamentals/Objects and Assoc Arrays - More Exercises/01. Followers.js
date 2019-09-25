function printCatalogue(input) {
    let accounts = new Map;
    for (let line of input){
        if(line.startsWith("Welcome, ")){
            let inputParams = line.split(' ').filter(x => x !== "");
            let account = inputParams[1];
            if (!accounts.has(account)) {
                accounts.set(account, [[], []]); //първия array е за кои follow-ва, а втория за кои го follow-ват
            }
        } else {
            let inputParams = line.split(' followed ').filter(x => x !== "");
            let follower = inputParams[0];
            let isFollowed = inputParams[1];
            if (accounts.has(follower) && accounts.has(isFollowed) && follower != isFollowed) {
                if(!accounts.get(follower)[0].includes(isFollowed)){
                    accounts.get(follower)[0].push(isFollowed);
                    accounts.get(isFollowed)[1].push(follower);
                }
            }
        }
    }
        
    function sortAccounts(acc1, acc2) {
        if(accounts.get(acc2)[1].length < accounts.get(acc1)[1].length){
            return accounts.get(acc2)[1].length - accounts.get(acc1)[1].length
        }
        if(accounts.get(acc2)[1].length > accounts.get(acc1)[1].length){
            return accounts.get(acc2)[1].length - accounts.get(acc1)[1].length;
        }

        return acc2.localeCompare(acc1);
    }
    let sortedAccounts = [...accounts.keys()].sort((a, b) => sortAccounts(a, b));
    console.log("Total users registered: " + [...accounts.keys()].length);
    let cnt = 1;
    for (let account of sortedAccounts) {
        console.log(cnt + ". " + account + " : " + accounts.get(account)[0].length + " following, " + accounts.get(account)[1].length + " followers");
        if(cnt == 1){
            for (let follower of accounts.get(account)[1].sort()){
                console.log("*  " + follower);
            }
        }
        cnt++;
    }
}