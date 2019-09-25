function printName(params) {
    let name1 = params[0];
    let value1 = params[1];
    let name2 = params[2];
    let value2 = params[3];
    let name3 = params[4];
    let value3 = params[5];
 
    let obj = {};
    obj[name1] = value1;
    obj[name2] = value2;
    obj[name3] = value3;
    console.log(obj);
}