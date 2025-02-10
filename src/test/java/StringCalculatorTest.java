import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {

    private final StringCalculator stringCalculator = new StringCalculator();

    @Nested
    class AddTest {

        @Test
        @DisplayName("0을 입력시 0을 반환한다.")
        void addZero() {
            assertThat(stringCalculator.add("0")).isEqualTo(0);
        }

        @Test
        @DisplayName("빈 문자열을 입력시 0을 반환한다.")
        void addEmpty() {
            assertThat(stringCalculator.add("")).isEqualTo(0);
        }

        @Test
        @DisplayName("숫자 하나를 입력하면 하나를 반환한다.")
        void addOne() {
            assertThat(stringCalculator.add("1")).isEqualTo(1);
        }

        @ParameterizedTest
        @CsvSource({"'1,2', 3, 4", "'1:2:3', 6, 8", "'1,2:3', 6, 8"})
        @DisplayName("기본 구분자 쉼표(,) 혹은 콜론(:) 을 사용하여 테스트한다.")
        void addDefault(String input, int expected, int unexpected) {
            int result = stringCalculator.add(input);
            assertThat(result).isEqualTo(expected);
            assertThat(result).isNotEqualTo(unexpected);
        }

        @Test
        @DisplayName("커스텀 구분자를 입력하여 테스트한다.")
        void addCustom() {
            assertThat(stringCalculator.add("//;\n1;2;3")).isEqualTo(6);
            assertThat(stringCalculator.add("//|\n1|2|3")).isEqualTo(6);
        }

    }

    @Nested
    class ExceptionTest {
        @Test
        @DisplayName("숫자 이외의 값을 입력하면 예외가 발생한다.")
        void addException1() {
            assertThatThrownBy(() -> stringCalculator.add("#,3,4"))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessage("숫자가 아닌 값이 입력되었습니다: #");

            assertThatThrownBy(() -> stringCalculator.add("//^\n3^%^*"))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessage("숫자가 아닌 값이 입력되었습니다: %");
        }

        @Test
        @DisplayName("음수를 입력하면 예외가 발생한다.")
        void addException2() {
            assertThatThrownBy(() -> stringCalculator.add("-1,-2,-3"))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessage("음수가 입력되었습니다: -1");

            assertThatThrownBy(() -> stringCalculator.add("-3,2:2"))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessage("음수가 입력되었습니다: -3");

            assertThatThrownBy(() -> stringCalculator.add("//&\n-1&-2&3"))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessage("음수가 입력되었습니다: -1");
        }

        @Test
        @DisplayName("커스텀 구분자에서 '\\n'을 입력하지 않으면 예외를 발생한다. ")
        void addException3() {
            assertThatThrownBy(() -> stringCalculator.add("//;1;2;3"))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessageContaining("'\\n'을 입력해주세요.");
        }

        @Test
        @DisplayName("커스텀 구분자에서 숫자를 입력하지 않으면 예외를 발생한다.")
        void addException4() {
            assertThatThrownBy(() -> stringCalculator.add("//;\n"))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessageContaining("숫자를 입력해주세요.");
        }
    }
}
