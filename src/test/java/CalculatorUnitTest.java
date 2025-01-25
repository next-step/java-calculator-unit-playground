import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("계산기 단위 테스트")
public class CalculatorUnitTest {

    private final Calculator calculator = new Calculator();

    @Nested
    @DisplayName("JUnit5 테스트")
    class JUnit5Test {

        @Test
        @DisplayName("Positive - 덧셈 테스트")
        void add() {
            assertEquals(9, calculator.add(6, 3));
        }

        @Test
        @DisplayName("Positive - 뺄셈 테스트")
        void subtract() {
            assertEquals(3, calculator.subtract(6, 3));
        }

        @Test
        @DisplayName("Positive - 곱셈 테스트")
        void multiply() {
            assertEquals(18, calculator.multiply(6, 3));
        }

        @Test
        @DisplayName("Positive - 나눗셈 테스트")
        void divide() {
            assertEquals(2, calculator.divide(6, 3));
        }

        @Test
        @DisplayName("Negative - 0으로 나누기 예외 발생")
        void divideByZero() {
            assertThrows(IllegalArgumentException.class, () -> calculator.divide(6, 0));
        }
    }
}
