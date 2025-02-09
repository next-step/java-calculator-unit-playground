import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @Test
    @DisplayName("입력값이 비어있는 경우 테스트")
    void testEmptyStringReturnsZero() {
        assertThat(StringCalculator.add(""))
                .isEqualTo(0);
    }

    @Test
    @DisplayName("단일 숫자 출력 기능")
    void testSingleNumber() {
        assertThat(StringCalculator.add("1")).isEqualTo(1);
        assertThat(StringCalculator.add("5")).isEqualTo(5);
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

    @Test
    @DisplayName("특수문자가 포함된 커스텀 구분자를 사용한 숫자 합산 기능")
    void testCustomDelimiterWithSpecialCharacters() {
        assertThat(StringCalculator.add("//.\n2.3.5")).isEqualTo(10);
        assertThat(StringCalculator.add("//$\n1$2$3")).isEqualTo(6);
    }

    @Test
    @DisplayName("입력값 중 음수가 존재하는 경우를 식별하는 기능")
    void testNegativeNumbersThrowException() {
        assertThatThrownBy(() -> StringCalculator.add("1,-2,3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("입력한 값 중 음수 값이 존재합니다.");
    }

    @Test
    @DisplayName("입력값이 숫자가 아닌 값이 존재하는 경우를 식별하는 기능")
    void testNonNumericValuesThrowException() {
        assertThatThrownBy(() -> StringCalculator.add("1,a,3"))
                .isInstanceOf(RuntimeException.class);

        assertThatThrownBy(() -> StringCalculator.add("//;\n1;B;3"))
                .isInstanceOf(RuntimeException.class);
    }
}
