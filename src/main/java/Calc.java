public class Calc {
    public int add(int a, int b) {
        int res = a + b;
        return res;
    }

    public int minus(int a, int b) {
        int res = a - b;
        return res;
    }

    public int times(int a, int b) {
        int res = a * b;
        return res;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("0 으로 나눌 수 없습니다.");
        }
        int res = a / b;
        return res;
    }
}