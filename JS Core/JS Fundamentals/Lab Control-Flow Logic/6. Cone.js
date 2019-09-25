function findConeAreaVolume(r, h) {
    let s = Math.sqrt(r * r + h * h);
    let volume = Math.PI * r * r * h / 3;
    console.log(volume);
    let area = Math.PI * r * (r + s);
    console.log(area);
}
