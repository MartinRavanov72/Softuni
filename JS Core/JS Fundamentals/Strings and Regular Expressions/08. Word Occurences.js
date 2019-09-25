function orbit(text, searchedWord) {
    let word = searchedWord.toLowerCase();
    let str = text.toLowerCase();
    let regex = new RegExp(('\\b' + word + '\\b'), 'g');
    let result = str.match(regex);
    if(result == null){
        console.log(0);
    }else {
        console.log(result.length);
    }
}