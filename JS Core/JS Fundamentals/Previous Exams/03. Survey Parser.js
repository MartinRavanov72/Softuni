function surveyParser(input) {
 
    let regexSVG = /<svg>(.*)<\/svg>/;
 
    if (regexSVG.test(input)) {
        let insideSVG = regexSVG.exec(input)[1];
        let regexCat = /<cat>(.*)<\/cat>\s*<cat>(.*)<\/cat>/;
 
        if (regexCat.test(insideSVG)) {
            let insideCatFirst = regexCat.exec(insideSVG)[1];
            let insideCatSecond = regexCat.exec(insideSVG)[2];
 
            let regexFirstCat = /<text>.*\[(.*)\].*\/text>/;
            let regexSecondCat = /<g><val>(\d+)<\/val>(\d+)<\/g>/g;
 
            if (regexFirstCat.test(insideCatFirst) && regexSecondCat.test(insideCatSecond)) {
 
                let surveyLabel = regexFirstCat.exec(insideCatFirst)[1];
 
                let valuesAr = insideCatSecond.match(regexSecondCat);
 
                let sumVotes = 0;
                let sumValues = 0;
 
                for (let i = 0; i < valuesAr.length ; i++) {
 
                    let exec = /<g><val>(\d+)<\/val>(\d+)<\/g>/.exec( valuesAr[i]);
                    let values  = +exec[1];
                    let votes = +exec[2];
                    sumVotes += votes;
                    sumValues += votes*values;
                }
 
                console.log(`${surveyLabel}: ${Math.round((sumValues/sumVotes) * 100) / 100}`);
 
            }else {
                console.log("Invalid format");
            }
        }else{
            console.log("Invalid format");
        }
    }else{
        console.log("No survey found");
    }
}