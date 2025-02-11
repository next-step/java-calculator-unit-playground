import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("초간단 계산기 테스트")
class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Nested
    class Add {
        @Test
        void add() {
            assertEquals(5, calculator.add(2, 3));
        }
    }

    @Nested
    class Subtract {
        @Test
        void subtract() {
            assertEquals(-3, calculator.subtract(3, 6));
        }
    }

    @Nested
    class Multiply {
        @Test
        void multiply() {
            assertEquals(6, calculator.multiply(2, 3));
        }
    }

    @Nested
    class Divide{
        @Test
        @DisplayName("0으로 나누면 ArithmeticException 예외가 발생한다.")
        void should_throw_exception_when_divide_by_zero() {
            assertThrows(ArithmeticException.class, () -> calculator.divide(3,0));
        }

        @Test
        void divideByNotZero() {
            assertEquals(2, calculator.divide(6, 3));
        }
    }
}
