import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] bits = new String[8];
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int a = scanner.nextInt();
            scanner.nextLine();
            String s = "";
            for (int p = 31; p >= 0; p--) {
                int mask = a >> p;
                int bit = mask & 1;
                s = s + String.valueOf(bit);
            }
            for (int m = s.length(); m < 32; m++) {
                s = new StringBuilder(s).reverse().toString();
                s = s + "0";
                s = new StringBuilder(s).reverse().toString();
            }
            bits[i] = s;
        }
        for (int i = 0; i < 6; i++) {
            String currentBitArr = bits[i];
            String nextBitArr = bits[i+1];
            String secondNextBitArr = bits[i+2];
            for (int j = 31; j >= 2; j--) {
                if (currentBitArr.charAt(31 - j) == '1' && currentBitArr.charAt(31 - j+1) == '0' && currentBitArr.charAt(31 - j+2) == '1'
                        && nextBitArr.charAt(31 - j) == '0' && nextBitArr.charAt(31 - j+1) == '1' && nextBitArr.charAt(31 - j+2) == '0'
                        && secondNextBitArr.charAt(31 - j) == '1' && secondNextBitArr.charAt(31 - j+1) == '0' && secondNextBitArr.charAt(31 - j+2) == '1'){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}