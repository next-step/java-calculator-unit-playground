public class Calculatorrrrr {
    public int add(int a, int b) {
        return a + b;
    }
    public int sub(int a, int b) {
        return a - b;
    }
    public int mul(int a, int b) {
        return a * b;
    }
    public int div(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException(사용자가 0으로 나눴다는데요?)");
            throw new ArithmeticException();
        }
    }
}
