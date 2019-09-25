function printName(params) {
    let date = new Date(params[2], params[1] - 1, 0);
    console.log(date.getDate());
}