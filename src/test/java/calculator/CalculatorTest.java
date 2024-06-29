package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Nested
    class 더하기_연산을_수행한다 {

        @ParameterizedTest(name = "{0} + {1} = {2}")
        @CsvSource(value = {"1,2,3", "3,4,7", "100000,10000,110000"}, delimiter = ',')
        void addTest(int a, int b, int result) {
            assertThat(calculator.add(a, b)).isEqualTo(result);
        }
    }

    @Nested
    class 빼기_연산을_수행한다 {

        @ParameterizedTest(name = "{0} - {1} = {2}")
        @CsvSource(value = {"2,1,1", "1,2,-1", "1234,1234,0"}, delimiter = ',')
        void addTest(int a, int b, int result) {
            assertThat(calculator.minus(a, b)).isEqualTo(result);
        }
    }

    @Nested
    class 곱하기_연산을_수행한다 {

        @ParameterizedTest(name = "{0} x {1} = {2}")
        @CsvSource(value = {"2,1,2", "1,-42,-42", "1234,2,2468"}, delimiter = ',')
        void multiplyTest(int a, int b, int result) {
            assertThat(calculator.multiply(a, b)).isEqualTo(result);
        }
    }

    @Nested
    class 나누기_연산을_수행한다 {

        @ParameterizedTest(name = "{0} / {1} = {2}")
        @CsvSource(value = {"2,1,2", "6,2,3", "2468,2,1234"}, delimiter = ',')
        void divideTest(int a, int b, int result) {
            assertThat(calculator.divide(a, b)).isEqualTo(result);
        }

        @ParameterizedTest(name = "0으로 나누면 예외: {0} / {1} = {2}")
        @CsvSource(value = {"2,0,1", "6,0,2", "2468,0,2"}, delimiter = ',')
        void divideZeroTest(int a, int b) {
            assertThrows(RuntimeException.class, () -> calculator.divide(a, b));
        }
    }

    @Nested
    class 문자열_더하기를_수행한다 {

        @DisplayName("빈 값이 들어오는 경우 0을 반환")
        @ParameterizedTest(name = ("{0}이 들어오는 경우 0을 반환한다"))
        @EmptySource
        void withEmptyString(String input) {
            assertEquals(0, calculator.stringSum(input));
        }

        @Test
        @DisplayName("null이 들어오는 경우 예외")
        void withNull() {
            assertThrows(RuntimeException.class, () -> {
                calculator.stringSum(null);
            });
        }

        @Test
        @DisplayName("기본 구분자는 :과 ,이다")
        void default_delimiter() {
            assertEquals(15, calculator.stringSum("1:2:3:4,5"));
        }

        @Test
        @DisplayName("임의의 구분자를 지정할 수 있다")
        void stringSumTestWithCustomSeq() {
            assertEquals(11, calculator.stringSum("//y\n1y5,1y1y1y2"));
        }

        @Test
        @DisplayName("구분자 외의 문자가 입력되면 예외")
        void stringSumTestWithWrongString() {
            assertThrows(RuntimeException.class, () -> {
                calculator.stringSum("//y\n1t2t3");
            });
        }

        @Test
        @DisplayName("음수가 입력되면 예외")
        void stringSumTestWithNegative() {
            assertThrows(RuntimeException.class, () -> {
                calculator.stringSum("//y\n1y-2y3");
            });
        }
    }
}
