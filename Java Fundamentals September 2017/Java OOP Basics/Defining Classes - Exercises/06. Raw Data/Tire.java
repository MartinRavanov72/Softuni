package a_DefiningClassesEx;

public class Tire {
    private double pressure;
    private int age;

    Tire (double pressure, int age) {
        this.pressure = pressure;
        this.age = age;
    }

    public double getPressure() {
        return this.pressure;
    }

    public int getAge() {
        return this.age;
    }
}
