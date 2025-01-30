public class SimpleCalculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            // 0으로 나눌 때 예외 처리 발생
            throw new IllegalArgumentException("0으로 나눗셈 불가");
        }
        return a / b;
    }
}
