import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Scanner;


public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        String aAsHexadecimal = Integer.toHexString(a).toUpperCase();
        String whiteSpace1 = "";
        for (int i = aAsHexadecimal.length(); i < 10; i++){
            whiteSpace1 = whiteSpace1 + " ";
        }
        System.out.print("|" + aAsHexadecimal + whiteSpace1);
        String aAsBinary = Integer.toBinaryString(a);
        aAsBinary = new StringBuilder(aAsBinary).reverse().toString();
        for (int i = aAsBinary.length(); i < 10; i++){
            aAsBinary = aAsBinary + "0";
        }
        aAsBinary = new StringBuilder(aAsBinary).reverse().toString();
        System.out.print("|" + aAsBinary);
        DecimalFormat f = new DecimalFormat("##.00");
        String bAsString = new StringBuilder(f.format(b)).reverse().toString();
        if (Math.floor(Math.abs(b))== 0){
            bAsString = new StringBuilder(bAsString).reverse().toString();
            bAsString = bAsString.replace('-', '0');
            bAsString = new StringBuilder(bAsString).reverse().toString();
            bAsString = bAsString + "-";
        }
        for (int i = bAsString.length(); i< 10; i++){
            bAsString = bAsString + " ";
        }
        Math.round(4.555);
        bAsString = new StringBuilder(bAsString).reverse().toString();
        System.out.print("|" + bAsString);
        f = new DecimalFormat("##.000");
        String cAsString = new StringBuilder(f.format(c)).toString();
        if (Math.floor(Math.abs(c))== 0){
            cAsString = new StringBuilder(cAsString).reverse().toString();
            cAsString = cAsString.replace('-', '0');
            cAsString = cAsString + "-";
            cAsString = new StringBuilder(cAsString).reverse().toString();
        }
        for (int i = cAsString.length(); i < 10; i++){
            cAsString = cAsString + " ";
        }
        System.out.println("|" + cAsString + "|");
    }
}