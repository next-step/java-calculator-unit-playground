import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Nested
    class CalculatorMethodTest {
        @Test
        @DisplayName("덧셈 테스트")
        void testAdd() {
            assertEquals(3, calculator.plus(1, 2));
            assertEquals(-5, calculator.plus(30, -35));
            assertEquals(4, calculator.plus(3.6, 0.4));
            assertEquals(5, calculator.plus(4.1, 1));
            assertThrows(IllegalArgumentException.class, () -> calculator.plus(1, Integer.MAX_VALUE));
        }

        @Test
        @DisplayName("뺄셈 테스트")
        void testMinus() {
            assertEquals(5, calculator.minus(10, 5));
            assertEquals(-10, calculator.minus(10, 20));
            assertEquals(3, calculator.minus(7.1, 4.1));
            assertEquals(4, calculator.minus(-1, -5.9));
            assertThrows(IllegalArgumentException.class, () -> calculator.minus(Integer.MIN_VALUE, 1));
        }

        @Test
        @DisplayName("곱셈 테스트")
        void testMultiply() {
            assertEquals(10, calculator.multiply(2, 5));
            assertEquals(0, calculator.multiply(1, 0));
            assertEquals(8, calculator.multiply(3.5, 2.4));
            assertEquals(-4, calculator.multiply(2, -2));
            assertEquals(10, calculator. multiply(-2.5, -4));
            assertThrows(IllegalArgumentException.class, () -> calculator.multiply(Integer.MAX_VALUE, 2));
            assertThrows(IllegalArgumentException.class, () -> calculator.multiply(Integer.MIN_VALUE, 0.5));
        }

        @Test
        @DisplayName("나눗셈 테스트")
        void testDevide() {
            assertThrows(IllegalArgumentException.class, () -> calculator.devide(10, 0));
            assertEquals(2, calculator.devide(10, 5));
            assertEquals(0, calculator.devide(0, 10));
            assertEquals(-3, calculator.devide(12, -4));
            assertEquals(6, calculator.devide(-30, -5));
            assertEquals(4, calculator.devide(8.6, 2));
            assertThrows(IllegalArgumentException.class, () -> calculator.devide(Integer.MIN_VALUE, 0.5));
            assertThrows(IllegalArgumentException.class, () -> calculator.devide(Integer.MAX_VALUE, 0.25));
        }
    }
}
