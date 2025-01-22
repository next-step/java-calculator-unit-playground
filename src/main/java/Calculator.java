public class Calculator {
    public int plus(int x, int y) {
        if(x > Integer.MAX_VALUE - y) throw new IllegalArgumentException("두 수의 합이 계산 가능한 범위를 벗어났습니다.");
        return x + y;
    }

    public int minus(int x, int y) {
        if(x < Integer.MIN_VALUE + y) throw new IllegalArgumentException("두 수의 차가 계산 가능한 범위를 벗어났습니다.");
        return x - y;
    }

    public int multiply(int x, int y) {
        if(x > Integer.MAX_VALUE / y || x < Integer.MIN_VALUE / y) throw new IllegalArgumentException("두 수의 곱이 계산 가능한 범위를 벗어났습니다.");
        return x * y;
    }

    public int devide(int x, int y) {
        if (y == 0) throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        return x / y;
    }
}
