package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("문자열 계산기 도메인 테스트")
public class StringCalculatorTest {

    @Nested
    @DisplayName("기본 입력값 검증")
    class BasicInputTest {
        @ParameterizedTest
        @NullAndEmptySource
        @DisplayName("입력값이 null이거나 비어있으면 0을 반환한다")
        void should_return_zero_when_input_is_null_or_empty(String input) {
            // assertEquals(0, StringCalculator.splitAndSum(input));
            assertThat(StringCalculator.splitAndSum(input)).isEqualTo(0);
        }

        @Test
        @DisplayName("숫자 하나만 입력된 경우 해당 숫자를 반환한다")
        void should_return_single_number() {
            // assertEquals(1, StringCalculator.splitAndSum("1"));
            assertThat(StringCalculator.splitAndSum("1")).isEqualTo(1);
        }
    }

    @Nested
    @DisplayName("구분자 분리 및 합산 검증")
    class DelimiterAndSumTest {
        @ParameterizedTest
        @CsvSource(value = {"1,2|3", "1:2|3", "1,2:3|6"}, delimiter = '|')
        @DisplayName("쉼표(,) 또는 콜론(:)을 구분자로 사용하여 합을 구한다")
        void should_return_sum_with_default_delimiters(String input, int expected) {
            // assertEquals(3, StringCalculator.splitAndSum(input));
            assertThat(StringCalculator.splitAndSum(input)).isEqualTo(expected);
        }

        @Test
        @DisplayName("커스텀 구분자를 사용하여 합을 구한다")
        void should_return_sum_with_custom_delimiter() {
            // assertEquals(6, StringCalculator.splitAndSum("//d\n2d4"));
            assertThat(StringCalculator.splitAndSum("//d\n2d4")).isEqualTo(6);
        }
    }

    @Nested
    @DisplayName("예외 상황 검증")
    class ExceptionTest {
        @ParameterizedTest
        @ValueSource(strings = {" ", "  ", "1, ,2"}) // 단독 공백, 여러 공백, 숫자 사이 공백
        @DisplayName("공백이 입력되거나 숫자 사이에 공백이 있으면 RuntimeException이 발생한다")
        void should_throw_exception_when_input_is_blank(String input) {
            assertThatThrownBy(() -> StringCalculator.splitAndSum(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("구분자 사이에 숫자가 누락되었거나 공백입니다.");
        }
        @ParameterizedTest
        @ValueSource(strings = {"1,a,d", "//d\nfd9"})
        @DisplayName("숫자 이외의 문자가 포함되면 RuntimeException이 발생한다")
        void should_throw_exception_when_input_is_not_number(String input) {
            assertThatThrownBy(() -> StringCalculator.splitAndSum(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("숫자가 아닙니다.");
        }

        @Test
        @DisplayName("음수가 포함되면 예외 메시지와 함께 RuntimeException이 발생한다")
        void should_throw_exception_when_input_is_negative() {
            assertThatThrownBy(() -> StringCalculator.splitAndSum("-1,4:7"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("음수는 입력할 수 없습니다.");
        }

        @Test
        @DisplayName("구분자 사이에 숫자가 누락되면 예외가 발생한다")
        void should_throw_exception_when_value_is_missing() {
            assertThatThrownBy(() -> StringCalculator.splitAndSum("//d\nd9"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("구분자 사이에 숫자가 누락되었거나 공백입니다.");
        }

        @Test
        @DisplayName("전체 합계가 Long 타입의 범위를 초과하면 예외가 발생한다")
        void should_throw_exception_when_sum_exceeds_long_max_value() {
            assertThatThrownBy(() -> StringCalculator.splitAndSum("9223372036854775807,1"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("전체 합계가 정수(Long) 범위를 초과하여 계산할 수 없습니다.");
        }
    }
}