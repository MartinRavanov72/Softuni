function calc(input) {
    let desiredThickness = +input[0];

    for (let i = 1; i < input.length; i++) {
        let thickness = +input[i];
        let cnt = 0;
        console.log('Processing chunk ' + thickness + ' microns');

        while (thickness / 4 >= desiredThickness) { 
            thickness /= 4;   
            cnt++;
        }
        if (cnt != 0) {
            console.log('Cut x' + cnt);
            console.log('Transporting and washing');
            thickness = Math.floor(thickness);
            if (thickness == desiredThickness) {
                console.log('Finished crystal ' + thickness + ' microns');
                continue;
            }
            cnt = 0;
        }

        while (thickness * 0.8 >= desiredThickness) {
            thickness *= 0.8;
            cnt++;
        }
        if (cnt != 0) {
            console.log('Lap x' + cnt);
            console.log('Transporting and washing');
            thickness = Math.floor(thickness);
            if (thickness == desiredThickness) {
                console.log('Finished crystal ' + thickness + ' microns');
                continue;
            }
            cnt = 0;
        }

        while (thickness - 20 >= desiredThickness) {
            thickness -= 20;
            cnt++;
        }
        if (cnt != 0) {
            console.log('Grind x' + cnt);
            console.log('Transporting and washing');
            thickness = Math.floor(thickness);
            if (thickness == desiredThickness) {
                console.log('Finished crystal ' + thickness + ' microns');
                continue;
            }
            cnt = 0;
        }

        while (thickness -1 >= desiredThickness) {
            thickness -= 2;
            cnt++;
        }
        if (cnt != 0) {
            console.log('Etch x' + cnt);
            console.log('Transporting and washing');
            thickness = Math.floor(thickness);
            if (thickness == desiredThickness) {
                console.log('Finished crystal ' + thickness + ' microns');
                continue;
            }
            cnt = 0;
        }
    
        if (thickness + 1 == desiredThickness) {
            console.log('X-ray x1');
            console.log('Finished crystal ' + +(thickness + 1) + ' microns');
        }
    }
}