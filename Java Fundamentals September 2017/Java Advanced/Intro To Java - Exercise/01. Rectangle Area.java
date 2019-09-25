import java.util.Scanner;


public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double height = scanner.nextDouble();
        double length = scanner.nextDouble();
        System.out.printf("%.2f", height * length);
    }
}