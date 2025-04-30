package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "3, 5, 8",
            "-1, -2, -3",
            "-5, 5, 0"
    })
    @DisplayName("덧셈: 두 수를 더한 결과를 반환한다.")
    void addMethod(int firstNumber, int secondNumber, int expected) {
        int result = calculator.add(firstNumber, secondNumber);
        assertThat(expected).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource({
            "5, 2, 3",
            "10, 5, 5",
            "0, 0, 0",
            "-5, -5, 0"
    })
    @DisplayName("뺄셈: 두 수를 뺀 결과를 반환한다.")
    void subtractMethod(int firstNumber, int secondNumber, int expected) {
        int result = calculator.subtract(firstNumber, secondNumber);
        assertThat(expected).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource({
            "2, 3, 6",
            "-2, 3, -6",
            "0, 5, 0",
            "-3, -3, 9"
    })
    @DisplayName("곱셈: 두 수를 곱한 결과를 반환한다.")
    void multiplyMethod(int firstNumber, int secondNumber, int expected) {
        int result = calculator.multiply(firstNumber, secondNumber);
        assertThat(expected).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource({
            "6, 3, 2",
            "9, 3, 3",
            "-9, 3, -3",
            "10, -2, -5"
    })
    @DisplayName("나눗셈: 두 수를 나눈 결과를 반환한다.")
    void divideMethod(int firstNumber, int secondNumber, int expected) {
        int result = calculator.divide(firstNumber, secondNumber);
        assertThat(expected).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource({
            "5, 0",
            "0, 0",
            "-3, 0"
    })
    @DisplayName("나눗셈: 0으로 나누면 IllegalArgumentException이 발생한다.")
    void divideByZeroException(int firstNumber, int secondNumber) {
//        assertThrows(IllegalArgumentException.class, () -> calculator.divide(firstNumber, secondNumber));
        assertThatThrownBy(() -> calculator.divide(firstNumber, secondNumber))
                .isInstanceOf(IllegalArgumentException.class);

    }
}