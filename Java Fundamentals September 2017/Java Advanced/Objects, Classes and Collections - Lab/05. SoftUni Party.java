import java.util.*;

public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<String> vip = new TreeSet<>();
        TreeSet<String> guests = new TreeSet<>();
        while (true){
            String input = scanner.nextLine();
            if ("PARTY".equals(input)){
                break;
            }
            if (input.length() == 8) {
                try {
                    int n = Integer.parseInt(input.substring(0, 1));
                    vip.add(input);
                } 
                catch (Exception e) {
                    guests.add(input);
                }
            }
        }
        while (true){
            String input = scanner.nextLine();
            if ("END".equals(input)){
                break;
            }
            try {
                int n = Integer.parseInt(input.substring(0,1));
                if (vip.contains(input)) {
                    vip.remove(input);
                }
            } 
            catch (Exception e){
                if (guests.contains(input)) {
                    guests.remove(input);
                }
            }
        }
        System.out.println(vip.size() + guests.size());
        for (String s : vip){
            System.out.println(s);
        }
        for (String s: guests){
            System.out.println(s);
        }
    }
}
