package a_DefiningClassesEx;

public class Engine {
    private String model;
    private Integer power;
    private String displacement;
    private String efficiency;

    Engine (String model, int power) {
        this (model, power, "n/a" ,"n/a");
    }

    Engine (String model, int power, int displacement) {
        this (model, power, displacement + "" ,"n/a");
    }

    Engine (String model, int power, String efficiency) {
        this (model, power, "n/a" ,efficiency);
    }

    Engine (String model, int power, String displacement, String efficiency){
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getModel() {
        return this.model;
    }

    public Integer getPower() {
        return this.power;
    }

    public String getDisplacement() {
        return this.displacement;
    }

    public String getEfficiency() {
        return this.efficiency;
    }
}
