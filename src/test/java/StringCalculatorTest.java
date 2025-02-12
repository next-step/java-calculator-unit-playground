import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorTest {

    private final StringCalculator stringCalculator = new StringCalculator();

    @Nested
    @DisplayName("입력된 문자열 합 계산")
    class addTest {

        @Test
        @DisplayName("쉼표와 콜론을 구분자로 가지는 문자열의 합을 반환한다.")
        void shouldReturnSumOfString() {
            final String expression = "1,2:3";
            assertThat(6).isEqualTo(stringCalculator.add(expression));
        }

        @Test
        @DisplayName("숫자 한 개만 입력된 경우 해당 숫자를 반환한다.")
        void shouldReturnSumOfChar() {
            final String expression = "1";
            assertThat(1).isEqualTo(stringCalculator.add(expression));
        }
    }

    @Nested
    @DisplayName("커스텀 구분자를 포함한 문자열 합 계산")
    class CustomDelimiterTest {

        @Test
        @DisplayName("커스텀 구분자를 사용한 문자열의 합을 반환한다.")
        void shouldReturnSumWithCustomDelimiterOfString() {
            final String expression = "1//;\n2,3:4";
            assertThat(stringCalculator.add(expression)).isEqualTo(10);
        }

        @Test
        @DisplayName("커스텀 구분자와 기본 구분자를 함께 사용한 문자열의 합을 반환한다.")
        void shouldReturnSumWithCustomDelimiterAndDefaultDelimiterOfString() {
            final String expression = "1//***\n2,3***4";
            assertThat(stringCalculator.add(expression)).isEqualTo(10);
        }

        @Test
        @DisplayName("커스텀 구분자가 여러 개 문자를 포함할 때 문자열의 합을 반환한다.")
        void shouldReturnSumWithCustomDelimitersOfString() {
            final String expression = "1//**\n2**3**4";
            assertThat(stringCalculator.add(expression)).isEqualTo(10);
        }
    }

    @Nested
    @DisplayName("예외 발생")
    class ExceptionTest {

        @Test
        @DisplayName("숫자가 아닌 문자열이 입력 되었을 때 RuntimeException이 발생한다.")
        void shouldReturnRuntimeExceptionToNumberFormatException() {
            final String expression = "example";
            assertThatThrownBy(() -> stringCalculator.add(expression)).isInstanceOf(RuntimeException.class);
        }

        @Test
        @DisplayName("빈 문자열이 입력된 경우 0을 반환한다.")
        void shouldReturnZeroWhenEmptyStringIsEntered() {
            final String expression = "";
            assertThat(stringCalculator.add(expression)).isEqualTo(0);
        }

        @Test
        @DisplayName("구분자만 입력된 경우 RuntimeException이 발생한다.")
        void shouldThrowRuntimeExceptionWhenOnlyDelimitersAreEntered() {
            final String expression = ",,,";
            assertThatThrownBy(() -> stringCalculator.add(expression)).isInstanceOf(RuntimeException.class);
        }

        @Test
        @DisplayName("커스텀 구분자 사이에 공백이 포함된 경우 RuntimeException이 발생한다.")
        void shouldThrowRuntimeExceptionWhenSpaceExistsBetweenCustomDelimiters() {
            final String expression = "1//;\n2; 3;4";
            assertThatThrownBy(() -> stringCalculator.add(expression)).isInstanceOf(RuntimeException.class);
        }

        @Test
        @DisplayName("커스텀 구분자를 잘못된 방식으로 입력한 경우 RuntimeException이 발생한다.")
        void shouldThrowRuntimeExceptionWhenInvalidCustomDelimiterFormatIsUsed() {
            final String expression = "//;\n1;2;3;";
            assertThatThrownBy(() -> stringCalculator.add(expression)).isInstanceOf(RuntimeException.class);
        }

    }
}
