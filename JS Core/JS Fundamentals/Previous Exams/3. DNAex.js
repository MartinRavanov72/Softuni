function print(input) {
    let organisms = new Map;
    let pattern = /([A-Za-z!@#$?]+)=(\d+)--(\d+)<<([a-z]+)/gm;
    let match;
    for (let line of input){
        if(line == "Stop!"){
            break;
        }
        while (match = pattern.exec(line)){
            let geneLength = match[1].split("").filter(x => isGene(x)).length;
            if(geneLength == match[2]){
                if(!organisms.has(match[4])){
                    organisms.set(match[4], 0)
                }
                organisms.set(match[4], organisms.get(match[4]) + +match[3])
            }
        }
    }
    function isGene(ch){
        if(ch == "!"){
            return false;
        }else if(ch == "@"){
            return false;
        }else if(ch == "#"){
            return false;
        }else if(ch == "$"){
            return false;
        }else if(ch == "?"){
            return false;
        }
        return true;
    }
    let sortedOrganisms = [...organisms.keys()].sort((a, b) => organisms.get(b) - organisms.get(a));
    for (let organism of sortedOrganisms){
        let str = organism + " has genome size of " + organisms.get(organism);
        console.log(str);
    }
}