function orbit(input) {
    let arrays = new Map;
    for (let line of input) {
        let array = JSON.parse(line).map(Number).sort((a, b) => b - a);
        let result = `[${array.join(', ')}]`;
        if (!arrays.has(result)){
            arrays.set(result, array.length);
        }
    }
    function customSort(arrA, arrB, map) {
       return map.get(arrA) - map.get(arrB);
    } 
    console.log([...arrays.keys()].sort((a, b) => customSort(a, b, arrays)).join('\n'));
}