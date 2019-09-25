package interfaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        String power = scanner.readLine();
        String suit = scanner.readLine();
        Power currentPower = Power.valueOf(power);
        Suit currentSuit = Suit.valueOf(suit);
        Card card = new Card(currentSuit, currentPower);
        System.out.println(card.toString());
    }
}