package calculator;

public class SimpleCalculator {
    // 덧셈 기능
    public int add(int a, int b) {
        return a + b;
    }
    // 뺄셈 기능
    public int substract(int a, int b) {
        return a - b;
    }
    // 곱하기 기능
    public int multiply(int a, int b) {
        return a * b;
    }
    // 나눗셈 기능
    public int divide(int a, int b) {
        // b에 0이 오면 나눗셈 불가
        if (b == 0) {
            throw new ArithmeticException("Divide by zero.");
        }

        return a / b;
    }
}
