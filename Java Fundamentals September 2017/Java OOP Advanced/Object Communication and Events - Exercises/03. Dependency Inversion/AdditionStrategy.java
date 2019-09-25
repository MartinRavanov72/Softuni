package b_secondPrinciple;

public class AdditionStrategy implements Strategy{
    private static AdditionStrategy instance = new AdditionStrategy();

    private AdditionStrategy() {}

    public static Strategy getInstance() {
        return instance;
    }

    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
}
