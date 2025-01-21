public class Calculator_Simple {
    private static int result = 0;
    public static int add(int a, int b) {
        result = a + b;
        return result;
    }

    public static int sub(int a, int b) {
        result = a - b;
        return result;
    }

    public static int mul(int a, int b) {
        result = a * b;
        return result;
    }

    public static int div(int a, int b) {
        result = a / b;
        return result;
    }
}
