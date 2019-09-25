function orbit(str) {
    let result = str.split(' ')
        .map(s=>s.substring(0, 1).toUpperCase()
        + s.substring(1, s.length).toLowerCase())
        .join(' ');

    console.log(result);
}