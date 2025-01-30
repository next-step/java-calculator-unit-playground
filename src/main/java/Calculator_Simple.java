public class Calculator_Simple {
    private int result = 0;
    public int add(int a, int b) {
        result = a + b;
        return result;
    }

    public int sub(int a, int b) {
        result = a - b;
        return result;
    }

    public int mul(int a, int b) {
        result = a * b;
        return result;
    }

    public int div(int a, int b) {
        result = a / b;
        return result;
    }
}
