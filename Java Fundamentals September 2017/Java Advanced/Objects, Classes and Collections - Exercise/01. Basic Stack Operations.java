import java.util.*;
 
public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        scanner.nextLine();
        String[] inputParams = scanner.nextLine().split("[\\s]");
        for (int i = 0; i < n; i++) {
            stack.push(Integer.parseInt(inputParams[i]));
        }
        for (int i = 0; i < s; i++) {
            stack.pop();
        }
        if (stack.contains(x)) {
            System.out.println("true");
        }
        else {
            int smallestElement = Integer.MAX_VALUE;
            int i = 0;
            if (stack.size() == 0) {
                smallestElement = 0;
            }
            else {
                while (i < stack.size()) {
                    if (stack.peek() < smallestElement) {
                        smallestElement = stack.pop();
                    }
                    else {
                        i++;
                    }
                }
            }
            System.out.println(smallestElement);
        }
    }
}