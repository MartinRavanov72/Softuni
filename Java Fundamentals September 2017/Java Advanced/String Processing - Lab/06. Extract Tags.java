import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Pattern pattern = Pattern.compile("<.*?>");
        while (!line.equals("END")) {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find())
                System.out.println(matcher.group());
            line = scanner.nextLine();
        }
    }
}