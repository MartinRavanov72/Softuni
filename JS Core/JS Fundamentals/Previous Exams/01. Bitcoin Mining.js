function print(input) {
    let totalGold = 0;
    let totalBitcoins = 0;
    let dayPurchased = 0;
    for(let i = 1; i <= input.length; i++){
        let grams = +input[i - 1];
        if(i % 3 == 0){
            grams *= 0.7;
        }
        totalGold += grams * 67.51;
        let bitcoinPurchased = parseInt(totalGold / 11949.16);
        if(bitcoinPurchased){
            if(!totalBitcoins){
                dayPurchased = i;
            }
            totalBitcoins += bitcoinPurchased;
            totalGold = totalGold % 11949.16;
        }
    }
    console.log(`Bought bitcoins: ${totalBitcoins}`);
    if(dayPurchased){
        console.log(`Day of the first purchased bitcoin: ${dayPurchased}`);
    }
    console.log(`Left money: ${totalGold.toFixed(2)} lv.`);
}