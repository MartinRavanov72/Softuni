package a_DefiningClassesEx;

abstract class Vehicle {
    private final double FUEL_CONSUMPTION_INCREASE = this.getClass().getSimpleName().equals("Car") ? 0.9 : 1.6;
    private final double BUS_FUEL_CONSUMPTION_INCREASE = 1.4;

    double fuelQuantity;
    double fuelConsumption;
    double tankCapacity;

    Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
        this.setFuelQuantity(fuelQuantity);
    }

    void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (this.tankCapacity < fuelQuantity + this.fuelQuantity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuelQuantity += fuelQuantity;
    }

    void drive(double kilometers) {
        double increase = this.getClass().getSimpleName().equals("Bus") ? BUS_FUEL_CONSUMPTION_INCREASE : FUEL_CONSUMPTION_INCREASE;
        double fuelConsumption = kilometers * (this.fuelConsumption + increase);
        if (fuelConsumption > this.fuelQuantity) {
            throw new IllegalArgumentException(this.getClass().getSimpleName() + " needs refueling");
        }
        this.fuelQuantity -= fuelConsumption;
    }

    void refuel(double fuel) {
        final double finalLiters = this.getClass().getSimpleName().equals("Truck") ? fuel -= fuel * 0.05 : fuel;
        if (finalLiters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.setFuelQuantity(finalLiters);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}