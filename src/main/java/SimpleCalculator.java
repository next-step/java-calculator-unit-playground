public class SimpleCalculator {

    public int add(int a, int b) {
        return Math.addExact(a, b);
    }

    public int minus(int a, int b) {
        return Math.subtractExact(a, b);
    }

    public int multiply(int a, int b) {
        return Math.multiplyExact(a, b);
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        if (a == Integer.MIN_VALUE && b == -1) {
            throw new ArithmeticException("정수 범위를 벗어났습니다.");
        }
        return a / b;
    }
}
