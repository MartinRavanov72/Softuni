import java.lang.reflect.Array;
        import java.math.BigDecimal;
        import java.math.BigInteger;
        import java.text.DecimalFormat;
        import java.util.*;


public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] lineParams = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(lineParams[0]);
        int columns = Integer.parseInt(lineParams[1]);
        char[][] matrix = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            String[] chars = scanner.nextLine().split(" ");
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = chars[j].charAt(0);
            }
        }
        int cnt = 0;
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < columns - 1; j++) {
                if (matrix[i][j] == matrix[i][j + 1] && matrix[i][j + 1] == matrix[i + 1][j] && matrix[i + 1][j] == matrix[i + 1][j + 1]) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}