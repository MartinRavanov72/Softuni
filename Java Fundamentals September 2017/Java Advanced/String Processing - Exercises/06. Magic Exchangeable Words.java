import java.util.*;

public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(" ");
        if (line[0].length() > line[1].length()){
            System.out.println(findExchangableWords(line[1], line[0]));
        }
        else {
            System.out.println(findExchangableWords(line[0], line[1]));
        }
    }
    private static boolean findExchangableWords(String word1, String word2) {
        String word3 = "";
        String word4 = "";
        HashMap<Character, Character> words = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            if (!word3.contains(word1.charAt(i) + "")){
                word3 += word1.charAt(i);
            }
            if (words.containsKey(word1.charAt(i))) {
                if (words.get(word1.charAt(i)) != word2.charAt(i)) {
                    return false;
                }
            }
            else {
                words.put(word1.charAt(i), word2.charAt(i));
            }
        }
        for (int i = 0; i < word2.length(); i++) {
            if (!word4 .contains(word2.charAt(i) + "")){
                word4 += word2.charAt(i);
            }
        }

        return word3.length() == word4 .length();
    }
}