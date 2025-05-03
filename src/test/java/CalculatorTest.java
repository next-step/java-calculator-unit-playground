import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("계산기 테스트")
public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Nested
    @DisplayName("덧셈 테스트")
    class AddTest{

        @Test
        @DisplayName("주어진 인자 2개를 더한 결과를 반환한다")
        void add_CanCalulate() {

            // given
            int a = 3;
            int b = 2;

            // when
            int actual = calculator.add(a,b);

            // then
            int expected = 5;

            assertEquals(expected,actual);
        }
    }

    @Nested
    @DisplayName("뺄셈 테스트")
    class SubtractTest{

        @Test
        @DisplayName("주어진 인자 2개를 뺀 결과를 반환한다")
        void subtract_CanCalulate() {

            // given
            int a = 3;
            int b = 2;

            // when
            int actual = calculator.subtract(a,b);

            // then
            int expected = 1;

            assertEquals(expected,actual);
        }
    }

    @Nested
    @DisplayName("곱셈 테스트")
    class MultiplyTest{

        @Test
        @DisplayName("주어진 인자 2개를 곱한 결과를 반환한다")
        void multiply_CanCalulate() {

            // given
            int a = 3;
            int b = 2;

            // when
            int actual = calculator.multiply(a,b);

            // then
            int expected = 6;

            assertEquals(expected,actual);
        }
    }

    @Nested
    @DisplayName("나눗셈 테스트")
    class DivideTest{

        @Nested
        @DisplayName("1 - 일반적인 상황")
        class DivideGeneral {

            @Test
            @DisplayName("주어진 인자 2개를 나눈 결과를 반환한다")
            void divide_CanCalulate() {

                // given
                int a = 3;
                int b = 2;

                // when
                int actual = calculator.divide(a, b);

                // then
                int expected = 1;

                assertEquals(expected, actual);
            }
        }

        @Nested
        @DisplayName("2 - 예외적인 상황")
        class DivideException {

            @Test
            @DisplayName("0으로 나눴을 때 예외처리가 발생된다.")
            void divide_ByZero_ExceptionThrown() {

                int a = 3;
                int b = 0;

                assertThrows(ArithmeticException.class, () -> calculator.divide(a,b));

            }
        }

    }

}
