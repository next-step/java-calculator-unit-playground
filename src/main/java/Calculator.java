public class Calculator {

    public int add(final int leftOperand, final int rightOperand) {
        return leftOperand + rightOperand;
    }

    public int subtract(final int leftOperand, final int rightOperand) {
        return leftOperand - rightOperand;
    }

    public int multiply(final int leftOperand, final int rightOperand) {
        return leftOperand * rightOperand;
    }

    public int divide(final int leftOperand, final int rightOperand) {
        if (rightOperand == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return leftOperand / rightOperand;
    }
}
