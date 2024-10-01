package calculator.domain;

public class Calculator {

    public static int add(int firstOperand, int secondOperand) {
        return firstOperand + secondOperand;
    }

    public static int subtract(int firstOperand, int secondOperand) {
        return firstOperand - secondOperand;
    }

    public static int multiply(int firstOperand, int secondOperand) {
        return firstOperand * secondOperand;
    }

    public static int divide(int firstOperand, int secondOperand) {
        validateDividerIsZero(secondOperand);

        return firstOperand / secondOperand;
    }

    private static void validateDividerIsZero(int number) {
        if(isZero(number)) throw new IllegalArgumentException("Division by zero");
    }

    private static boolean isZero(int number) {
        return number == 0;
    }
}
