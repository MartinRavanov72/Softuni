import java.text.DecimalFormat;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputParams = scanner.nextLine().split(" ");
        String[] text = new String[inputParams.length];
        for (int i = 0; i < inputParams.length; i++) {
            text[i] = inputParams[i];
        }
        Predicate<String> checkerUpperCase = s -> s.charAt(0) == s.toUpperCase().charAt(0);
        ArrayList<String> output = new ArrayList<>();
        for (int i = 0; i < text.length; i++) {
            if (checkerUpperCase.test(text[i])) {
                output.add(text[i]);
            }
        }
        System.out.println(output.size());
        for (int i = 0; i < output.size(); i++) {
            System.out.println(output.get(i));
        }
    }
}