function calc(n) {
    let arr = ["A", "T", "C", "G", "T", "T", "A", "G", "G", "G"];
    let cnt = 0;

    for(let i = 0; i < n; i++){
        if(cnt >= 10){
            cnt = 10 - cnt;
        }

        if(i % 4 == 0){
            console.log("**" + arr[cnt] + arr[cnt+1] + "**");
        }else if(i % 4 == 1){
            console.log("*" + arr[cnt] + "--" + arr[cnt+1] + "*");
        }else if(i % 4 == 2){
            console.log(arr[cnt] + "----" + arr[cnt+1]);
        }else {
            console.log("*" + arr[cnt] + "--" + arr[cnt+1] + "*");
        }
        
        cnt+=2;
    }
}