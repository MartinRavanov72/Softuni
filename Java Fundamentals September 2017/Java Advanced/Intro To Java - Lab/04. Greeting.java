import java.math.BigDecimal;
import java.util.Scanner;

public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstName = scanner.nextLine();
        String secondName = scanner.nextLine();
        if (firstName.isEmpty()){
            firstName = "*****";
        }
        if (secondName.isEmpty()){
            secondName = "*****";
        }
        System.out.println("Hello, " + firstName + " " + secondName + "!");
    }
}
