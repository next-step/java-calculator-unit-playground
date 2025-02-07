import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("문자열 계산기 테스트")
class StringCalculatorTest {

    StringCalculator stringCalculator = new StringCalculator();

    @Nested
    @DisplayName("기본 구분자 테스트")
    class basicSeparaterTest {
        @Test
        @DisplayName("빈 문자열이면 0을 반환해야 한다.")
        void should_return_0_when_string_is_empty() {
            assertThat(0).isEqualTo(stringCalculator.getSum(""));
        }
        @Test
        @DisplayName("구분자가 없는 경우 0을 반환해야 한다.")
        void test() {
            assertThat(0).isEqualTo(stringCalculator.getSum("123"));
        }
        @Test
        @DisplayName("쉼표(,) 또는 콜론(:)으로 구분된 숫자들의 합을 반환해야 한다.")
        void should_sum_numbers_separated_by_comma_or_colon() {
            assertThat(6).isEqualTo(stringCalculator.getSum("1,2:3"));
        }
    }

    @Nested
    @DisplayName("커스텀 구분자 테스트")
    class customSeparaterTest {
        @Test
        @DisplayName("커스텀 구분자로 분리한 숫자들의 합을 반환해야 한다")
        void should_sum_numbers_separated_by_custom_separator() {
            assertThat(6).isEqualTo(stringCalculator.getSum("//;\n1;2;3"));
        }
    }

    @Nested
    @DisplayName("Runtime Exception 테스트")
    class runtimeExceptionTest {
        @Test
        @DisplayName("숫자가 아닌 값이 포함되면 예외를 발생해야 한다.")
        void should_throw_exception_when_contains_non_number() {

            assertThatThrownBy(() -> stringCalculator.getSum("//;\n1;*;3"))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessageContaining("숫자가 아닌 값이 포함되어 있습니다.");

            assertThatThrownBy(() -> stringCalculator.getSum("//;\n1456;-;3"))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessageContaining("숫자가 아닌 값이 포함되어 있습니다.");
        }

        @Test
        @DisplayName("음수가 포함되면 예외를 발생해야 한다.")
        void should_throw_exception_when_contains_minus() {

            assertThatThrownBy(() -> stringCalculator.getSum("-4,2:-9"))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessageContaining("음수는 사용할 수 없습니다.");
        }

        @Test
        @DisplayName("또 다른 잘못된 입력 형식의 경우 예외를 발생해야 한다.")
        void should_throw_exception_when_another_wrong_input() {

            assertThatThrownBy(() -> stringCalculator.getSum("//;1;2;\n;"))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessageContaining("잘못된 입력 형식입니다.");

            assertThatThrownBy(() -> stringCalculator.getSum("//;1;2;\n123"))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessageContaining("잘못된 입력 형식입니다.");

        }
    }

}