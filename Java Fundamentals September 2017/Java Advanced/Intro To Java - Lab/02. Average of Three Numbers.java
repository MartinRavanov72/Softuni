import java.util.Scanner;

public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double firstNum = scanner.nextDouble();
        double secondNum = scanner.nextDouble();
        double thirdNum = scanner.nextDouble();
        double avg = (firstNum + secondNum + thirdNum) / 3;
        System.out.printf("%.2f", avg);
    }
}
