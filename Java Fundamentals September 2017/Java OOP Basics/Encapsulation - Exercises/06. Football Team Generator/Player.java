package a_DefiningClassesEx;

public class Player {
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(int endurance, int sprint, int dribble, int passing, int shooting) {
        if(endurance < 0 || endurance > 100){
            throw new IllegalArgumentException("Endurance should be between 0 and 100.");
        }
        if(sprint < 0 || sprint > 100){
            throw new IllegalArgumentException("Sprint should be between 0 and 100.");
        }
        if(dribble < 0 || dribble > 100){
            throw new IllegalArgumentException("Dribble should be between 0 and 100.");
        }
        if(passing < 0 || passing > 100){
            throw new IllegalArgumentException("Passing should be between 0 and 100.");
        }
        if(shooting < 0 || shooting > 100){
            throw new IllegalArgumentException("Shooting should be between 0 and 100.");
        }
        this.endurance = endurance;
        this.sprint = sprint;
        this.dribble = dribble;
        this.passing = passing;
        this.shooting = shooting;
    }

    public int getAverageScore() {
        return Integer.parseInt(String.format("%.0f", (this.endurance + this.sprint + this.dribble + this.passing + this.shooting) / (double)5));
    }
}
