package org.duckstudy.calculator.core;

public class IntegerCalculator implements Calculator<Integer> {
    private Integer result = 0;

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
        result = 0;
    }
}
