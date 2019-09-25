function orbit(str) {
    let regex = /\b_([A-Za-z0-9]+)\b/g;
    let empty = [];
    let match;
    while (match = regex.exec(str)) {
        empty.push(match[1]);
    }
    return empty.join(',')
}