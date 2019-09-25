import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] a = scanner.next().toCharArray();
        char[] b = scanner.next().toCharArray();
        int sum = 0;
        if (a.length > b.length){
            int i = 0;
            for (i = 0;i < b.length; i++){
                sum += (int)b[i] * (int)a[i];
            }
            for (int j = i; j < a.length; j++){
                sum += (int)a[j];
            }
        }

        else{
            int i = 0;
            for (i = 0;i < a.length; i++){
                sum += (int)a[i] * (int)b[i];
            }
            for (int j = i; j < b.length; j++){
                sum += (int)b[j];
            }
        }
        System.out.println(sum);
    }
}