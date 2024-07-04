public class Calculator {
    int add (int a, int b) {
        return a + b;
    }

    int subtract(int a, int b) {
        return a - b;
    }

    int multiply(int a, int b) {
        return a * b;
    }

    int divide(int a, int b) {
        if(b == 0) {
            throw new IllegalArgumentException("0으로는 나눌 수 없습니다.");
        }
        return a / b;
    }
}
