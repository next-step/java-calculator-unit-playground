import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Nested
    class Add {

        @Test
        @DisplayName("두 정수를 더한 결과를 반환한다.")
        void add() {
            assertEquals(11, calculator.add(6, 5));
        }

        @Test
        @DisplayName("0과 0을 더한 결과를 반환한다.")
        void addZero() {
            assertEquals(0, calculator.add(0, 0));
        }

        @Test
        @DisplayName("음수와 양수를 더한 결과가 반환한다.")
        void addNegativeAndPositive() {
            assertEquals(2, calculator.add(-1, 3));
            assertEquals(-1, calculator.add(2, -3));
        }

        @Test
        @DisplayName("두 음수를 더한 결과를 반환한다.")
        void addNegative() {
            assertEquals(-5, calculator.add(-2, -3));
        }

        @Test
        @DisplayName("덧셈 오버플로우")
        void addOverflow() {
            assertThrows(ArithmeticException.class, () -> calculator.add(Integer.MAX_VALUE, 3));
        }

        @Test
        @DisplayName("덧셈 언더플로우")
        void addUnderflow() {
            assertThrows(ArithmeticException.class, () -> calculator.add(Integer.MIN_VALUE, -1));
        }

    }

    @Nested
    class Subtract {

        @Test
        @DisplayName("두 정수를 뺀 결과를 반환한다.")
        void subtract() {
            assertEquals(5, calculator.subtract(10, 5));
        }

        @Test
        @DisplayName("0과 0을 뺀 결과를 반환한다.")
        void subtractZero() {
            assertEquals(0, calculator.subtract(0, 0));
        }

        @Test
        @DisplayName("음수와 음수를 뺀 결과를 반환한다.")
        void subtractNegative() {
            assertEquals(1, calculator.subtract(-2, -3));
        }

        @Test
        @DisplayName("음수와 양수를 뺀 결과를 반환한다.")
        void subtractNegativeAndPositive() {
            assertEquals(5, calculator.subtract(2, -3));
            assertEquals(-5, calculator.subtract(-2, 3));
        }

        @Test
        @DisplayName("뺄셈 오버플로우")
        void subtractOverflow() {
            assertThrows(ArithmeticException.class, () -> calculator.subtract(Integer.MAX_VALUE, -1));
        }

        @Test
        @DisplayName("뺄셈 언더플로우")
        void subtractUnderflow() {
            assertThrows(ArithmeticException.class, () -> calculator.subtract(Integer.MIN_VALUE, 1));
        }

    }

    @Nested
    class Multiply {

        @Test
        @DisplayName("두 정수를 곱한 결과를 반환한다.")
        void multiply() {
            assertEquals(12, calculator.multiply(4, 3));
        }

        @Test
        @DisplayName("0과 0을 곱한 결과를 반환한다.")
        void multiplyZero() {
            assertEquals(0, calculator.multiply(0, 0));
        }

        @Test
        @DisplayName("음수와 양수를 곱한 결과를 반환한다.")
        void multiplyNegativeAndPositive() {
            assertEquals(-6, calculator.multiply(2, -3));
            assertEquals(-6, calculator.multiply(-2, 3));
        }

        @Test
        @DisplayName("두 음수를 곱한 결과를 반환한다.")
        void multiplyNegative() {
            assertEquals(6, calculator.multiply(-2, -3));
        }

        @Test
        @DisplayName("곱셈 오버플로우")
        void multiplyOverflow() {
            assertThrows(ArithmeticException.class, () -> calculator.multiply(Integer.MAX_VALUE, 2));
        }

    }

    @Nested
    class Divide {

        @Test
        @DisplayName("0으로 나눠줄 경우 예외가 발생한다.")
        void divideZero() {
            assertThrows(ArithmeticException.class, () -> calculator.divide(3, 0));
            assertThrows(ArithmeticException.class, () -> calculator.divide(-3, 0));
        }

        @Test
        @DisplayName("두 정수를 나눈 결과를 반환한다.")
        void divide() {
            assertEquals(3, calculator.divide(6, 2));
        }

        @Test
        @DisplayName("음수와 양수를 나눈 결과를 반환한다.")
        void divideNegativeAndPositive() {
            assertEquals(-2, calculator.divide(-4, 2));
            assertEquals(-2, calculator.divide(4, -2));
        }

        @Test
        @DisplayName("음수와 음수를 나눈 결과를 반환한다.")
        void divideNegative() {
            assertEquals(2, calculator.divide(-6, -3));
        }

        @Test
        @DisplayName("나눗셈 오버플로우")
        void divideOverflow() {
            assertThrows(ArithmeticException.class, () -> calculator.divide(Integer.MIN_VALUE, -1));
        }

    }
}
