import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CalculatorJunit5Test {

    private Calculator calculator = new Calculator();

    @Nested
    @DisplayName("덧셈 테스트")
    public class AddTest {

        @Test
        public void 정수_더하기() {
            assertEquals(5, calculator.add(2, 3));
            assertEquals(0, calculator.add(-1, 1));
            assertEquals(-5, calculator.add(-2, -3));
        }
    }

    @Nested
    @DisplayName("뺄셈 테스트")
    public class SubtractTest {

        @Test
        public void 정수_빼기() {
            assertEquals(1, calculator.subtract(3, 2));
            assertEquals(-2, calculator.subtract(-1, 1));
            assertEquals(1, calculator.subtract(-2, -3));
        }
    }

    @Nested
    @DisplayName("곱셈 테스트")
    public class MultiplyTest {

        @Test
        public void 정수_곱하기() {
            assertEquals(6, calculator.multiply(2, 3));
            assertEquals(-1, calculator.multiply(-1, 1));
            assertEquals(6, calculator.multiply(-2, -3));
        }
    }

    @Nested
    @DisplayName("나눗셈 테스트")
    public class DivideTest {

        @Test
        public void 정수_나누기() {
            assertEquals(2, calculator.divide(6, 3));
            assertEquals(-1, calculator.divide(-3, 3));
            assertEquals(1, calculator.divide(-3, -3));
        }

        @Test
        public void 예외_0_나누기() {
            assertThrows(IllegalArgumentException.class, () -> calculator.divide(1, 0));
            assertDoesNotThrow(() -> calculator.divide(0, 1));
        }

        @Test
        public void 나누기_결과가_정수가_아닐때() {
            assertEquals(2, calculator.divide(5, 2));
            assertEquals(0, calculator.divide(1, 2));
        }
    }
}
