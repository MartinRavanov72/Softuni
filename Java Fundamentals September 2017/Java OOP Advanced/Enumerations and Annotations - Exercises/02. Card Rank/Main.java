package interfaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        scanner.readLine();
        System.out.println("Card Ranks:");
        for (Card card : Card.values()) {
            System.out.println(card.toString());
        }
    }
}