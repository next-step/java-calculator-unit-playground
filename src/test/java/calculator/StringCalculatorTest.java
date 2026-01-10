package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;


class StringCalculatorTest {

    private final StringCalculator stringCalculator = new StringCalculator();

    @DisplayName("일반적인 입력에 대해 정상값을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4", "1:2:3:4", "1,2:3,4"})
    void add(String input) {
        // when
        int result = stringCalculator.add(input);

        // then
        assertThat(result).isEqualTo(10);
    }

    @DisplayName("Null 값을 입력하거나 공백을 입력하면 0을 반환한다.")
    @NullAndEmptySource
    @ParameterizedTest
    void return_zero_when_null_or_blank(String input) {
        // when
        int result = stringCalculator.add(input);

        // then
        assertThat(result).isZero();
    }

    @DisplayName("정규식 특수문자가 들어가도 정상값을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"//*\n1*2*3", "//.\n1.2.3", "//+\n1+2+3", "//?\n1?2?3"})
    void add_when_regex_special_characters(String input) {
        // when
        int result = stringCalculator.add(input);

        // then
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("음수가 포함되면 예외를 발생시킨다.")
    @Test
    void throw_runtime_exception_when_contains_negative_number() {
        // given
        String input = "1,2,3,-4";

        // when & then
        assertThatThrownBy(() -> stringCalculator.add(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("음수가 포함되어 있습니다.");
    }

    @DisplayName("숫자가 아닌 값이 포함되어 있으면 예외를 발생시킨다.")
    @Test
    void throw_runtime_exception_when_contains_non_numeric() {
        // given
        String input = "1,2,t,4";

        // when & then
        assertThatThrownBy(() -> stringCalculator.add(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("숫자가 아닌 값이 포함되어 있습니다.");
    }

    @DisplayName("커스텀 구분자 입력 형식이 올바르지 않으면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"//\n1,2", "//;1;2", "///;\\n1;2", "//\n\n1\n2\n3"})
    void throw_runtime_exception_when_custom_delimiter_format_is_invalid(String input) {
        // when & then
        assertThatThrownBy(() -> stringCalculator.add(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("커스텀 구분자 입력 형식이 올바르지 않습니다.");
    }
}
