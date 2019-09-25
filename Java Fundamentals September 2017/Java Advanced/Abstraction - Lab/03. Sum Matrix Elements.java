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
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            String[] nums = scanner.nextLine().split(", ");
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = Integer.parseInt(nums[j]);
                sum+= matrix[i][j];
            }
        }
        System.out.println(rows);
        System.out.println(columns);
        System.out.println(sum);
    }
}