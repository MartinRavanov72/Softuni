package b_secondPrinciple;

public class SubtractionStrategy implements Strategy {

    private static SubtractionStrategy instance = new SubtractionStrategy();

    private SubtractionStrategy() {}

    public static Strategy getInstance() {
        return instance;
    }

    @Override
    public int calculate(int a, int b) {
        return a - b;
    }
}