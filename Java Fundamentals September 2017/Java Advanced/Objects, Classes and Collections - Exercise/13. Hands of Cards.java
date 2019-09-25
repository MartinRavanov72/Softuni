import java.util.*;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, HashSet<String>> scores = new LinkedHashMap<>();
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("JOKER")) {
                break;
            }
            HashSet<String> allCards = new HashSet<>();
            String[] nameAndCards = input.split(":");
            String name = nameAndCards[0];
            String[] cards = nameAndCards[1].trim().split(", ");
            Collections.addAll(allCards, cards);
            if (!scores.containsKey(name)) {
                scores.put(name, allCards);
            }
            else {
                for (String card : allCards) {
                    if (!scores.get(name).contains(card)) {
                        scores.get(name).add(card);
                    }
                }
            }
        }
        for (String key : scores.keySet()) {
            int value = 0;
            for (String card : scores.get(key)) {
                value += cardValue(card);
            }
            System.out.println(key + ": " + value);
        }
    }

    private static int cardValue(String card) {
        Character value = card.charAt(0);
        Character power = card.charAt(card.length() - 1);
        int v;
        int p;
        switch (value) {
            case '2':
                v = 2;
                break;
            case '3':
                v = 3;
                break;
            case '4':
                v = 4;
                break;
            case '5':
                v = 5;
                break;
            case '6':
                v = 6;
                break;
            case '7':
                v = 7;
                break;
            case '8':
                v = 8;
                break;
            case '9':
                v = 9;
                break;
            case '1':
                v = 10;
                break;
            case 'J':
                v = 11;
                break;
            case 'Q':
                v = 12;
                break;
            case 'K':
                v = 13;
                break;
            case 'A':
                v = 14;
                break;
            default:
                v = 1;
                break;
        }
        switch (power) {
            case 'S':
                p = 4;
                break;
            case 'H':
                p = 3;
                break;
            case 'D':
                p = 2;
                break;
            case 'C':
                p = 1;
                break;
            default:
                p = 1;
                break;
        }
        return v * p;
    }
}
