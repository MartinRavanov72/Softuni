function orbit(arr) {
    let regex = /\d+/g;
    let str = arr.join("");
    let result = str.match(regex);
    console.log(result.join(" "));
}