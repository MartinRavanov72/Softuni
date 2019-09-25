package b_secondPrinciple;

public class MultiplicationStrategy implements Strategy{
    private static MultiplicationStrategy instance = new MultiplicationStrategy();

    private MultiplicationStrategy() {}

    public static Strategy getInstance() {
        return instance;
    }

    @Override
    public int calculate(int a, int b) {
        return a * b;
    }
}