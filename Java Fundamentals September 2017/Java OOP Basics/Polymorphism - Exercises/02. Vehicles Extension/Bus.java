package a_DefiningClassesEx;

public class Bus extends Vehicle {
    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    public void driveEmpty(double kilometers) {
        double fuelConsumption = kilometers * this.fuelConsumption;
        if (fuelConsumption > this.fuelQuantity) {
            throw new IllegalArgumentException(this.getClass().getSimpleName() + " needs refueling");
        }
        this.fuelQuantity -= fuelConsumption;
    }
}
