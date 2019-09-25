import java.text.DecimalFormat;
import java.util.*;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputParams = scanner.nextLine().split(", ");
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < inputParams.length; i++) {
            numbers.add(Integer.parseInt(inputParams[i]));
        }
        numbers.removeIf(n -> n % 2 != 0);
        System.out.println(Arrays.toString(numbers.toArray()).replace("[", "").replace("]", ""));
        numbers.sort((a, b) -> a.compareTo(b));
        System.out.println(Arrays.toString(numbers.toArray()).replace("[", "").replace("]", ""));
    }
}