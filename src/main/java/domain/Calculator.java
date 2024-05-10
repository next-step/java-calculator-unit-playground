package domain;

public class Calculator {

    private final int CAN_NOT_BE_DIVIDE_NUMBER = 0;

    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public int subtract(int num1, int num2) {
        return num1 - num2;
    }

    public int multiple(int num1, int num2) {
        return num1 * num2;
    }

    public int divide(int num1, int num2) {
        if (num2 == CAN_NOT_BE_DIVIDE_NUMBER) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return num1 / num2;
    }
}
