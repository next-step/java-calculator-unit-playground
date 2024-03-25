package org.duckstudy.calculator.core;

public class BasicCalculator implements Calculator{
    private int result = 0;
    @Override
    public int add(int value) {
        return result += value;
    }

    @Override
    public int subtract(int value) {
        return result -= value;
    }

    @Override
    public int multiply(int value) {
        return result *= value;
    }

    @Override
    public int divide(int value) {
        if (value == 0){
            throw new ArithmeticException("Division by zero is not accepted");
        }
        return result /= value;
    }

    @Override
    public void reset() {
        result = 0;
    }
}
