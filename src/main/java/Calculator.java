public class Calculator {

    public int add(int num1, int num2) {
        return calculate(num1, num2, "+");
    }

    public int subtract(int num1, int num2) {
        return calculate(num1, num2, "-");
    }

    public int multiply(int num1, int num2) {
        return calculate(num1, num2, "*");
    }

    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return calculate(dividend, divisor, "/");
    }

    private int calculate(int num1, int num2, String operation) {
        validateNumber(num1);
        validateNumber(num2);

        return switch (operation) {
            case "+" -> Math.addExact(num1, num2);
            case "-" -> Math.subtractExact(num1, num2);
            case "*" -> Math.multiplyExact(num1, num2);
            case "/" -> num1 / num2;
            default -> throw new UnsupportedOperationException("지원되지 않는 연산입니다.");
        };
    }

    private void validateNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        }
    }
}
