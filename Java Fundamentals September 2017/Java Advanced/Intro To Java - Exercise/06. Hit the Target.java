import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        for (int i = 1; i <= 20; i++){
            for (int j = 1; j <= 20; j++){
                if (i + j == a){
                    System.out.printf("%s + %s = %s", i , j , a);
                    System.out.println();
                    continue;
                }
            }
        }
        for (int i = 1; i <= 20; i++){
            for (int j = 1; j <= 20; j++){
                if (i - j == a){
                    System.out.printf("%s - %s = %s", i , j , a);
                    System.out.println();
                    continue;
                }
            }
        }
    }
}