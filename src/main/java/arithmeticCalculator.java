public class arithmeticCalculator {
//    private static final String PLUS = "+";
//    private static final String MINUS = "-";
//    private static final String DIVIDE = "-";
//    private static final String MULTIPLY = "-";
    private static int result;


    void plusCalculate(int num1, int num2) {
        result = num1 + num2;
    }

    void minusCalculate(int num1, int num2) {
        if (num1 > num2) {
            result = num1 - num2;
        } else if (num1 < num2) {
            result = num2 - num1;
        }
    }

    void divideCalculate(int num1, int num2) {
        if (num1 > num2) {
            result = num1 / num2;
        } else if (num1 < num2) {
            result = num2 / num1;
        }
    }

    void multipleCaculate(int num1, int num2) {
        result = num1 * num2;
    }
}
