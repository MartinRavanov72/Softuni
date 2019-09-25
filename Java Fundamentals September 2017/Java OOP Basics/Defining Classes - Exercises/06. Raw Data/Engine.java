package a_DefiningClassesEx;

public class Engine {
    private int speed;
    private int power;

    Engine(int speed, int power){
        this.speed = speed;
        this.power = power;
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getPower() {
        return this.power;
    }
}
