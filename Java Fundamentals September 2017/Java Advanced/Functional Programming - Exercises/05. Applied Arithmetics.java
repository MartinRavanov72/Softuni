import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();
        while(!command.equals("end")){
            switch (command){
                case "add":
                    nums = Arrays.stream(nums).map(i -> i + 1).toArray();
                    break;
                case "multiply":
                    nums = Arrays.stream(nums).map(i -> i * 2).toArray();
                    break;
                case "subtract":
                    nums = Arrays.stream(nums).map(i -> i - 1).toArray();
                    break;
                case "print":
                    System.out.println(Arrays.toString(nums).replaceAll("[\\[\\],]", ""));
                    break;
            }
            command = scanner.nextLine();
        }
    }
}