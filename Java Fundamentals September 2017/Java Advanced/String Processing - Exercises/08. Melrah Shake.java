import java.util.*;

public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder(scanner.nextLine());
        StringBuilder pattern = new StringBuilder(scanner.nextLine());
        while (true) {
            int firstIndex = input.indexOf(pattern + "");
            int lastIndex = input.lastIndexOf(pattern + "");
            if (firstIndex == lastIndex || "".equals(pattern+"")){
                System.out.println("No shake.");
                break;
            }
            input = input.replace(firstIndex, firstIndex + pattern.length(), "");
            input = input.replace(lastIndex - pattern.length(), lastIndex - pattern.length() + pattern.length(), "");
            int removalIndex = pattern.length() / 2;
            pattern = pattern.replace(removalIndex, removalIndex + 1, "");
            System.out.println("Shaked it.");
        }
        System.out.println(input);
    }
}