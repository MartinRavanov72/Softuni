package a_DefiningClassesEx;

abstract class Vehicle {
    private final double FUEL_CONSUMPTION_INCREASE = this.getClass().getSimpleName().equals("Car") ? 0.9 : 1.6;

    private double fuelQuantity;
    private double fuelConsumption;

    Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    void drive(double distance) {
        Double fuelConsumption = distance * (this.fuelConsumption + FUEL_CONSUMPTION_INCREASE);
        if (fuelConsumption > this.fuelQuantity) {
            throw new IllegalArgumentException(this.getClass().getSimpleName() + " needs refueling");
        }
        this.fuelQuantity -= fuelConsumption;
    }

    void refuel(double fuel){
        final double finalLiters = this.getClass().getSimpleName().equals("Truck") ? fuel -= fuel * 0.05 : fuel;
        this.fuelQuantity += finalLiters;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",this.getClass().getSimpleName(), this.fuelQuantity);
    }
}