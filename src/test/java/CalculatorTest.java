import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Nested
    @DisplayName("덧셈 테스트")
    class addTest {

        @Test
        @DisplayName("정수의 합")
        void add_Test() {
            final int a = 3;
            final int b = 5;
            final int actual = a + b;

            assertEquals(actual, calculator.add(a, b));
        }
    }

    @Nested
    @DisplayName("뺄셈 데스트")
    class subtractTest {

        @Test
        @DisplayName("정수의 차")
        void subtract_Test() {
            final int a = 5;
            final int b = 3;
            final int actual = a - b;

            assertEquals(actual, calculator.subtract(a, b));
        }
    }

    @Nested
    @DisplayName("곱셈 테스트")
    class multiplyTest {

        @Test
        @DisplayName("정수의 곱셈")
        void multiply_Test() {
            final int a = 5;
            final int b = 3;
            final int actual = a * b;

            assertEquals(actual, calculator.multiply(a, b));
        }
    }

    @Nested
    @DisplayName("나눗셈 테스트")
    class divideTest {

        @Test
        @DisplayName("정수의 나눗셈")
        void divide_Test() {
            final int a = 15;
            final int b = 3;
            final int actual = a / b;

            assertEquals(actual, calculator.divide(a, b));
        }

        @Test
        @DisplayName("0으로 나누었을 때 ArithmeticException 예외 발생")
        void divideWithZero_Test() {
            final int a = 15;
            final int b = 0;

            assertThrows(ArithmeticException.class, () -> calculator.divide(a, b));
        }
    }
}
