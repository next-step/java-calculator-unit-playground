import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource(value = {"1,2,3", "4,5,9"}, delimiter = ',')
    void add(int a, int b, int result) {
        assertThat(calculator.add(a, b)).isEqualTo(result);
    }

    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource(value = {"1,2,-1", "2,1,1"}, delimiter = ',')
    void subtract(int a, int b, int result) {
        assertThat(calculator.subtract(a, b)).isEqualTo(result);
    }

    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource(value = {"2,3,6", "4,5,20"}, delimiter = ',')
    void multiply(int a, int b, int result) {
        assertThat(calculator.multiply(a, b)).isEqualTo(result);
    }

    @Nested
    @DisplayName("나누기")
    class Divide {
        @ParameterizedTest(name = "{0} / {1} = {2}")
        @CsvSource(value = {"2,3,0", "8,4,2"}, delimiter = ',')
        void divide(int a, int b, int result) {
            assertThat(calculator.divide(a, b)).isEqualTo(result);
        }

        @ParameterizedTest(name = "0으로 나누면 예외: {0} / {1}")
        @CsvSource(value = {"2,0", "3,0", "4,0", "0,0", "-1,0"}, delimiter = ',')
        void divideByZero(int a, int b) {
            assertThrows(ArithmeticException.class, () -> calculator.divide(a, b));
        }
    }

    @Nested
    @DisplayName("문자열 더하기를 수행")
    class StringSum {
        @ParameterizedTest(name = "기본 구분자: {0}")
        @CsvSource(value = {"1,2,3|6", "1,2:3|6", "1:2:3|6"}, delimiter = '|')
        void parseAndSum(String input, int result) {
            assertThat(calculator.parseAndSum(input)).isEqualTo(result);
        }

        @ParameterizedTest(name = "커스텀 구분자: {0}")
        @ValueSource(strings = {"//;\n1;2;3"})
        void parseAndSumWithCustomSep(String input) {
            assertThat(calculator.parseAndSum(input)).isEqualTo(6);
        }

        @ParameterizedTest(name = "공백 입력:{0}")
        @ValueSource(strings = {"0", "", " ", ","})
        void parseZeroAndSum(String input) {
            assertThat(calculator.parseAndSum(input)).isZero();
        }

        @ParameterizedTest(name = "잘못된 입력: {0}")
        @NullSource
        @ValueSource(strings = {"//a\n1;2;3", "1;2;3"})
        void parseAndSumWithWrongString(String input) {
            assertThrows(RuntimeException.class, () -> calculator.parseAndSum(input));
        }
    }
}
