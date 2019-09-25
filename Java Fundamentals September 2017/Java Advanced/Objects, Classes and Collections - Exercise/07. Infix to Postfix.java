import java.util.*;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputParams = scanner.nextLine().split(" ");
        ArrayDeque<String> expressions = new ArrayDeque<>();
        ArrayDeque<String> operators = new ArrayDeque<>();
        Map<String, Integer> priorites = new HashMap<>();
        priorites.put("*", 3);
        priorites.put("/", 3);
        priorites.put("+", 2);
        priorites.put("-", 2);
        priorites.put("(", 1);
        for (String input : inputParams) {
            try {
                double num = Double.parseDouble(input);
                expressions.addLast(input);
            }
            catch (Exception e) {
                switch (input) {
                    case "x":
                        expressions.addLast(input);
                        break;
                    case "(":
                        operators.push(input);
                        break;
                    case ")":
                        String ch = operators.pop();
                        while (!"(".equals(ch)) {
                            expressions.addLast(ch);
                            ch = operators.pop();
                        }
                        break;
                    default:
                        while (!operators.isEmpty() && priorites.get(operators.peek()) >= priorites.get(input)) {
                            expressions.addLast(operators.pop());
                        }
                        operators.push(input);
                        break;
                }
            }
        }
        while (!operators.isEmpty()) {
            expressions.addLast(operators.pop());
        }
        while (expressions.size() > 0) {
            System.out.print(expressions.pop()+" ");
        }
    }
}