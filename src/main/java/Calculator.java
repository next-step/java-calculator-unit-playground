public class Calculator {

    public int add(int a, int b) {
        return Math.addExact(a, b);
    }

    public int subtract(int a, int b) {
        return Math.subtractExact(a, b);
    }

    public int multiply(int a, int b) {
        return Math.multiplyExact(a, b);
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("0 나누기 오류");
        }

        return Math.floorDiv(a, b);
    }
}
