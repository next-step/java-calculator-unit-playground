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
        @DisplayName("덧셈 성공 테스트")
        void add_SuccessTest() {
            final int a = 3;
            final int b = 5;
            final int actual = a+b;

            assertEquals(actual, calculator.add(a,b));
        }

        @Test
        @DisplayName("덧셈 실패 테스트")
        void add_FailTest() {
            final int a = 3;
            final int b = 5;

            assertNotEquals(0, calculator.add(a,b));
        }
    }

    @Nested
    @DisplayName("뺄셈 데스트")
    class subtractTest {

        @Test
        @DisplayName("뺄셈 성공 테스트")
        void subtract_SuccessTest() {
            final int a = 5;
            final int b = 3;
            final int actual = a-b;

            assertEquals(actual, calculator.subtract(a,b));
        }

        @Test
        @DisplayName("뺄셈 실패 테스트")
        void subtract_FailTest() {
            final int a = 5;
            final int b = 3;

            assertNotEquals(0, calculator.subtract(a,b));
        }
    }

    @Nested
    @DisplayName("곱셈 테스트")
    class multiplyTest {

        @Test
        @DisplayName("곱셈 성공 테스트")
        void multiply_SuccessTest() {
            final int a = 5;
            final int b = 3;
            final int actual = a*b;

            assertEquals(actual, calculator.multiply(a,b));
        }

        @Test
        @DisplayName("곱셈 실패 테스트")
        void multiply_FailTest() {
            final int a = 5;
            final int b = 3;

            assertNotEquals(0, calculator.multiply(a,b));
        }
    }

    @Nested
    @DisplayName("나눗셈 테스트")
    class divideTest {

        @Test
        @DisplayName("나눗셈 성공 테스트")
        void divide_SuccessTest() {
            final int a = 15;
            final int b = 3;
            final int actual = a/b;

            assertEquals(actual, calculator.divide(a,b));
        }

        @Test
        @DisplayName("나눗셈 실패 테스트")
        void divide_FailTest() {
            final int a = 15;
            final int b = 0;

            assertThrows(ArithmeticException.class, () -> calculator.divide(a,b));
        }
    }
}
