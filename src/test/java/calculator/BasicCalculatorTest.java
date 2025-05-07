package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BasicCalculatorTest {
    private BasicCalculator basicCalculator = new BasicCalculator();

    @Nested
    @DisplayName("덧셈 테스트")
    class AddTest {
        @ParameterizedTest(name = "{0} + {1} = {2}")
        @CsvSource({
                "0, 0, 0",
                "1, 2, 3",
                "-1, -2, -3",
                "-3, 3, 0",
                "100, 200, 300"
        })
        void add(int a, int b, int expected) {
            assertThat(basicCalculator.add(a, b)).isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("뺄셈 테스트")
    class SubtractTest {
        @ParameterizedTest(name = "{0} - {1} = {2}")
        @CsvSource({
                "5, 2, 3",
                "0, 0, 0",
                "3, 5, -2",
                "-3, -3, 0"
        })
        void subtract(int a, int b, int expected) {
            assertThat(basicCalculator.subtract(a, b)).isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("곱셈 테스트")
    class MultiplyTest {
        @ParameterizedTest(name = "{0} * {1} = {2}")
        @CsvSource({
                "2, 3, 6",
                "0, 100, 0",
                "-3, 3, -9",
                "-2, -2, 4"
        })
        void multiply(int a, int b, int expected) {
            assertThat(basicCalculator.multiply(a, b)).isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("나눗셈 테스트")
    class DivideTest {
        @ParameterizedTest(name = "{0} / {1} = {2}")
        @CsvSource({
                "6, 3, 2",
                "9, 1, 9",
                "-6, 3, -2",
                "-8, -4, 2"
        })
        void divide(int a, int b, int expected) {
            assertThat(basicCalculator.divide(a, b)).isEqualTo(expected);
        }

        @Test
        @DisplayName("0으로 나누면 예외 발생")
        void divideByZero() {
            assertThatThrownBy(() -> basicCalculator.divide(1, 0))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
