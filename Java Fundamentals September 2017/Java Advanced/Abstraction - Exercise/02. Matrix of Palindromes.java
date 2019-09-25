import java.lang.reflect.Array;
        import java.math.BigDecimal;
        import java.math.BigInteger;
        import java.text.DecimalFormat;
        import java.util.*;


public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        String[][] matrix = new String[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                char firstLetter = (char)((int)'a' + i);
                char secondLetter = (char)((int) firstLetter + j);
                char thirdLetter = firstLetter;
                String str =  firstLetter + "" + secondLetter + "" + thirdLetter + "";
                matrix[i][j] = str;
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}