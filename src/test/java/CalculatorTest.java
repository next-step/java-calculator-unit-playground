import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("계산기 테스트")
public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Nested
    @DisplayName("덧셈")
    class addTest{
        @Test
        @DisplayName("두 인자로 덧셈 연산")
        void add(){
            int a = 1,  b = 4;

            int actual = calculator.add(a, b);

            int expected = 5;

            assertEquals(expected, actual);
        }
    }

    @Nested
    @DisplayName("뺄셈")
    class subtractTest{
        @Test
        @DisplayName("두 인자로 뺄셈 연산")
        void subtract(){
            int a = 4,  b = 1;

            int actual = calculator.subtract(a, b);

            int expected = 3;

            assertEquals(expected, actual);
        }
    }

    @Nested
    @DisplayName("곱셈")
    class multiplyTest{
        @Test
        @DisplayName("두 인자로 곱셈 연산")
        void multiply(){
            int a = 1,  b = 4;

            int actual = calculator.multiply(a, b);

            int expected = 4;

            assertEquals(expected, actual);
        }
    }

    @Nested
    @DisplayName("나눗셈")
    class divideTest{
        @Test
        @DisplayName("두 인자로 나눗셈 연산")
        void divide(){
            int a = 4,  b = 2;

            int actual = calculator.divide(a, b);

            int expected = 2;

            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("두 번째 인자로 0으로 나누면 ArithmeticException 예외처리")
        void divideByZero() {
            int a = 4, b = 0;

            assertThrows(ArithmeticException.class, () -> calculator.divide(a, b));
        }
    }
}
