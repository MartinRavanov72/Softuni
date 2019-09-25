import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while(line.contains("<upcase>")) {
            int startIndex = line.indexOf("<upcase>");
            int endIndex = line.indexOf("</upcase>");
            String tobeUppered = line.substring(startIndex + 8, endIndex);
            String uppered = tobeUppered.toUpperCase();
            line = line.replaceFirst(tobeUppered, uppered);
            line = line.replaceFirst("<upcase>", "");
            line = line.replaceFirst("</upcase>", "");
        }
        System.out.println(line);
    }
}