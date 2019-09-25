import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        List<Identificatable> citizens = new ArrayList<>();
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] input = scan.readLine().split("\\s+");
            if (input[0].equals("End")) break;
            if (input.length == 3) {
                citizens.add(new Person(input[2]));
            } else {
                citizens.add(new Robot(input[1]));
            }
        }

        String targetId = scan.readLine();
        for (Identificatable citizen : citizens) {
            if (citizen.getID().endsWith(targetId)) {
                System.out.println(citizen.getID());
            }
        }
    }
}
