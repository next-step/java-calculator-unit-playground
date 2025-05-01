package domain;

public class Calculator {

    private static final String DIVIDE_BY_ZERO_ERROR_MESSAGE = "[ERROR] 0으로 나눌 수 없습니다.";

    public int add(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    public int subtract(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }

    public int multiply(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }

    public int divide(int firstNumber, int secondNumber) {
        if (secondNumber == 0) {
            throw new IllegalArgumentException(DIVIDE_BY_ZERO_ERROR_MESSAGE);
        }
        return firstNumber / secondNumber;
    }
}
