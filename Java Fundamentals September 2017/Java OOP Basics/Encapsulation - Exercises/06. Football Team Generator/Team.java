package a_DefiningClassesEx;

import java.util.LinkedHashMap;
import java.util.Map;

public class Team {
    private String name;
    private LinkedHashMap<String, Player> players;
    private int averageScore;

    public Team(String name) {
        if (name == null || "".equals(name.trim())) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
        this.players = new LinkedHashMap<>();
        this.averageScore = 0;
    }


    public void addPlayer(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        try{
            Player player = new Player(endurance, sprint, dribble, passing, shooting);
            this.players.put(name, player);
        }
        catch (IllegalArgumentException iae){
            throw new IllegalArgumentException(iae.getMessage());
        }
    }

    public double getAverageScore() {
        if (this.players.size() == 0) {
            return 0;
        }
        for (Map.Entry<String, Player> kvp : this.players.entrySet()) {
            this.averageScore += kvp.getValue().getAverageScore();
        }
        this.averageScore /= this.players.size();
        return this.averageScore;
    }

    public void removePlayer(String name){
        if (this.players.containsKey(name)) {
            this.players.remove(name);
        } else {
            throw new IllegalArgumentException("Player "+ name +" is not in "+ this.name +" team.");
        }


    }

    @Override
    public String toString() {
        return String.format("%s - %.0f", this.name, this.getAverageScore());
    }
}
