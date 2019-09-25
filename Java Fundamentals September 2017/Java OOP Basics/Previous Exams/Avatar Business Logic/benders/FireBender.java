package Avatar.benders;

public class FireBender extends Bender{
    private double heatAggression;

    public FireBender(String name, int power, double heatAggression) {
        super(name, power);
        this.heatAggression = heatAggression;
    }

    @Override
    public double getTotalPower() {
        return super.getPower() * this.heatAggression;
    }

    @Override
    public String toString() {
        return "Fire Bender: " + super.getName() + ", " + "Power: " + super.getPower() + ", " + "Heat Aggression: " + String.format("%.2f", this.heatAggression);
    }
}
