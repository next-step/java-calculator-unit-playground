import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Nested
    @DisplayName("덧셈 기능")
    class Addition {

        @Test
        @DisplayName("두 정수의 합을 계산한다")
        void add() {
            final int a = 3;
            final int b = 5;
            final int expected = a + b;

            assertEquals(expected, calculator.add(a, b));
        }
    }

    @Nested
    @DisplayName("뺄셈 기능")
    class Subtraction {

        @Test
        @DisplayName("두 정수의 차를 계산한다")
        void subtract() {
            final int a = 5;
            final int b = 3;
            final int expected = a - b;

            assertEquals(expected, calculator.subtract(a, b));
        }
    }

    @Nested
    @DisplayName("곱셈 기능")
    class Multiplication {

        @Test
        @DisplayName("두 정수의 곱을 계산한다")
        void multiply() {
            final int a = 5;
            final int b = 3;
            final int expected = a * b;

            assertEquals(expected, calculator.multiply(a, b));
        }

        @Test
        @DisplayName("정수 오버플로우 발생 시 ArithmeticException이 발생한다")
        void multiplyOverflow() {
            int a = Integer.MAX_VALUE;
            int b = 2;
            assertThrows(ArithmeticException.class, () -> calculator.multiply(a, b));
        }
    }

    @Nested
    @DisplayName("나눗셈 기능")
    class Division {

        @Test
        @DisplayName("두 정수의 나눗셈을 계산한다")
        void divide() {
            final int a = 15;
            final int b = 3;
            final int expected = a / b;

            assertEquals(expected, calculator.divide(a, b));
        }

        @Test
        @DisplayName("0으로 나누면 ArithmeticException이 발생한다")
        void divideByZero() {
            final int a = 15;
            final int b = 0;

            assertThrows(ArithmeticException.class, () -> calculator.divide(a, b));
        }
    }
}
