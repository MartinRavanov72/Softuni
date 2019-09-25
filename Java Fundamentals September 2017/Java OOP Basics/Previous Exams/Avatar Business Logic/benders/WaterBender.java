package Avatar.benders;

public class WaterBender extends Bender{
    private double waterClarity;

    public WaterBender(String name, int power, double waterClarity) {
        super(name, power);
        this.waterClarity = waterClarity;
    }

    @Override
    public double getTotalPower() {
        return super.getPower() * this.waterClarity;
    }

    @Override
    public String toString() {
        return "Water Bender: " + super.getName() + ", " + "Power: " + super.getPower() + ", " + "Water Clarity: " + String.format("%.2f", this.waterClarity);
    }
}
