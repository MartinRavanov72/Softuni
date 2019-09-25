package interfaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        scanner.readLine();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                System.out.println(new Card(suit, rank));
            }
        }
    }
}