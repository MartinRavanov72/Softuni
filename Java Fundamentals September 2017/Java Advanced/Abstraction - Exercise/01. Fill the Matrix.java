import java.lang.reflect.Array;
        import java.math.BigDecimal;
        import java.math.BigInteger;
        import java.text.DecimalFormat;
        import java.util.*;


public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] lineParams = scanner.nextLine().split(", ");
        int size = Integer.parseInt(lineParams[0]);
        String type = lineParams[1];
        int[][] matrix = new int[size][size];
        if (type.equals("A")) {
            fillMatrixTypeA(size, matrix);
        } 
        else {
            fillMatrixTypeB(size, matrix);
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrixTypeB(int size, int[][] matrix) {
        int cnt = 1;
        for (int j = 0; j < matrix.length; j++) {
            int cntTemp = cnt;
            for (int i = 0; i < matrix.length; i++) {
                if (j%2 == 0) {
                    matrix[i][j] = cnt;
                    cnt++;
                }
                else {
                    matrix[i][j] = cntTemp + size - 1;
                    cntTemp--;
                    cnt++;
                }
            }
        }
    }

    private static void fillMatrixTypeA(int size, int[][] matrix) {
        int cnt = 1;
        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][j] = cnt;
                cnt++;
            }
        }
    }
}