function calc(input) {
    let x1 = input[0];
    let y1 = input[1];
    let x2 = input[2];
    let y2 = input[3];
    let x3 = input[4];
    let y3 = input[5];
    let AB = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    let BC = Math.sqrt((x2 - x3) * (x2 - x3) + (y2 - y3) * (y2 - y3));
    let AC = Math.sqrt((x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3));
    if (AB + BC <= BC + AC) {
        console.log('1->2->3: ' + +(AB + BC));
    }
    else if (AB + AC < BC + AC) {
        console.log("2->1->3: " + +(AB + AC));
    }
    else {
        console.log("1->3->2: " + +(BC + AC));
    }
}