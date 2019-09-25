import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(" ");
        if (arr.length % 2 == 1){
            System.out.println("invalid length");
        }
        else{
            for (int i = 0; i < arr.length - 1;i = i+2){
                int num1 = Integer.parseInt(arr[i]);
                int num2 = Integer.parseInt(arr[i+1]);
                boolean num1IsEven = num1 % 2 == 0;
                boolean num2IsEven = num2 % 2 == 0;
                boolean num1IsOdd = num1 % 2 == 1;
                boolean num2IsOdd = num2 % 2 == 1;
                if (num1IsEven && num2IsEven){
                    System.out.printf("%s, %s -> both are even", num1, num2);
                    System.out.println();
                }
                else if (num1IsOdd && num2IsOdd){
                    System.out.printf("%s, %s -> both are odd", num1, num2);
                    System.out.println();
                }
                else{
                    System.out.printf("%s, %s -> different", num1, num2);
                    System.out.println();
                }
            }
        }
    }
}