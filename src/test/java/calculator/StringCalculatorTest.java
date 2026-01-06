package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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
            int result = StringCalculator.splitAndSum(input);
            assertEquals(0, result);
        }

        @Test
        @DisplayName("숫자 하나만 입력된 경우 해당 숫자를 반환한다")
        void should_return_single_number() {
            assertEquals(1, StringCalculator.splitAndSum("1"));
        }
    }

    @Nested
    @DisplayName("구분자 분리 및 합산 검증")
    class DelimiterAndSumTest {
        @ParameterizedTest
        @ValueSource(strings = {"1,2", "1:2"})
        @DisplayName("쉼표(,) 또는 콜론(:)을 구분자로 사용하여 합을 구한다")
        void should_return_sum_with_default_delimiters(String input) {

            assertEquals(3, StringCalculator.splitAndSum(input));
        }

        @Test
        @DisplayName("커스텀 구분자를 사용하여 합을 구한다")
        void should_return_sum_with_custom_delimiter() {
            assertEquals(6, StringCalculator.splitAndSum("//d\n2d4"));
        }
    }

    @Nested
    @DisplayName("예외 상황 검증")
    class ExceptionTest {
        @ParameterizedTest
        @ValueSource(strings = {"1,a,d", "//d\nfd9"})
        @DisplayName("숫자 이외의 문자가 포함되면 RuntimeException이 발생한다")
        void should_throw_exception_when_input_is_not_number(String input) {
            RuntimeException exception = assertThrows(RuntimeException.class,
                () -> StringCalculator.splitAndSum(input));
            assertEquals("숫자가 아닙니다.", exception.getMessage());
        }

        @Test
        @DisplayName("음수가 포함되면 예외 메시지와 함께 RuntimeException이 발생한다")
        void should_throw_exception_when_input_is_negative() {
            RuntimeException exception = assertThrows(RuntimeException.class,
                () -> StringCalculator.splitAndSum("-1,4:7"));
            assertEquals("음수가 입력되었습니다.", exception.getMessage());
        }

        @Test
        @DisplayName("구분자 사이에 숫자가 누락되면 예외가 발생한다")
        void should_throw_exception_when_value_is_missing() {
            RuntimeException exception = assertThrows(RuntimeException.class,
                () -> StringCalculator.splitAndSum("//d\nd9"));
            assertEquals("구분자 사이에 숫자가 누락되었거나 공백입니다.", exception.getMessage());
        }
    }
}