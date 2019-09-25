import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;


public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        BigInteger product = new BigInteger("1");
        for (int i = n; i <= m; i++){
            BigInteger multiplier = BigInteger.valueOf(i);
            product = product.multiply(multiplier);
        }
        System.out.printf("product[%s..%s] = %s", n, m, product);
    }
}