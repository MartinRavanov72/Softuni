package a_DefiningClassesEx;

public class Car {
    private String model;
    private String speed;

    Car (String model, String speed){
        this.model = model;
        this.speed = speed;
    }

    @Override
    public String toString () {
        StringBuilder sb = new StringBuilder();
        sb.append("Car:").append("\n").append(this.model).append(" ").append(this.speed);
        if (this.model.equals("")){
            return "Car:";
        }
        return sb.toString();
    }
}
