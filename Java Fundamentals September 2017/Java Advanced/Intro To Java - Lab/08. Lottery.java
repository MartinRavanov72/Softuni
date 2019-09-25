import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;


public class DVS {
    public static void main(String[] args) {
        for (int i = 1; i < 9; i++){
            for (int j = i+1; j < 10; j++){
                for (int m = j+1; m < 11; m++){
                    System.out.printf("%s %s %s", i , j , m);
                    System.out.println();
                }
            }
        }
    }
}