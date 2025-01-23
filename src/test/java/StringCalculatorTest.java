import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    @ParameterizedTest
    @DisplayName("문자열 계산기 기능 테스트")
    @ValueSource(strings = {"1:2:3", "1,2,3", "3:2,1", "3,2:1"})
    public void testDefaultDelimeter(String str) {
        assertThat(StringCalculator.calculate(str)).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    @DisplayName("공백을 줬을 경우 테스트")
    public void testEmptyValue(String value) {
        assertThat(StringCalculator.calculate(value)).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//!!\n1!!2!!3"})
    @DisplayName("커스텀 구분자 테스트")
    public void testCustomDelimeter(String value) {
        assertThat(StringCalculator.calculate(value)).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"/;\n1;2;3", "/;\t1;2;3", "//;;\n1;2;3", "// n1 2 3"})
    @DisplayName("커스텀 구분자 형식에 맞지 않을 경우 예외 발생 테스트")
    public void testCustomDelimeterFormatError(String value) {
        assertThatThrownBy(() -> StringCalculator.calculate(value)).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("커스텀 구분자에 아무것도 주지 않은 상황 테스트")
    public void testEmptyCustomDelimeter() {
        assertThatThrownBy(() -> StringCalculator.calculate("//\n1;2;3")).isInstanceOf(RuntimeException.class);
    }
}