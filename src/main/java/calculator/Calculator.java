package calculator;

public class Calculator {

    long add(int a, int b) {
        return (long) a + b;
    }

    long minus(int a, int b) {
        return (long) a - b;
    }

    long multiply(int a, int b) {
        return (long) a * b;
    }

    long divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return (long) a / b;
    }
}
