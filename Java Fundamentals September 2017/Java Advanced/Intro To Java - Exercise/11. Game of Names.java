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
        int mostPoints = Integer.MIN_VALUE;
        String winnerName = "";
        for (int i = 0; i < n; i++) {
            scanner.nextLine();
            String name = scanner.nextLine();
            int points = scanner.nextInt();
            char[] letters = name.toCharArray();
            for (int j = 0; j < letters.length; j++) {
                if ((int)letters[j] % 2 == 0) {
                    points += (int)letters[j];
                }
                else {
                    points -= (int)letters[j];
                }
            }
            if (points > mostPoints) {
                mostPoints = points;
                winnerName = name;
            }
        }
        System.out.printf("The winner is %s - %s points", winnerName, mostPoints);
    }
}