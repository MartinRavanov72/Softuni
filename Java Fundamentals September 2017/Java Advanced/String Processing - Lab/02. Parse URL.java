import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if (!line.contains("://")) {
            System.out.println("Invalid URL");
        }
        else {
            String[] lineParams = line.split("://");
            if (lineParams.length > 2) {
                System.out.println("Invalid URL");
            }
            else {
                String protocol = lineParams[0];
                int serverEndIndex = lineParams[1].indexOf("/");
                String server = lineParams[1].substring(0, serverEndIndex);
                String resource = lineParams[1].substring(serverEndIndex + 1, lineParams[1].length());
                System.out.println("Protocol = " + protocol);
                System.out.println("Server = " + server);
                System.out.println("Resources = " + resource);
            }
        }

    }
}