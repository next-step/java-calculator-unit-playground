import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {

    private static final int SCALE = 18;
    private static final RoundingMode ROUNDING = RoundingMode.HALF_UP;

    public BigDecimal add(BigDecimal a, BigDecimal b) {
        return normalize(a.add(b));
    }

    public BigDecimal subtract(BigDecimal a, BigDecimal b) {
        return normalize(a.subtract(b));
    }

    public BigDecimal multiply(BigDecimal a, BigDecimal b) {
        return normalize(a.multiply(b));
    }

    public BigDecimal divide(BigDecimal a, BigDecimal b) {
        if (b.compareTo(BigDecimal.ZERO) == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return a.divide(b, SCALE, ROUNDING);
    }

    private BigDecimal normalize(BigDecimal value) {
        return value.setScale(SCALE, ROUNDING);
    }
}