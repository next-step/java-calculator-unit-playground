import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringCalculatorAssertJTest {

    private final StringCalculator cal = new StringCalculator();

    @Test
    @DisplayName("빈 문자열을 입력하면 0을 출력한다")
    void emptyInput() {
        assertThat(cal.run("")).isEqualTo(0);
    }

    @Test
    @DisplayName("음수 또는 문자는 예외가 발생한다")
    void invalidInput() {
        assertThatThrownBy(() -> cal.run("-1")).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> cal.run("a,b")).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2:3", "1,2,3", "1:2:3", "6"})
    @DisplayName("기본 구분자를 사용한 합 계산")
    void basicDelimiter(String value) {
        assertThat(cal.run(value)).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//,\n1,2,,3", "//\\\n1\\2\\3", "// \n  1  2 3"})
    @DisplayName("커스텀 구분자를 사용한 합 계산")
    void customDelimiter(String value) {
        assertThat(cal.run(value)).isEqualTo(6);
    }
}
