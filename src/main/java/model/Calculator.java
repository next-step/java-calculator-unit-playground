package model;

public class Calculator {

    public int plus(double x, double y) {
        return (int) (x + y);
    }

    public int minus(double x, double y) {
        return (int) (x - y);
    }

    public int multiply(double x, double y) {
        return (int) (x * y);
    }

    public int divide(double x, double y) {
        if (y == 0) {
            throw new IllegalArgumentException("[ERROR] 0으로는 나눌 수 없습니다.");
        }
        return (int) (x/y);
    }
}
