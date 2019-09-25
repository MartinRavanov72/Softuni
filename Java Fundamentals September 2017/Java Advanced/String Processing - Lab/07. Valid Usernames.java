import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_-]{3,16}$");
        String line = scanner.nextLine();
        List<String> output = new LinkedList<>();
        int cnt = 0;
        int cnt1 = 0;
        while (!line.equals("END")) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()){
                output.add("valid");
            }
            else {
                output.add("invalid");
                cnt++;
            }
            cnt1++;
            line = scanner.nextLine();
        }
        if (cnt == cnt1) {

        }
        else {
            for (int i = 0; i < output.size(); i++) {
                System.out.println(output.get(i));
            }
        }
    }
}