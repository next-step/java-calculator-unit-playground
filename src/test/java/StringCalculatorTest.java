import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class StringCalculatorTest {

    private final StringCalculator stringCalculator = new StringCalculator(new Calculator());

    @Nested
    @DisplayName("기본 동작 테스트")
    class DefaultBehavior {

        @Test
        @DisplayName("값이 비어 있으면 0을 반환한다.")
        void addWithEmptyOrNull() {
            assertThat(0).isEqualTo(stringCalculator.add(""));
            assertThat(0).isEqualTo(stringCalculator.add(null));
        }

        @Test
        @DisplayName("숫자 하나만 입력 시 해당 숫자를 반환한다.")
        void addWithSingleNumber() {
            assertThat(1).isEqualTo(stringCalculator.add("1"));
        }
    }

    @Nested
    @DisplayName("기본 구분자 ','와 ':'의 테스트")
    class DefaultDelimiters {

        @Test
        @DisplayName("쉼표(,)를 기본 구분자로 사용하여 숫자를 더한다.")
        void addWithComma() {
            assertThat(3).isEqualTo(stringCalculator.add("1,2"));
        }

        @Test
        @DisplayName("콜론(:)을 기본 구분자로 사용하여 숫자를 더한다.")
        void addWithColon() {
            assertThat(3).isEqualTo(stringCalculator.add("1:2"));
        }

        @Test
        @DisplayName("쉼표(,)와 콜론(:)을 함께 기본 구분자로 사용하여 숫자를 더한다.")
        void addWithCommaAndColon() {
            assertThat(6).isEqualTo(stringCalculator.add("1,2:3"));
        }
    }

    @Nested
    @DisplayName("커스텀 구분자 테스트")
    class CustomDelimiter {

        @Test
        @DisplayName("커스텀 구분자 '~'를 사용하여 숫자를 더한다.")
        void addWithCustomTilde() {
            assertThat(6).isEqualTo(stringCalculator.add("//~\n1~2~3"));
        }

        @Test
        @DisplayName("커스텀 구분자 ';'를 사용하여 숫자를 더한다.")
        void addWithCustomSemicolon() {
            assertThat(6).isEqualTo(stringCalculator.add("//;\n1;2;3"));
        }
    }

    @Nested
    @DisplayName("예외 발생 테스트")
    class ExceptionCases {

        @Test
        @DisplayName("기본 구분자 ':' 사용 시 음수를 입력하면 예외가 발생한다.")
        void addNegativeWithDefaultDelimiter() {
            assertThatThrownBy(() -> stringCalculator.add("-1:2"))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessageContaining("음수가 전달되었습니다.");
        }

        @Test
        @DisplayName("커스텀 구분자 사용 시 음수를 입력하면 예외가 발생한다.")
        void addNegativeWithCustomDelimiter() {
            assertThatThrownBy(() -> stringCalculator.add("//;\n-1;2;3"))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessageContaining("음수가 전달되었습니다.");
        }

        @Test
        @DisplayName("공백이 포함된 숫자가 입력되면 예외가 발생한다.")
        void throwExceptionForNumbersWithSpaces() {
            assertThatThrownBy(() -> stringCalculator.add(" 1,2"))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessageContaining("숫자 이외의 다른 값이 전달되었습니다.");
        }

        @Test
        @DisplayName("기본 구분자 사용 시 숫자가 아닌 값이 입력되면 예외가 발생한다.")
        void addNonNumericWithDefaultDelimiter() {
            assertThatThrownBy(() -> stringCalculator.add("1,a,3"))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessageContaining("숫자 이외의 다른 값이 전달되었습니다.");
        }

        @Test
        @DisplayName("커스텀 구분자 사용 시 숫자가 아닌 값이 입력되면 예외가 발생한다.")
        void addNonNumericWithCustomDelimiter() {
            assertThatThrownBy(() -> stringCalculator.add("//;\n1;b;3"))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessageContaining("숫자 이외의 다른 값이 전달되었습니다.");
        }

        @Test
        @DisplayName("커스텀 구분자와 기본 구분자 혼합 사용 시 예외가 발생한다.")
        void shouldThrowExceptionForMixedDelimiters() {
            assertThatThrownBy(() -> stringCalculator.add("//;\n1,2;3"))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessageContaining("숫자 이외의 다른 값이 전달되었습니다.");
        }

        @Test
        @DisplayName("커스텀 구분자 사용 시 공백이 들어오면 예외가 발생한다.")
        void shouldThrowExceptionForWhitespaceInCustomDelimiter() {
            assertThatThrownBy(() -> stringCalculator.add("// \n 1 2 3"))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessage("숫자 이외의 다른 값이 전달되었습니다.");
        }


        @Test
        @DisplayName("잘못된 형식의 커스텀 구분자 사용 시 커스텀 구분자 형식 예외가 발생한다.")
        void shouldThrowExceptionForInvalidCustomDelimiterFormat() {
            assertThatThrownBy(() -> stringCalculator.add("//@\n//#\n1@2#3"))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessage("커스텀 구분자 형식이 잘못되었습니다.");
        }
    }
}
