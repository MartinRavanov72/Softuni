package Avatar.benders;

public class EarthBender extends Bender{
    private double groundSaturation;

    public EarthBender(String name, int power, double groundSaturation) {
        super(name, power);
        this.groundSaturation = groundSaturation;
    }

    @Override
    public double getTotalPower() {
        return super.getPower() * this.groundSaturation;
    }

    @Override
    public String toString() {
        return "Earth Bender: " + super.getName() + ", " + "Power: " + super.getPower() + ", " + "Ground Saturation: " + String.format("%.2f", this.groundSaturation);
    }
}
