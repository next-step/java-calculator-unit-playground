package org.duckstudy.calculator.core;

public class IntegerCalculator implements Calculator<Integer, Integer> {
    private static final int INITIAL_RESULT = 0;
    private Integer result = INITIAL_RESULT;

    @Override
    public Integer add(Integer value) {
        return result += value;
    }

    @Override
    public Integer subtract(Integer value) {
        return result -= value;
    }

    @Override
    public Integer multiply(Integer value) {
        return result *= value;
    }

    @Override
    public Integer divide(Integer value) throws ArithmeticException {
        if (value == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return result /= value;
    }

    @Override
    public void reset() {
        result = INITIAL_RESULT;
    }
}
