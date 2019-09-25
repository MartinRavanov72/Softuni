package interfaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<Card>> cards = new LinkedHashMap<>();
        List<String> allCards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                allCards.add(new Card(suit, rank).toString());
            }
        }
        String name1 = scanner.readLine();
        String name2 = scanner.readLine();
        for (int i = 0; i < 10; i++) {
            String input = scanner.readLine();
            if (!allCards.contains(input)) {
                System.out.println("No such card exists.");
                i--;
                continue;
            }
            if (cards.values().toString().contains(input)) {
                System.out.println("Card is not in the deck.");
                i--;
                continue;
            }
            String[] inputParams = input.split("\\s+");
            Rank rank = Rank.valueOf(inputParams[0]);
            Suit suit = Suit.valueOf(inputParams[2]);
            if (i < 5) {
                if (!cards.containsKey(name1)) {
                    cards.put(name1, new ArrayList<>());
                }
                cards.get(name1).add(new Card(suit, rank));
            } else {
                if (!cards.containsKey(name2)) {
                    cards.put(name2, new ArrayList<>());
                }
                cards.get(name2).add(new Card(suit, rank));
            }
        }
        Card winningCard = cards.get(name1).get(0);
        String winningName = "";
        for (Map.Entry<String, List<Card>> kvp : cards.entrySet()) {
            for (Card card : kvp.getValue()) {
                if (card.compareTo(winningCard) > 0) {
                    winningCard = card;
                    winningName = kvp.getKey();
                }
            }
        }
        System.out.println(winningName + " wins with " + winningCard.toString() + ".");
    }
}