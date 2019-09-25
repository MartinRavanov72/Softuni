import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(scanner.readLine());
        int[][][] matrix = new int[n][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int h = 0; h < n; h++) {
                    matrix[i][j][h] = 0;
                }
            }
        }
        while(true) {
            String input = scanner.readLine();
            if ("Analyze".equals(input)) {
                break;
            }
            int[] command = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            boolean isValid = true;
            for (int i = 0; i < command.length - 1; i++) {
                if (!(command[i] < n && command[i] >= 0)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                matrix[command[0]][command[1]][command[2]] = command[3];
            }
        }
        int cnt = 0;
        long sum1 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int h = 0; h < n; h++) {
                    if (matrix[i][j][h] == 0) {
                        cnt++;
                    }
                    else {
                        sum1 += matrix[i][j][h];
                    }
                }
            }
        }
        System.out.println(sum1);
        System.out.println(cnt);
    }
}