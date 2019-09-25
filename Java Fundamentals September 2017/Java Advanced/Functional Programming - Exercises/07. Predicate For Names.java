import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<String> words = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        Predicate<String> isValid = w -> w.length() <= n;
        for (int i = 0; i < words.size(); i++) {
            if (isValid.test(words.get(i))) {
                System.out.println(words.get(i));
            }
        }
    }
}