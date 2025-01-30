import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("문자열 계산기 단위 테스트")
public class StringCalculatorUnitTest {

    private final StringCalculator stringCalculator = new StringCalculator(new Calculator());

    @Nested
    @DisplayName("JUnit5 테스트")
    class JUnit5Test {

        @Test
        @DisplayName("Positive - 기본 구분자(쉼표)로 숫자 덧셈")
        void addWithCommaDelimiter() {
            assertEquals(6, stringCalculator.add("1,2,3"));
        }

        @Test
        @DisplayName("Positive - 기본 구분자(콜론)로 숫자 덧셈")
        void addWithColonDelimiter() {
            assertEquals(10, stringCalculator.add("2:3:5"));
        }

        @Test
        @DisplayName("Positive - 기본 구분자(쉼표 & 콜론)로 숫자 덧셈")
        void addWithMixedDelimiters() {
            assertEquals(15, stringCalculator.add("2,3:5,5"));
        }

        @Test
        @DisplayName("Positive - 커스텀 구분자(세미콜론)로 숫자 덧셈")
        void addWithCustomDelimiter() {
            assertEquals(6, stringCalculator.add("//;\n1;2;3"));
        }

        @Test
        @DisplayName("Positive - 단일 숫자")
        void addWithSingleNumber() {
            assertEquals(5, stringCalculator.add("5"));
        }

        @Test
        @DisplayName("Negative - 빈 문자열 입력 시 예외 발생")
        void addWithEmptyString() {
            assertThrows(RuntimeException.class, () -> stringCalculator.add(""));
        }

        @Test
        @DisplayName("Negative - 음수 입력 시 예외 발생")
        void addWithNegativeNumbers() {
            assertThrows(RuntimeException.class, () -> stringCalculator.add("1,-2,3"));
        }

        @Test
        @DisplayName("Negative - 잘못된 형식의 커스텀 구분자 입력 시 예외 발생")
        void addWithInvalidCustomDelimiterFormat() {
            assertThrows(RuntimeException.class, () -> stringCalculator.add("//;\n"));
        }

        @Test
        @DisplayName("Negative - 숫자가 아닌 입력값이 포함될 경우 예외 발생")
        void addWithInvalidCharacters() {
            assertThrows(RuntimeException.class, () -> stringCalculator.add("1,a,3"));
        }
    }

    @Nested
    @DisplayName("AssertJ 테스트")
    class AssertJTest {

        @Test
        @DisplayName("Positive - 기본 구분자(쉼표)로 숫자 덧셈")
        void addWithCommaDelimiter() {
            assertThat(stringCalculator.add("1,2,3")).isEqualTo(6);
        }

        @Test
        @DisplayName("Positive - 기본 구분자(콜론)로 숫자 덧셈")
        void addWithColonDelimiter() {
            assertThat(stringCalculator.add("2:3:5")).isEqualTo(10);
        }

        @Test
        @DisplayName("Positive - 기본 구분자(쉼표 & 콜론)로 숫자 덧셈")
        void addWithMixedDelimiters() {
            assertThat(stringCalculator.add("2,3:5,5")).isEqualTo(15);
        }

        @Test
        @DisplayName("Positive - 커스텀 구분자(세미콜론)로 숫자 덧셈")
        void addWithCustomDelimiter() {
            assertThat(stringCalculator.add("//;\n1;2;3")).isEqualTo(6);
        }

        @Test
        @DisplayName("Positive - 단일 숫자")
        void addWithSingleNumber() {
            assertThat(stringCalculator.add("5")).isEqualTo(5);
        }

        @Test
        @DisplayName("Negative - 빈 문자열 입력 시 예외 발생")
        void addWithEmptyString() {
            assertThatThrownBy(() -> stringCalculator.add(""))
                .isInstanceOf(RuntimeException.class);
        }

        @Test
        @DisplayName("Negative - 음수 입력 시 예외 발생")
        void addWithNegativeNumbers() {
            assertThatThrownBy(() -> stringCalculator.add("1,-2,3"))
                .isInstanceOf(RuntimeException.class);
        }

        @Test
        @DisplayName("Negative - 잘못된 형식의 커스텀 구분자 입력 시 예외 발생")
        void addWithInvalidCustomDelimiterFormat() {
            assertThatThrownBy(() -> stringCalculator.add("//;\n"))
                .isInstanceOf(RuntimeException.class);
        }

        @Test
        @DisplayName("Negative - 숫자가 아닌 입력값이 포함될 경우 예외 발생")
        void addWithInvalidCharacters() {
            assertThatThrownBy(() -> stringCalculator.add("1,a,3"))
                .isInstanceOf(RuntimeException.class);
        }
    }
}
