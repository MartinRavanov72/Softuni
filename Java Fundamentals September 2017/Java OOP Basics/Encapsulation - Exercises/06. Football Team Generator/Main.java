package a_DefiningClassesEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Team> teams = new LinkedHashMap<>();
        while(true){
            String[] lineParams = scanner.readLine().split(";");
            if ("END".equalsIgnoreCase(lineParams[0])) {
                break;
            }
            try{
                switch (lineParams[0]){
                    case "Team":
                        Team team = new Team(lineParams[1]);
                        teams.put(lineParams[1], team);
                        break;
                    case "Add":
                        if (teams.containsKey(lineParams[1])) {
                            teams.get(lineParams[1]).addPlayer(lineParams[2], Integer.parseInt(lineParams[3]), Integer.parseInt(lineParams[4]), Integer.parseInt(lineParams[5]), Integer.parseInt(lineParams[6]), Integer.parseInt(lineParams[7]));
                        } else {
                            System.out.println("Team " + lineParams[1] + " does not exist.");
                        }
                        break;
                    case "Remove":
                        if (teams.containsKey(lineParams[1])) {
                            teams.get(lineParams[1]).removePlayer(lineParams[2]);
                        } else {
                            System.out.println("Team " + lineParams[1] + " does not exist.");
                        }
                        break;
                    case "Rating":
                        if (teams.containsKey(lineParams[1])) {
                            System.out.println(teams.get(lineParams[1]));
                        } else {
                            System.out.println("Team " + lineParams[1] + " does not exist.");
                        }
                }
            }
            catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
            }

        }

    }
}