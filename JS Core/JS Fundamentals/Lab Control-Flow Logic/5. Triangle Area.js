function findTriangleArea(a, b, c) {
    let p = (a + b + c) / 2;
    let result = Math.sqrt(p * (p-a) * (p-b) * (p-c));
    console.log(result);
}
