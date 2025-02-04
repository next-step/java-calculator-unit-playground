import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Nested
    class Add {

        @Test
        @DisplayName("Normal")
        void add() {
            assertEquals(11, calculator.add(6, 5));
        }
    }

    @Nested
    class Subtract {

        @Test
        @DisplayName("Normal")
        void subtract() { assertEquals(5, calculator.subtract(10, 5));
        }
    }

    @Nested
    class Multiply {

        @Test
        @DisplayName("Normal")
        void multiply() {
            assertEquals(12, calculator.multiply(4, 3));
        }
    }

    @Nested
    class divide {

        @Test
        @DisplayName("Zero exception")
        void divideZero() {
            assertThrows(ArithmeticException.class, () -> calculator.divide(3, 0));
        }

        @Test
        @DisplayName("Normal")
        void divideNonZero() {
            assertEquals(3, calculator.divide(6, 2));
        }
    }
}