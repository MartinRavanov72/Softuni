import java.lang.reflect.Array;
        import java.math.BigDecimal;
        import java.math.BigInteger;
        import java.text.DecimalFormat;
        import java.util.*;


public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine();
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            String[] nums = scanner.nextLine().split(" ");
            for (int j = 0; j < size; j++) {
                matrix[i][j] = Integer.parseInt(nums[j]);
            }
        }
        int primaryDiagSum = 0;
        int secondaryDiagSum = 0;
        for (int i = 0; i < size; i++) {
            primaryDiagSum += matrix[i][i];
            secondaryDiagSum += matrix[i][size - 1 - i];
        }
        System.out.println(Math.abs(primaryDiagSum - secondaryDiagSum));
    }
}