public class Calculator {

    public int add(int a, int b) {
        validateOperation(a, b, Operator.ADD);

        return a + b;
    }

    public int subtract(int a, int b) {
        validateOperation(a, b, Operator.SUBTRACT);

        return a - b;
    }

    public int multiply(int a, int b) {
        validateOperation(a, b, Operator.MULTIPLY);

        return a * b;
    }

    public int divide(int a, int b) {
        validateOperation(a, b, Operator.DIVIDE);

        return a / b;
    }

    private void validateOperation(int a, int b, Operator operator) {
        switch (operator) {
            case ADD, SUBTRACT, MULTIPLY -> {
                validateOverflow(a, b, operator);
                validateUnderflow(a, b, operator);
            }
            case DIVIDE -> validateDivide(b);
        }
    }

    private void validateOverflow(int a, int b, Operator operator) {
        switch (operator) {
            case ADD -> {
                if ((long) a + (long) b > Integer.MAX_VALUE) {
                    throw new IllegalArgumentException(String.format("(%d) + (%d)는 오버플로우가 발생합니다.", a, b));
                }
            }
            case SUBTRACT -> {
                if ((long) a - (long) b > Integer.MAX_VALUE) {
                    throw new IllegalArgumentException(String.format("(%d) - (%d)는 오버플로우가 발생합니다.", a, b));
                }
            }
            case MULTIPLY -> {
                if ((long) a * (long) b > Integer.MAX_VALUE) {
                    throw new IllegalArgumentException(String.format("(%d) * (%d)는 오버플로우가 발생합니다.", a, b));
                }
            }
        }
    }

    private void validateUnderflow(int a, int b, Operator operator) {
        switch (operator) {
            case ADD -> {
                if ((long) a + (long) b < Integer.MIN_VALUE) {
                    throw new IllegalArgumentException(String.format("(%d) + (%d)는 언더플로우가 발생합니다.", a, b));
                }
            }
            case SUBTRACT -> {
                if ((long) a - (long) b < Integer.MIN_VALUE) {
                    throw new IllegalArgumentException(String.format("(%d) - (%d)는 언더플로우가 발생합니다.", a, b));
                }
            }
            case MULTIPLY -> {
                if ((long) a * (long) b < Integer.MIN_VALUE) {
                    throw new IllegalArgumentException(String.format("(%d) * (%d)는 언더플로우가 발생합니다.", a, b));
                }
            }
        }
    }

    private void validateDivide(int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
    }

    enum Operator {
        ADD, SUBTRACT, MULTIPLY, DIVIDE
    }
}
