function print(arr, arg) {
    function customSort(a, b, arg) {
        if (arg === "asc") {
            return a - b;
        } else {
            return b - a;
        }
    }
    
    return arr.sort((a, b) => customSort(a, b, arg));
}