function printName(params) {
    let dist1 = params[0] / 3.6 * params[2];
    let dist2 = params[1] / 3.6 * params[2];
    console.log(Math.abs(dist1 - dist2));
}