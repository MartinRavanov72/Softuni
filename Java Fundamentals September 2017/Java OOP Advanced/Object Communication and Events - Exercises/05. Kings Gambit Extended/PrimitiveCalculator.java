package b_secondPrinciple;

public class PrimitiveCalculator {
    private static Strategy currentStrategy = AdditionStrategy.getInstance();
    private static PrimitiveCalculator instance = new PrimitiveCalculator();

    private PrimitiveCalculator(){}

    public static PrimitiveCalculator getInstance() {
        return instance;
    }

    public void changeStrategy(Strategy strategy){
        currentStrategy = strategy;
    }

    public int performCalculation(int firstOperand, int secondOperand){
        return currentStrategy.calculate(firstOperand, secondOperand);
    }
}
