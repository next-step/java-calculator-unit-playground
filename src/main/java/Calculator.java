public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtraction(int a, int b) {
        return a - b;
    }

    public int multiplication(int a, int b) {
        return a * b;
    }

    public int division(int a, int b) {
        if (a < b) {
            throw new ArithmeticException("작은 값으로 큰 값을 나눌 수 없습니다.");
        }
        return a / b;
    }
}
