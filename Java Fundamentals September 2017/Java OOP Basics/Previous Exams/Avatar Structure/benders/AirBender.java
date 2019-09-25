package Avatar.benders;

public class AirBender extends Bender {
    private double aerialIntegrity;

    public AirBender(String name, int power, double aerialIntegrity) {
        super(name, power);
        this.aerialIntegrity = aerialIntegrity;
    }

    @Override
    public double getTotalPower() {
        return super.getPower() * this.aerialIntegrity;
    }

    @Override
    public String toString() {
        return "Air Bender: " + super.getName() + ", " + "Power: " + super.getPower() + ", " + "Aerial Integrity: " + String.format("%.2f", this.aerialIntegrity);
    }
}
