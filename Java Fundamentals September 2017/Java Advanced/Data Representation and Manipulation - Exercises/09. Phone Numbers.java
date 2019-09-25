import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, String> phonebook = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile("([A-Z](?:[a-zA-Z]+)?)([^a-zA-Z+]*[+]?[0-9]+[()\\/.\\- ]*[0-9]+(?:[()\\/.\\- ]+[0-9]+)*)");
        StringBuilder sb = new StringBuilder("");
        while (true){
            String input = scanner.nextLine();
            if (input.equals("END")){
                break;
            }
            sb.append(input);
        }
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()){
            String name = matcher.group(1);
            String phone = matcher.group(2);
            String phone2 = "";
            for (int i = 0; i < phone.length(); i++) {
                try {
                    if (phone.charAt(i) == '+'){
                        phone2 += "+";
                    }
                    byte digit = Byte.parseByte(phone.charAt(i) + "");
                    phone2 += digit;
                } 
                catch (Exception e){
                    
                }
            }
            phonebook.put(name, phone2);
        }
        if (phonebook.isEmpty()){
            System.out.println("<p>No matches!</p>");
        } 
        else {
            StringBuilder result = new StringBuilder("<ol>");
            for (String key : phonebook.keySet()) {
                result.append("<li><b>").append(key).append(":</b> ").append(phonebook.get(key)).append("</li>");
            }
            result.append("</ol>");
            System.out.println(result);
        }
    }
}
