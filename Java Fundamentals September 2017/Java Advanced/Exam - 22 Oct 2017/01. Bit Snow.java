import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        String[] input = scanner.readLine().split(", ");
        List<Integer> bits = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            bits.add(Integer.parseInt(input[i]));
        }
        int cons = bits.size();
        boolean stop = false;
        for (int i = 0; (i < cons) && (!stop); i++) {
            for (int j = 0; j < cons - 1; j++) {
                int num1 = bits.get(j);
                int num2 = bits.get(j + 1);
                int temp1 = num1 & num2;
                int temp2 = num1 | num2;
                if (i == cons - 2 && num2 == temp2) {
                    stop = true;
                    break;
                }
                bits.set(j, temp1);
                bits.set(j + 1, temp2);
            }
        }
        for (int i = 0; i < cons; i++) {
            if (i == cons - 1) {
                System.out.print(bits.get(i));
            }
            else {
                System.out.print(bits.get(i) + ", ");
            }
        }
    }
}