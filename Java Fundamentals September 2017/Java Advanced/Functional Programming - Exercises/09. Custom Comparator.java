import java.util.*;
        import java.util.function.Function;
        import java.util.stream.Collectors;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int [] arr1 = Arrays.stream(nums).filter(b -> b%2 == 0).boxed().sorted(Integer::compareTo).mapToInt(i -> i).toArray();
        int [] arr2 = Arrays.stream(nums).filter(c -> c%2 != 0).boxed().sorted(Integer::compareTo).mapToInt(i -> i).toArray();
        System.out.print(Arrays.toString(arr1).replace("[","").replace("]","").replace(",","") + " ");
        System.out.println(Arrays.toString(arr2).replace("[","").replace("]","").replace(",",""));
    }
}