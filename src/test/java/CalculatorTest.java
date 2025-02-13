import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Nested
    @DisplayName("덧셈 테스트")
    class addTest {

        private final Calculator calculator = new Calculator();

        @Test
        @DisplayName("두 정수의 합을 반환한다.")
        void shouldReturnSumOfTwoIntegers() {
            final int a = 3;
            final int b = 5;
            final int actual = 8;

            assertThat(actual).isEqualTo(calculator.add(a, b));
        }

        @Test
        @DisplayName("두 음수 정수의 합을 반환한다.")
        void shouldReturnSumOfTwoNegativeIntegers() {
            final int a = -3;
            final int b = -5;
            final int actual = -8;

            assertThat(actual).isEqualTo(calculator.add(a, b));
        }
    }

    @Nested
    @DisplayName("뺄셈 데스트")
    class subtractTest {

        @Test
        @DisplayName("두 정수의 차를 반환한다.")
        void shouldReturnSubtractOfTwoIntegers() {
            final int a = 5;
            final int b = 3;
            final int actual = 2;

            assertThat(actual).isEqualTo(calculator.subtract(a, b));
        }

        @Test
        @DisplayName("두 음수 정수의 차를 반환한다.")
        void shouldReturnSubtractOfTwoNegativeIntegers() {
            final int a = -5;
            final int b = -3;
            final int actual = -2;

            assertThat(actual).isEqualTo(calculator.subtract(a, b));
        }
    }

    @Nested
    @DisplayName("곱셈 테스트")
    class multiplyTest {

        @Test
        @DisplayName("두 정수의 곱을 반환한다.")
        void shouldReturnMultiplyOfTwoIntegers() {
            final int a = 5;
            final int b = 3;
            final int actual = 15;

            assertThat(actual).isEqualTo(calculator.multiply(a, b));
        }

        @Test
        @DisplayName("두 음수 정수의 곱을 반환한다.")
        void shouldReturnMultiplyOfTwoNegativeIntegers() {
            final int a = -5;
            final int b = -3;
            final int actual = 15;

            assertThat(actual).isEqualTo(calculator.multiply(a, b));
        }
    }

    @Nested
    @DisplayName("나눗셈 테스트")
    class divideTest {

        @Test
        @DisplayName("두 정수의 몫을 반환한다.")
        void shouldReturnDivideOfTwoIntegers() {
            final int a = 15;
            final int b = 3;
            final int actual = 5;

            assertThat(actual).isEqualTo(calculator.divide(a, b));
        }

        @Test
        @DisplayName("두 음수 정수의 몫을 반환한다.")
        void shouldReturnDivideOfTwoNegativeIntegers() {
            final int a = -15;
            final int b = -3;
            final int actual = 5;

            assertThat(actual).isEqualTo(calculator.divide(a, b));
        }

        @Test
        @DisplayName("정수를 0으로 나누면 ArithmeticException이 발생한다.")
        void shouldReturnDivideWithZeroOfTwoIntegers() {
            final int a = 15;
            final int b = 0;

            assertThatThrownBy(() -> calculator.divide(a, b)).isInstanceOf(ArithmeticException.class);
        }
    }
}
