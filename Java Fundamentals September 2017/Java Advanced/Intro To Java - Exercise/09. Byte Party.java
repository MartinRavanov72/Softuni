import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Integer> print = new ArrayList<Integer>();
        for (int i = 0; i < n ; i++){
            print.add(scanner.nextInt());
        }
        scanner.nextLine();
        String line = scanner.nextLine();
        while(!line.equals("party over")){
            String[] commands = line.split(" ");
            String command = commands[0];
            int position = Integer.parseInt(commands[1]);
            int bit;
            if (command.equals("-1")){
                int cnt = 0;
                for (int j = print.size() - n; j < print.size() && cnt < n; j++){
                    int mask = print.get(j) >> position;
                    bit = mask & 1;
                    int result;
                    if (bit == 0){
                        mask = 1 << position;
                        result = print.get(j) | mask;
                    }
                    else{
                        mask = ~(1 << position);
                        result = print.get(j) & mask;
                    }
                    print.add(result);
                    cnt++;
                }
            }
            else if(command.equals("0")){
                int cnt = 0;
                for (int j = print.size() - n; j < print.size() && cnt < n; j++){
                    int mask = ~(1 << position);
                    int result = print.get(j) & mask;
                    print.add(result);
                    cnt++;
                }
            }
            else{
                int cnt = 0;
                for (int j = print.size() - n; j < print.size() && cnt < n; j++){
                    int mask = 1 << position;
                    int result = print.get(j) | mask;
                    print.add(result);
                    cnt++;
                }
            }
            line = scanner.nextLine();
        }
        for (int i = print.size() - n; i < print.size(); i++){
            System.out.println(print.get(i));
        }
    }
}