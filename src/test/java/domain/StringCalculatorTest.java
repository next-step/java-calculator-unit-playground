package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator();

    @Test
    @DisplayName("빈 문자열 또는 null 입력 시 결과는 0이다")
    void returnZero_whenInputIsEmptyOrNull() {
        assertThat(calculator.calculateSum("")).isZero();
        assertThat(calculator.calculateSum(null)).isZero();
    }

    @Test
    @DisplayName("쉼표 또는 콜론 구분자로 구분된 숫자를 합산한다")
    void sumNumbers_whenDefaultDelimiters() {
        assertThat(calculator.calculateSum("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자가 지정된 경우 해당 구분자로 숫자를 합산한다")
    void sumNumbers_whenCustomDelimiter() {
        assertThat(calculator.calculateSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName("음수가 포함된 경우 예외를 던진다")
    void throwException_whenNegativeNumberExists() {
        assertThatThrownBy(() -> calculator.calculateSum("1,-2,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
