import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorrrrrTest {
    private final Calculatorrrrr calculator = new Calculatorrrrr();

    @Nested
    public class TestingFunctions {
        @Test
        @DisplayName("덧셈을 해보아요")
        void add() {
            assertEquals(2025, calculator.add(2000, 25), "덧셈을 잘못하신 것 같아요..");
        }

        @Test
        @DisplayName("뺄셈을 해보아요")
        void sub() {
            assertEquals(1975, calculator.sub(2000, 25), "뺄셈을 잘못하신 것 같아요..");
        }

        @Test
        @DisplayName("곱셈을 해보아요")
        void mul() {
            assertEquals(50000, calculator.mul(2000, 25), "곱셈을 잘못하신 것 같아요..");
        }

        @Test
        @DisplayName("나눗셈을 해보아요")
        void div() {
            assertEquals(80, calculator.div(2000, 25), "나눗셈을 잘못하신 것 같아요..");
        }

        @Test
        @DisplayName("0으로 나누면 ArithmeticException이 떠야해요")
        void divWithZero() {
            ArithmeticException ex = assertThrows(ArithmeticException.class, () -> calculator.div(2000, 0));
            assertNull(ex.getMessage());
        }

    }
}
