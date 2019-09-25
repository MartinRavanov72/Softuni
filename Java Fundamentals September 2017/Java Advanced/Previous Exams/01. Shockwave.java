import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        String[] size = scanner.readLine().split("\\s+");
        int[][] matrix = new int[Integer.parseInt(size[0])][Integer.parseInt(size[1])];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < Integer.parseInt(size[1]); j++) {
                matrix[i][j] = 0;
            }
        }
        while(true){
            String input = scanner.readLine();
            if ("Here We Go".equals(input)) {
                break;
            }
            List<Integer> inputParams = Arrays.stream(input.split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
            for (int i = inputParams.get(0); i <= inputParams.get(2); i++) {
                for (int j = inputParams.get(1); j <= inputParams.get(3); j++) {
                    matrix[i][j]++;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < Integer.parseInt(size[1]); j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}