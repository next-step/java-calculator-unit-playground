package calculator.domain;

public class Calculator {
    private static int firstOperand;
    private static int secondOperand;

    public Calculator(int firstOperand, int secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }

    public static int add() {
        return firstOperand + secondOperand;
    }

    public static int subtract() {
        return firstOperand - secondOperand;
    }

    public static int multiply() {
        return firstOperand * secondOperand;
    }

    public static int divide() {
        return firstOperand / secondOperand;
    }
}
