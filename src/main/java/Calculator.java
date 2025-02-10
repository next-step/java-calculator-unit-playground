public class Calculator {

    public int add(int a, int b) {
        checkAdditionOverflow(a, b);
        return a + b;
    }

    private void checkAdditionOverflow(int a, int b) {
        if (a > 0 && b > 0 && a > Integer.MAX_VALUE - b) {
            throw new ArithmeticException("덧셈 오버플로우 발생");
        }
        if (a < 0 && b < 0 && a < Integer.MIN_VALUE - b) {
            throw new ArithmeticException("덧셈 언더플로우 발생");
        }
    }

    public int subtract(int a, int b) {
        checkSubtractionOverflow(a, b);
        return a - b;
    }

    private void checkSubtractionOverflow(int a, int b) {
        if (a > 0 && b < 0 && a > Integer.MAX_VALUE + b) {
            throw new ArithmeticException("뺄셈 오버플로우 발생");
        }
        if (a < 0 && b > 0 && a < Integer.MIN_VALUE + b) {
            throw new ArithmeticException("뺄셈 언더플로우 발생");
        }
    }

    public int multiply(int a, int b) {
        checkMultiplicationOverflow(a, b);

        return a * b;
    }

    private void checkMultiplicationOverflow(int a, int b) {
        if (a > 0 && b > 0 && a > Integer.MAX_VALUE / b) {
            throw new ArithmeticException("곱셈 오버플로우 발생");
        }
    }

    public int divide(int a, int b) {
        checkDivisionOverflow(a, b);
        checkDivisionByZero(a, b);

        return a / b;
    }

    private void checkDivisionOverflow(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1) {
            throw new ArithmeticException("나눗셈 오버플로우 발생");

        }
    }

    private void checkDivisionByZero(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("정수는 0으로 나눌 수 없습니다.");
        }
    }
}
