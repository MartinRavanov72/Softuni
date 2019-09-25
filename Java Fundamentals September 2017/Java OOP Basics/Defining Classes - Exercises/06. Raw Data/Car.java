package a_DefiningClassesEx;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire[] tires;

    Car (String model, Engine engine, Cargo cargo, Tire[] tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public String getModel() {
        return this.model;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public Tire[] getTires() {
        return this.tires;
    }

    public boolean checkTyresPressure() {
        for (Tire tyre : tires) {
            if (tyre.getPressure() < 1) {
                return true;
            }
        }
        return false;
    }

}
