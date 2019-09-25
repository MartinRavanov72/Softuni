import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        Map<String, TreeSet<String>> followers = new HashMap<>();
        Map<String, List<String>> following = new HashMap<>();
        while(true){
            String[] input = scanner.readLine().split("\\s+");
            if ("Statistics".equals(input[0])) {
                break;
            }
            if ("joined".equals(input[1])) {
                if (!followers.containsKey(input[0])) {
                    followers.put(input[0], new TreeSet<>());
                    following.put(input[0], new ArrayList<>());
                }
            }
            else if ("followed".equals(input[1])){
                if ((followers.containsKey(input[0]) && followers.containsKey(input[2])) && (!input[0].equals(input[2]) && (!following.get(input[0]).contains(input[2])))) {
                    followers.get(input[2]).add(input[0]);
                    following.get(input[0]).add(input[2]);
                }
            }
        }
        System.out.println("The V-Logger has a total of " + followers.keySet().size() + " vloggers in its logs.");
        int cnt = 1;
        List<String> a = new ArrayList<>(followers.keySet());
        Comparator<String> comp = (x, y) -> Integer.compare(followers.get(y).size(), followers.get(x).size());
        Comparator<String> comp2 = (x, y) -> Integer.compare(following.get(x).size(), following.get(y).size());
        Collections.sort(a, comp.thenComparing(comp2));
        for (String key : a) {
            System.out.println(cnt + ". " + key + " : " + followers.get(key).size() + " followers, " + following.get(key).size() + " following");
            if (cnt==1) {
                if (followers.get(key).size() != 0) {
                    for (String follower : followers.get(key)) {
                        System.out.println("*  " + follower);
                    }
                }
            }
            cnt++;
        }
    }
}