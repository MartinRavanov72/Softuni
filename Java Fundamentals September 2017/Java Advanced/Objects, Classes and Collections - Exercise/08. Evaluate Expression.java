import java.util.*;

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
        while (expressions.size() >= 1) {
            String s = expressions.pop();
            try {
                double num = Double.parseDouble(s);
                operators.push(s);
            }
            catch (Exception e){
                String str1 = operators.pop();
                String str2 = operators.pop();
                String result = calcualte(s, str1, str2);
                operators.push(result);
            }
        }
        System.out.printf("%.2f", Double.parseDouble(operators.peek()));
    }

    private static String calcualte(String s, String str1, String str2) {
        if ("*".equals(s)){
            return Double.toString(Double.parseDouble(str1) * Double.parseDouble(str2));
        } 
        else if ("/".equals(s)){
            return Double.toString(Math.max(Double.parseDouble(str2),Double.parseDouble(str2)) / Math.min(Double.parseDouble(str1),Double.parseDouble(str2)));
        } 
        else if ("+".equals(s)){
            return Double.toString(Double.parseDouble(str1) + Double.parseDouble(str2));
        } 
        else {
            return Double.toString((Double.parseDouble(str2) - Double.parseDouble(str1)));
        }
    }
}