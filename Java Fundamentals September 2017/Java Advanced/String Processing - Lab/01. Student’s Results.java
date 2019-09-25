import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(String.format("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|", "Name", "JAdv", "JavaOOP", "AdvOOP", "Average"));
        String line = scanner.nextLine();
        String[] lineParams = line.split(", ");
        double jadvNote = Double.parseDouble(lineParams[0].split(" - ")[1]);
        String name = lineParams[0].split(" - ")[0];
        double jadaoopNote = Double.parseDouble(lineParams[1]);
        double advoopNote = Double.parseDouble(lineParams[2]);
        double avg = (jadvNote + jadaoopNote + advoopNote)/3;
        System.out.println(String.format("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|", name, jadvNote, jadaoopNote, advoopNote, (jadvNote + jadaoopNote + advoopNote)/3));
    }
}