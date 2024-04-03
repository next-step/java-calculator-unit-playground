package model;

public class Calculator {

    public int plus(double x, double y) {
        if (x + y > Integer.MAX_VALUE) {
            throw new IllegalArgumentException();
        }
        return getValidResult(x + y);
    }

    public int minus(double x, double y) {
        return getValidResult(x - y);
    }

    public int multiply(double x, double y) {
        return getValidResult(x * y);
    }

    public int divide(double x, double y) {
        if (y == 0) {
            throw new IllegalArgumentException("[ERROR] 0으로는 나눌 수 없습니다.");
        }
        return getValidResult(x / y);
    }

    private int getValidResult(double input) {
        if (input > Integer.MAX_VALUE || input < Integer.MIN_VALUE ) {
            throw new IllegalArgumentException("[ERROR] 결과 값이 표현 가능한 정수 범위를 넘어갔습니다.");
        }
        return (int) input;
    }
}
