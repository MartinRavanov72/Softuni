import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;


public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int p = scanner.nextInt();
        int v = scanner.nextInt();
        if (v == 0){
            int mask = ~(1 << p);
            int result = n & mask;
            System.out.println(result);
        }
        else{
            int mask = 1 << p;
            int result = n | mask;
            System.out.println(result);
        }
    }
}