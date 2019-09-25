import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.TreeMap;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        TreeMap<Character, Integer> count = new TreeMap<>();
        for (int i = 0; i < input.length(); i++) {
            if (count.containsKey(input.charAt(i))) {
                count.put(input.charAt(i), count.get(input.charAt(i)) + 1);
            }
            else {
                count.put(input.charAt(i), 1);
            }
        }
        for(char key : count.keySet()){
            System.out.println(key + ": " + count.get(key) + " time/s");
        }
    }
}