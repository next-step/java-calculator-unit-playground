package calculator;

public class Calculator {
    int add(int num1, int num2) {
        return num1 + num2;
    }

    int subtract(int num1, int num2) {
        return num1 - num2;
    }

    int multiply(int num1, int num2) {
        return num1 * num2;
    }

    int divide(int num1, int num2) {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            throw new RuntimeException("분모에 0이 입력되었습니다.");
        }
    }
}
