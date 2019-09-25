import java.util.*;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int[] stock = new int[num];
        for (int i = 0; i < stock.length; i++) {
            stock[i] = Integer.parseInt(scanner.nextLine());
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        StringBuilder sb = new StringBuilder();
        sb.append(1).append("\n");
        for (int i = 1; i < num; i++) {
            while (!stack.isEmpty() && stock[stack.peek()] <= stock[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                sb.append(i - stack.peek()).append("\n");
            } 
            else {
                sb.append(i + 1).append("\n");
            }
            stack.push(i);
        }
        System.out.println(sb.toString());
    }
}