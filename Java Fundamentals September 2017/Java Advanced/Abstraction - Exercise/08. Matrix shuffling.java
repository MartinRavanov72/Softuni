import java.util.Arrays;
import java.util.Scanner;

public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        String[][] matrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine().split(" ");
        }
        String command = scanner.nextLine();
        while (!command.equals("END")){
            String[] imputParams = command.split(" ");
            if(imputParams.length != 5){
                System.out.println("Invalid input!");
            } 
            else {
                String keyWord = imputParams[0];
                if(!keyWord.equals("swap")){
                    System.out.println("Invalid input!");
                } 
                else {
                    int row1 = Integer.parseInt(imputParams[1]);
                    int col1 = Integer.parseInt(imputParams[2]);
                    int row2 = Integer.parseInt(imputParams[3]);
                    int col2 = Integer.parseInt(imputParams[4]);
                    boolean row1Valid = row1 < matrix.length && row1 >= 0;
                    boolean col1Valid = col1 < matrix[0].length && col1 >= 0;
                    boolean row2Valid = row2 < matrix.length && row2 >= 0;
                    boolean col2Valid = col2 < matrix[0].length && col2 >= 0;
                    if (row1Valid && row2Valid && col1Valid && col2Valid){
                        String temp = matrix[row1][col1];
                        matrix[row1][col1] = matrix[row2][col2];
                        matrix[row2][col2] = temp;
                        for (String[] aMatrix : matrix) {
                            System.out.println(Arrays.toString(aMatrix).replace("[", "").replace("]", "").replace(",", ""));
                        }
                    } 
                    else {
                        System.out.println("Invalid input!");
                    }
                }
            }
            command = scanner.nextLine();
        }
    }
}