import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("String Calculator Assert Test")
public class StringCalculatorAssertTest {

    private final StringCalculator calculator = new StringCalculator();

    @Test
    @DisplayName("빈 문자열을 입력하면 0을 반환한다.")
    void input_empty_string() {
        String input = "";

        // 인자를 비교하는 다양한 방법
        assertEquals(calculator.calculate(input), 0);
        assertThat(calculator.calculate(input)).isZero();
        assertThat(calculator.calculate(input)).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자만 입력하면 숫자를 그대로 리턴한다.")
    void input_only_numbers() {
        String input = "123";

        assertThat(calculator.calculate(input)).isEqualTo(123);
    }

    @Test
    @DisplayName("기본 구분자가 포함된 문자열을 입력하면 숫자만 분리해 합한다.")
    void input_numbers_with_basic_separator() {
        String input = "1;2,3";

        assertThat(calculator.calculate(input)).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자가 포함된 문자열을 입력하면 숫자만 분리해 합한다.")
    void input_numbers_with_custom_separator() {
        String input = "//*\n1;2,3";

        assertThat(calculator.calculate(input)).isEqualTo(6);
    }
}
