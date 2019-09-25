function orbit(input) {
    let html = "<table>\n";
    for (let i = 0; i < input.length; i++) {
        let currentEmployee = JSON.parse(input[i]);
        html += "	<tr>\n";
        for (let key in currentEmployee){
            html += "		<td>" + currentEmployee[key] + "</td>\n";
        }
        html+= "	<tr>\n";
    }
    html+="</table>";
    console.log(html);
}