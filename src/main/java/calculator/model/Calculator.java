package calculator.model;

import calculator.exception.exceptions.DivideZeroOperationException;

public class Calculator {

    private static final int NOT_PERMITTED_DIVIDE_NUMBER = 0;

    public int add(final int number1, final int number2) {
        return number1 + number2;
    }

    public int minus(final int number1, final int number2) {
        return number1 - number2;
    }

    public int multiply(final int number1, final int number2) {
        return number1 * number2;
    }

    public int divide(final int number1, final int number2) {
        if (number2 == NOT_PERMITTED_DIVIDE_NUMBER) {
            throw new DivideZeroOperationException();
        }
        return number1 / number2;
    }
}
