package b_secondPrinciple;

public class DivisionStrategy implements Strategy{
    private static DivisionStrategy instance = new DivisionStrategy();

    private DivisionStrategy() {}

    public static Strategy getInstance() {
        return instance;
    }

    @Override
    public int calculate(int a, int b) {
        return a / b;
    }
}