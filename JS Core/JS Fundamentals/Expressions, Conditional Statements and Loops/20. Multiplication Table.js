function multiplicationTable(n) {
    console.log("<table border=\'1\'>\n");
    console.log("<tr><th>x</th>");
    for(let i = 1; i <= n; i++){
        console.log("<th>" + i + "</th>");
    }
    console.log("</tr>\n");
    for(let i = 1; i <= n; i++){
        console.log("<tr><th>" + i + "</th>");
        let cnt = i;
        for(let j = 1; j <= n; j ++){
            console.log("<td>" + cnt + "</td>");
            cnt +=i;
        }
        console.log("</tr>\n");
    }
    console.log("</table>");
}