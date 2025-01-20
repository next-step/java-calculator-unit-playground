public class Calculate {

    private final StringCalculate stringCalculate = new StringCalculate();

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
        return a / b;
    }

    public int calculateFromString(String input) {
        return stringCalculate.sum(input);
    }
}
