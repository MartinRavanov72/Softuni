package interfaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        String power1 = scanner.readLine();
        String suit1 = scanner.readLine();
        Power currentPower1 = Power.valueOf(power1);
        Suit currentSuit1 = Suit.valueOf(suit1);
        String power2 = scanner.readLine();
        String suit2 = scanner.readLine();
        Power currentPower2 = Power.valueOf(power2);
        Suit currentSuit2 = Suit.valueOf(suit2);
        Card card1 = new Card(currentSuit1, currentPower1);
        Card card2 = new Card(currentSuit2, currentPower2);
        if (card1.compareTo(card2) > 0) {
            System.out.println(card1.toString());
        } else {
            System.out.println(card2.toString());
        }
    }
}