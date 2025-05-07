package calculator;

public class BasicCalculator implements Calculator {
    @Override
    public int add(final int a, final int b) {
        return a + b;
    }

    @Override
    public int subtract(final int a, final int b) {
        return a - b;
    }

    @Override
    public int multiply(final int a, final int b) {
        return a * b;
    }

    @Override
    public int divide(final int a, final int b) {
        return a / b;
    }
}
