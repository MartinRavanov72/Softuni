function printName(num) {
    let feet = Math.floor(num / 12);
    let inches = num % 12;
    console.log(feet + "\'-" + inches + "\"");
}