public class Calculator {
    public int plus(double x, double y) {
        if(x > Integer.MAX_VALUE - y) throw new IllegalArgumentException("두 수의 합이 계산 가능한 범위를 벗어났습니다.");
        return (int)(x + y);
    }

    public int minus(double x, double y) {
        if(x < Integer.MIN_VALUE + y) throw new IllegalArgumentException("두 수의 차가 계산 가능한 범위를 벗어났습니다.");
        return (int)(x - y);
    }

    public int multiply(double x, double y) {
        if(x * y > Integer.MAX_VALUE || x / y < Integer.MIN_VALUE) throw new IllegalArgumentException("두 수의 곱이 계산 가능한 범위를 벗어났습니다.");
        return (int)(x * y);
    }

    public int devide(double x, double y) {
        if (y == 0) throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        if(x / y > Integer.MAX_VALUE || x / y < Integer.MIN_VALUE) throw new IllegalArgumentException("두 수의 나눗셈이 계산 가능한 범위를 벗어났습니다.");
        return (int)(x / y);
    }
}
