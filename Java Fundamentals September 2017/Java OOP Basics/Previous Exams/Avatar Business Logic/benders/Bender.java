package Avatar.benders;

public abstract class Bender {
    private String name;
    private int power;

    Bender(String name, int power) {
        this.name = name;
        this.power = power;
    }

    String getName() {
        return name;
    }

    int getPower() {
        return power;
    }

    public abstract double getTotalPower();
}
