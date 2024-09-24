package calculator.domain;

public class Calculator {
    private static int firstOperand;
    private static int secondOperand;
    private static char operator;

    public Calculator(int firstOperand, int secondOperand, char operator) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operator = operator;
    }

    public static int getResult() {
        if ('+' == operator) {
            return firstOperand + secondOperand;
        }
        else if ('-' == operator) {
            return firstOperand - secondOperand;
        }
        else if ('*' == operator) {
            return firstOperand * secondOperand;
        }
        else if ('/' == operator) {
            return firstOperand / secondOperand;
        }
        throw new IllegalArgumentException("Invalid operator");
    }
}
