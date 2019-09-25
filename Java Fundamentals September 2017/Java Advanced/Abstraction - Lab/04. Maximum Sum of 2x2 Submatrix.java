import java.lang.reflect.Array;
        import java.math.BigDecimal;
        import java.math.BigInteger;
        import java.text.DecimalFormat;
        import java.util.*;


public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] lineParams = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(lineParams[0]);
        int columns = Integer.parseInt(lineParams[1]);
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            String[] nums = scanner.nextLine().split(", ");
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = Integer.parseInt(nums[j]);
            }
        }
        int sum = Integer.MIN_VALUE;
        int[][] lastMatrix = new int[2][2];
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < columns - 1; j++) {
                if (matrix[i][j] + matrix[i][j+1] + matrix[i+1][j] + matrix[i+1][j+1] > sum) {
                    lastMatrix[0][0] = matrix[i][j];
                    lastMatrix[0][1] = matrix[i][j+1];
                    lastMatrix[1][0] = matrix[i+1][j];
                    lastMatrix[1][1] = matrix[i+1][j+1];
                    sum = matrix[i][j] + matrix[i][j+1] + matrix[i+1][j] + matrix[i+1][j+1];
                }
            }
        }
        System.out.printf("%s %s", lastMatrix[0][0] , lastMatrix[0][1]);
        System.out.println();
        System.out.printf("%s %s", lastMatrix[1][0] , lastMatrix[1][1]);
        System.out.println();
        System.out.println(sum);
    }
}