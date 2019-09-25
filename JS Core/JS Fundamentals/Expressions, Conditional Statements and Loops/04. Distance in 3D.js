function printName(params) {
    let distance = Math.sqrt(Math.pow((params[3] - params[0]), 2) + Math.pow((params[4] - params[1]), 2) + Math.pow((params[5] - params[2]), 2));
    console.log(distance);
}