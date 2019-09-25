import java.util.Scanner;

public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstWord = scanner.next();
        String secondWord = scanner.next();
        int firstNum = scanner.nextInt();
        int secondNum = scanner.nextInt();
        int thirdNum = scanner.nextInt();
        scanner.nextLine();
        String thirdWord = scanner.nextLine();
        System.out.printf("%s %s %s %s", firstWord, secondWord, thirdWord, firstNum + secondNum + thirdNum);
    }
}