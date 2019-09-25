import java.util.Scanner;

public class DVS {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] star1 = scan.nextLine().split(" ");
        String[] star2 = scan.nextLine().split(" ");
        String[] star3 = scan.nextLine().split(" ");
        String[] normandyCordinates = scan.nextLine().split(" ");
        int moves = Integer.parseInt(scan.nextLine());
        double shipColumn = Double.parseDouble(normandyCordinates[0]);
        double currentShipRow = Double.parseDouble(normandyCordinates[1]);
        String firstStarName = star1[0];
        double firstStarRow = Double.parseDouble(star1[2]);
        double firstStarColumn = Double.parseDouble(star1[1]);
        String secondStarName = star2[0];
        double secondStarRow = Double.parseDouble(star2[2]);
        double secondStarColumn = Double.parseDouble(star2[1]);
        String thirdStarName = star3[0];
        double thirdStarRow = Double.parseDouble(star3[2]);
        double thirdStarColumn = Double.parseDouble(star3[1]);
        for (int i = 0; i <= moves; i++) {
            if (Math.abs(currentShipRow - firstStarRow) <= 1 && 
                    Math.abs(shipColumn - firstStarColumn) <= 1) {
                System.out.println(firstStarName.toLowerCase());
            } else if (Math.abs(currentShipRow - secondStarRow) <= 1 &&
                    Math.abs(shipColumn - secondStarColumn) <= 1) {
                System.out.println(secondStarName.toLowerCase());
            } else if (Math.abs(currentShipRow - thirdStarRow) <= 1 &&
                    Math.abs(shipColumn - thirdStarColumn) <= 1) {
                System.out.println(thirdStarName.toLowerCase());
            } else {
                System.out.println("space");
            }
            currentShipRow++;
        }
    }
}