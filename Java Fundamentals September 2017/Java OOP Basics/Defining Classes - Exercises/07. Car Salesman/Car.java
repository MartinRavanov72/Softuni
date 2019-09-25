package a_DefiningClassesEx;

public class Car {
    private String model;
    private Engine engine;
    private String weight;
    private String color;

    Car (String model, Engine engine) {
        this (model, engine, "n/a" ,"n/a");
    }

    Car (String model, Engine engine, int weight) {
        this (model, engine, weight + "" ,"n/a");
    }

    Car (String model, Engine engine, String color) {
        this (model, engine, "n/a" , color);
    }

    Car (String model, Engine engine, String weight, String color){
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString (){
        StringBuilder sb = new StringBuilder("");
        sb.append(this.model).append(":\n  ");
        sb.append(this.engine.getModel()).append(":\n    ");
        sb.append("Power: ").append(this.engine.getPower()).append("\n    ");
        sb.append("Displacement: ").append(this.engine.getDisplacement()).append("\n    ");
        sb.append("Efficiency: ").append(this.engine.getEfficiency()).append("\n  ");
        sb.append("Weight: ").append(this.weight).append("\n  ");
        sb.append("Color: ").append(this.color);
        return sb.toString();
    }
}
