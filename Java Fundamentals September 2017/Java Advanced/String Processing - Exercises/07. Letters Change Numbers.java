import java.util.*;

public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputParams = scanner.nextLine().split("\\s+");
        double result = 0;
        for (int i = 0; i < inputParams.length; i++) {
            String currentWord = inputParams[i];
            double num = Integer.parseInt(currentWord.substring(1, currentWord.length() - 1));
            char firstLetter = currentWord.charAt(0);
            char secondLetter = currentWord.charAt(currentWord.length() - 1);
            double tempNum = num;
            if ((int)firstLetter < 91) {
                tempNum = num / ((int)firstLetter - 64);
            }
            else {
                tempNum = num * ((int)firstLetter - 96);
            }
            if ((int)secondLetter < 91) {
                tempNum = tempNum - ((int)secondLetter - 64);
            }
            else {
                tempNum = tempNum + ((int)secondLetter - 96);
            }
            result += tempNum;
        }
        System.out.printf("%.2f", result);
    }
}