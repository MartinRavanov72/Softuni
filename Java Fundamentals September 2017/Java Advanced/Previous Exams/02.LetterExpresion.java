import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        String input = scanner.readLine();
        List<Integer> nums = Arrays.stream(input.split("[^\\d]")).filter(x -> !x.isEmpty()).map(Integer::parseInt).collect(Collectors.toList());
        List<String> delimeters = Arrays.stream(input.split("[\\d]")).filter(x -> !x.isEmpty()).collect(Collectors.toList());
        if (nums.size() == 0) {

        }
        else if (nums.size() == 1) {
            System.out.println(nums.get(0));
        }
        else {
            int sum = nums.get(0);
            for (int i = 0; i < nums.size() - 1; i++) {
                if (delimeters.get(i).length() % 2 == 0) {
                    sum+= nums.get(i+1);
                }
                else {
                    sum-= nums.get(i+1);
                }
            }
            System.out.println(sum);
        }
    }
}