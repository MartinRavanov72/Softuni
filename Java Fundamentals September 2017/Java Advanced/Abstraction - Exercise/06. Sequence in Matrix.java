import java.util.Scanner;

public class DVS {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int columns = Integer.parseInt(input[1]);
        String[][] matrix = new String[rows][columns];
        for (int i = 0; i < rows; i++) {
            matrix[i] = scan.nextLine().split(" ");
        }
        int maxCnt = 0;
        String maxString = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int down = 0;
                String temp = matrix[i][j]+", ";
                for (int k = i; k < matrix.length-1; k++) {
                    if(matrix[k][j].equals(matrix[k+1][j])){
                        down++;
                        temp += matrix[i][j]+", ";
                    } 
                    else {
                        break;
                    }
                }
                if (down > maxCnt){
                    maxCnt = down;
                    maxString = temp;
                }
                int cnt = 0;
                String temp2 = matrix[i][j]+", ";
                for (int k = i; k < Math.min(matrix.length-1,matrix[i].length-1); k++) {
                    if(matrix[k][k].equals(matrix[k+1][k+1])){
                        cnt++;
                        temp2 += matrix[k][k]+", ";
                    } 
                    else {
                        break;
                    }
                }
                if (cnt > maxCnt){
                    maxCnt = cnt;
                    maxString = temp2;
                }
            }
        }
        if(maxString.equals("")){
            maxString = matrix[0][0]+",";
        }
        System.out.println(maxString.substring(0, maxString.length() - 2));
    }
}