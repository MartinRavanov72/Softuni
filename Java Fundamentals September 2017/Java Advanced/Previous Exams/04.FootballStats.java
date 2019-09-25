import sun.reflect.generics.tree.Tree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, TreeMap<String, List<String>>> data = new HashMap<>();
        while(true){
            String input = scanner.readLine();
            List<String> footballMatches = Arrays.stream(input.split("[ \\-\\:]")).filter(x -> !x.isEmpty()).collect(Collectors.toList());
            if ("Season End".equals(input)) {
                break;
            }
            String team1 = footballMatches.get(0);
            String team2 = footballMatches.get(1);
            int result1 = Integer.parseInt(footballMatches.get(3));
            int result2 = Integer.parseInt(footballMatches.get(4));
            if (data.containsKey(team1)) {
                if (data.get(team1).containsKey(team2)) {
                    data.get(team1).get(team2).add(result1 + " " + result2);
                }
                else {
                    data.get(team1).put(team2, new ArrayList<>());
                    data.get(team1).get(team2).add(result1 + " " + result2);
                }
            }
            else {
                data.put(team1, new TreeMap<>());
                data.get(team1).put(team2, new ArrayList<>());
                data.get(team1).get(team2).add(result1 + " " + result2);
            }
            if (data.containsKey(team2)) {
                if (data.get(team2).containsKey(team1)) {
                    data.get(team2).get(team1).add(result2 + " " + result1);
                }
                else {
                    data.get(team2).put(team1, new ArrayList<>());
                    data.get(team2).get(team1).add(result2 + " " + result1);
                }
            }
            else {
                data.put(team2, new TreeMap<>());
                data.get(team2).put(team1, new ArrayList<>());
                data.get(team2).get(team1).add(result2 + " " + result1);
            }
        }

        List<String> searchedTeams = Arrays.stream(scanner.readLine().split(", ")).collect(Collectors.toList());
        for (String team : searchedTeams) {
            for (Map.Entry<String, TreeMap<String, List<String>>> kvp : data.entrySet()) {
                if (team.equals(kvp.getKey())) {
                    for (Map.Entry<String, List<String>> enemyTeam : kvp.getValue().entrySet()) {
                        for (String a : enemyTeam.getValue()) {
                            System.out.println(kvp.getKey() + " - " + enemyTeam.getKey() + " -> " + a.split(" ")[0] + ":" + a.split(" ")[1]);
                        }
                    }
                }
            }
        }
    }
}