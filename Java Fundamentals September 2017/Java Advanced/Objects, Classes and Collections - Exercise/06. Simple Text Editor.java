import java.util.*;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> stack = new ArrayDeque<>();
        String currentString = "";
        stack.push(currentString);
        for (int i = 0; i < n; i++)
        {
            String[] inputParams = scanner.nextLine().split(" ");
            switch (inputParams[0])
            {
                case "1": {
                    currentString += inputParams[1];
                    stack.push(currentString);
                }
                break;
                case "2": {
                    int lastElementCnt = Integer.parseInt(inputParams[1]);
                    currentString = currentString.substring(0, currentString.length() - lastElementCnt);
                    stack.push(currentString);
                }
                break;
                case "3": {
                    int index = Integer.parseInt(inputParams[1]);
                    System.out.println(currentString.charAt(index - 1));
                }
                break;
                case "4": {
                    stack.pop();
                    currentString = stack.peek();
                }
                break;
            }
        }
    }
}
