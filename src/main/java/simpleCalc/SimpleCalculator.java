package simpleCalc;

public class SimpleCalculator {

    public static int add(int x, int y) {
        return x + y;
    }

    public static int substract(int x, int y) {
        return x - y;
    }

    public static int multiply(int x, int y) {
        return x * y;
    }

    public static int divide(int x, int y) {
        if (y == 0) throw new RuntimeException("0으로 나눌 수 없습니다.");
        return x / y;
    }

}
