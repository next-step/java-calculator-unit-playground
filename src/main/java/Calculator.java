public class Calculator {

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
        if(b == 0){ //b가 0일 경우 강제로 예외처리
            throw new ArithmeticException("Divide by zero");
        }

        return a / b;
    }
}
