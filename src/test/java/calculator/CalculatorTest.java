package calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class CalculatorTest {
    private static Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @DisplayName("두 개의 정수를 더한 결과를 반환할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3", "2,3,5", "3,6,9"})
    void testAdd(int num1, int num2, int expected) {
        // when
        int actual = calculator.add(num1, num2);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("두 개의 정수를 뺀 결과를 반환할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"3,2,1", "9,3,6", "1,4,-3"})
    void testSubtract(int num1, int num2, int expected) {
        // when
        int actual = calculator.subtract(num1, num2);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("두 개의 정수를 곱한 결과를 반환할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"3,6,18", "6,0,0", "3,-3,-9"})
    void testMultiply(int num1, int num2, int expected) {
        // when
        int actual = calculator.multiply(num1, num2);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("두 개의 정수를 나눈 결과를 반환할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"6,3,2", "0,6,0", "9,-3,-3"})
    void testDivide(int num1, int num2, int expected) {
        // when
        int actual = calculator.divide(num1, num2);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("0으로 나누었을 때 에러가 발생한다.")
    @Test
    void testDividedByZero() {
        // when & then
        assertThatThrownBy(() -> calculator.divide(6, 0)).isInstanceOf(ArithmeticException.class);
    }
}
