import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("문자열 계산기 테스트")
class StringCalculatorTest {

    private StringCalculator stringCalculator = new StringCalculator();

    @Nested
    @DisplayName("기본 구분자 테스트")
    class basicSeparaterTest {

        @ParameterizedTest(name = "입력값 \"{0}\"은 결과값 {1}을 반환해야 한다.")
        @CsvSource({
                "'', 0",
                "'123', 123",
                "'1,2:3', 6"
        })
        void should_return_correct_sum(String input, int expected) {
            assertThat(stringCalculator.splitStrBySeparaterAndGetSum(input)).isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("커스텀 구분자 테스트")
    class customSeparaterTest {
        @Test
        @DisplayName("커스텀 구분자로 분리한 숫자들의 합을 반환해야 한다")
        void should_sum_numbers_separated_by_custom_separator() {
            assertThat(6).isEqualTo(stringCalculator.splitStrBySeparaterAndGetSum("//;\n1;2;3"));
            assertThat(2).isEqualTo(stringCalculator.splitStrBySeparaterAndGetSum("//;\n2"));
        }
    }

    @Nested
    @DisplayName("Runtime Exception 테스트")
    class runtimeExceptionTest {
        @Test
        @DisplayName("숫자가 아닌 값이 포함되면 예외를 발생해야 한다.")
        void should_throw_exception_when_contains_non_number() {

            // 특수문자가 포함된 경우
            assertThatThrownBy(() -> stringCalculator.splitStrBySeparaterAndGetSum("//;\n1;*;3"))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessageContaining("숫자가 아닌 값이 포함되어 있습니다.");

            assertThatThrownBy(() -> stringCalculator.splitStrBySeparaterAndGetSum("//;\n1456;-;3"))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessageContaining("숫자가 아닌 값이 포함되어 있습니다.");

            // 글자가 포함된 경우
            assertThatThrownBy(() -> stringCalculator.splitStrBySeparaterAndGetSum("//;\nddd;ad;3"))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessageContaining("숫자가 아닌 값이 포함되어 있습니다.");
        }

        @Test
        @DisplayName("음수가 포함되면 예외를 발생해야 한다.")
        void should_throw_exception_when_contains_minus() {

            assertThatThrownBy(() -> stringCalculator.splitStrBySeparaterAndGetSum("-4,2:-9"))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessageContaining("음수는 사용할 수 없습니다.");
        }

        @Test
        @DisplayName("또 다른 잘못된 입력 형식의 경우 예외를 발생해야 한다.")
        void should_throw_exception_when_another_wrong_input() {

            assertThatThrownBy(() -> stringCalculator.splitStrBySeparaterAndGetSum("//;1;2;\n;"))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessageContaining("잘못된 입력 형식입니다.");

        }
    }

}