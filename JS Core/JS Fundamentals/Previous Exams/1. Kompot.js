function print(input) {
    let peachGrams = 0;
    let plumGrams = 0;
    let cherryGrams = 0;
    let rakiyaGrams = 0;
    for (let line of input){
        let inputParams = line.split(/\s+/g);
        let fruit = inputParams[0];
        let kilograms = +inputParams[1];
        if(fruit === "peach"){
            peachGrams += kilograms*1000;
        }else if(fruit === "plum"){
            plumGrams += kilograms*1000;
        }else if(fruit === "cherry"){
            cherryGrams += kilograms*1000;
        }else {
            rakiyaGrams += kilograms*1000;
        }
    }
    let peachCompotes = Math.floor(peachGrams/140/2.5);
    let plumCompotes = Math.floor(plumGrams/20/10);
    let cherryCompotes = Math.floor(cherryGrams/9/25);
    let rakiyaLiters = (rakiyaGrams/5/1000).toFixed(2);
    console.log("Cherry kompots: " + cherryCompotes)
    console.log("Peach kompots: " + peachCompotes);
    console.log("Plum kompots: " + plumCompotes);
    console.log("Rakiya liters: " + rakiyaLiters);
}