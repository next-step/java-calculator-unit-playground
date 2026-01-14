import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("계산기 테스트")
public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    private static final int SCALE = 18;
    private static final RoundingMode ROUNDING = RoundingMode.HALF_UP;

    private BigDecimal bd(String v) {
        return new BigDecimal(v);
    }

    private BigDecimal bd18(String v) {
        return new BigDecimal(v).setScale(SCALE, ROUNDING);
    }

    @Nested
    @DisplayName("덧셈")
    class addTest{
        @Test
        @DisplayName("두 인자로 덧셈 연산")
        void add(){
            BigDecimal a = bd("4");
            BigDecimal b = bd("3");

            BigDecimal actual = calculator.add(a, b);

            BigDecimal expected = bd18("7");
            assertEquals(expected, actual);
        }
    }

    @Nested
    @DisplayName("뺄셈")
    class subtractTest{
        @Test
        @DisplayName("두 인자로 뺄셈 연산")
        void subtract(){
            BigDecimal a = bd("4");
            BigDecimal b = bd("3");

            BigDecimal actual = calculator.subtract(a, b);

            BigDecimal expected = bd18("1");
            assertEquals(expected, actual);
        }
    }

    @Nested
    @DisplayName("곱셈")
    class multiplyTest{
        @Test
        @DisplayName("두 인자로 곱셈 연산")
        void multiply(){
            BigDecimal a = bd("1");
            BigDecimal b = bd("3.2");

            BigDecimal actual = calculator.multiply(a, b);

            BigDecimal expected = bd18("3.2");
            assertEquals(expected, actual);
        }
    }

    @Nested
    @DisplayName("나눗셈")
    class divideTest{
        @Test
        @DisplayName("두 인자로 나눗셈 연산")
        void divide(){
            BigDecimal a = bd("4");
            BigDecimal b = bd("3");

            BigDecimal actual = calculator.divide(a, b);

            BigDecimal expected = bd18("1.333333333333333333");
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("두 번째 인자로 0으로 나누면 ArithmeticException 예외처리")
        void divideByZero() {
            BigDecimal a = bd("4");
            BigDecimal b = bd("0");

            assertThrows(ArithmeticException.class, () -> calculator.divide(a, b));
        }
    }
}
