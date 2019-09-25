import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        String[] cards = scanner.readLine().split("\\s+");
        int sum = 0;
        int longestSequence = 1;
        int totalPower = 0;
        for (int i = 0; i < cards.length; i++) {
            int power = 0;
            switch (cards[i].substring(0, cards[i].length() - 1)){
                case "2":
                    power = 2;
                    break;
                case "3":
                    power = 3;
                    break;
                case "4":
                    power = 4;
                    break;
                case "5":
                    power = 5;
                    break;
                case "6":
                    power = 6;
                    break;
                case "7":
                    power = 7;
                    break;
                case "8":
                    power = 8;
                    break;
                case "9":
                    power = 9;
                    break;
                case "10":
                    power = 10;
                    break;
                case "J":
                    power = 12;
                    break;
                case "Q":
                    power = 13;
                    break;
                case "K":
                    power = 14;
                    break;
                case "A":
                    power = 15;
                    break;
            }
            if (i == cards.length - 1 && cards[i].charAt(cards[i].length() - 1) == cards[i - 1].charAt(cards[i - 1].length() - 1)) {
                totalPower+=power;
                sum+= totalPower*longestSequence;
                break;
            }
            else if (i == cards.length - 1) {
                sum+=power;
                break;
            }
            if(cards[i+1].charAt(cards[i+1].length() - 1) == cards[i].charAt(cards[i].length() - 1)){
                longestSequence ++;
                totalPower+=power;
            }
            else{
                totalPower+=power;
                sum+= totalPower*longestSequence;
                totalPower = 0;
                longestSequence = 1;
            }
        }
        System.out.println(sum);
    }
}