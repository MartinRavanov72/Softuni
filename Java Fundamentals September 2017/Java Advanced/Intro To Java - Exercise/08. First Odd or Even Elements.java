import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] a = scanner.nextLine().split(" ");
        String[] b = scanner.nextLine().split(" ");
        int howMany = Integer.parseInt(b[1]);
        String oddOrEven = b[2];
        boolean isEven;
        if (oddOrEven.equals("even")){
            isEven = true;
        }
        else{
            isEven = false;
        }
        int cnt = 0;
        for (int i = 0;i < a.length;i++) {
            if (cnt == howMany){
                break;
            }
            if (Math.abs(Integer.parseInt(a[i])) % 2 == 0 && isEven) {
                System.out.print(Integer.parseInt(a[i]) + " ");
                cnt++;
            } else if (Math.abs(Integer.parseInt(a[i])) % 2 == 1 && !isEven) {
                System.out.print(Integer.parseInt(a[i]) + " ");
                cnt++;
            }
        }
    }
}