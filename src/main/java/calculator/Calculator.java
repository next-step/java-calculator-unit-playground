package calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {

    public long add(double a, double b) {
        return roundAndValidate(a + b);
    }

    public long subtract(double a, double b) {
        return roundAndValidate(a - b);
    }

    public long multiply(double a, double b) {
        return roundAndValidate(a * b);
    }

    public long divide(double a, double b) {
        if (b == 0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
        return roundAndValidate(a / b);
    }

    private long roundAndValidate(double result) {

        if (!Double.isFinite(result)) {
            throw new ArithmeticException("유효하지 않은 산술 연산 결과입니다.");
        }

        if (result > Long.MAX_VALUE || result < Long.MIN_VALUE) {
            throw new ArithmeticException("산술 연산 결과가 long 타입의 범위를 벗어났습니다.");
        }

        return BigDecimal.valueOf(result)
                         .setScale(0, RoundingMode.HALF_UP)
                         .longValue();
    }
}