import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @Test
    @DisplayName("입력값이 비어있는 경우 테스트")
    void testEmptyStringReturnsZero() {
        assertThat(StringCalculator.add(""))
                .isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("단일 숫자 입력 테스트")
    @CsvSource({
            "1, 1",
            "5, 5",
            "10, 10"
    })
    void testSingleNumber(String input, int expected) {
        assertThat(StringCalculator.add(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("콤마로 구분한 숫자 합산 기능")
    void testTwoNumbersWithComma() {
        assertThat(StringCalculator.add("1,2")).isEqualTo(3);
    }

    @Test
    @DisplayName("콤마와 콜론으로 구분한 숫자 합산 기능")
    void testMultipleNumbersWithCommaAndColon() {
        assertThat(StringCalculator.add("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자를 사용한 숫자 합산 기능")
    void testCustomDelimiter() {
        assertThat(StringCalculator.add("//;\n1;2;3")).isEqualTo(6);
        assertThat(StringCalculator.add("//|\n2|3|5")).isEqualTo(10);
        assertThat(StringCalculator.add("//|\n2,3|50")).isEqualTo(55);
    }

    @ParameterizedTest
    @DisplayName("특수문자가 포함된 커스텀 구분자를 사용한 숫자 합산 기능")
    @CsvSource({
            "'//.\n2.3.5', 10",
            "'//$\n1$2$3', 6"
    })
    void testCustomDelimiterWithSpecialCharacters(String input, int expected) {
        assertThat(StringCalculator.add(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("입력값 중 음수가 존재하는 경우 예외 발생")
    void testNegativeNumbersThrowException() {
        String input = "1,-2,3";
        String expectedMessage = "입력한 값 중 음수 값이 존재합니다: -2";

        assertThatThrownBy(() -> StringCalculator.add(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(expectedMessage); // 예외 메시지가 정확히 일치하는지 검증
    }

    @Test
    @DisplayName("입력값이 숫자가 아닌 값이 존재하는 경우 예외 발생")
    void testNonNumericValuesThrowException() {
        assertThatThrownBy(() -> StringCalculator.add("1,a,3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Invalid input: 숫자가 아닌 값이 포함되었습니다.");

        assertThatThrownBy(() -> StringCalculator.add("//;\n1;B;3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Invalid input: 숫자가 아닌 값이 포함되었습니다.");
    }
}
