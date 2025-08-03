package domain;

import exception.ErrorMessage;

public class Calculator {

    public int add(int num1, int num2) {
        return Math.addExact(num1, num2);
    }

    public int sub(int num1, int num2) {
        return Math.subtractExact(num1, num2);
    }

    public int mul(int num1, int num2) {
        return Math.multiplyExact(num1, num2);
    }

    public int div(int num1, int num2) {
        if (num2 == 0)
            throw new ArithmeticException(ErrorMessage.DIVIDE_BY_ZERO);

        return num1 / num2;
    }
}
