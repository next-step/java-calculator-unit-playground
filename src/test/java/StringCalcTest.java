
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

@DisplayName("문자열 계산기 테스트")
class StringCalcTest {
    private final StringCalc stringCalc = new StringCalc();

    @Test
    @DisplayName("쉼표 구분자 문자열 계산 테스트")
    void addWithComma() {
        final var input = "1,2,3";
        final var actual = stringCalc.add(input);
        
        assertThat(actual).isEqualTo(6);
    }

    @Test
    @DisplayName("콜론 구분자 문자열 계산 테스트")
    void addWithColon() {
        final var input = "1:2:3";
        final var actual = stringCalc.add(input);
        
        assertThat(actual).isEqualTo(6);
    }

    @Test
    @DisplayName("쉼표와 콜론 혼합 구분자 테스트")
    void addWithMixedDelimiters() {
        final var input = "1,2:3";
        final var actual = stringCalc.add(input);
        
        assertThat(actual).isEqualTo(6);
    }

    @Test
    @DisplayName("빈 문자열 테스트")
    void addEmptyString() {
        final var input = "";
        final var actual = stringCalc.add(input);
        
        assertThat(actual).isEqualTo(0);
    }

    @Test
    @DisplayName("null 입력 테스트")
    void addNullInput() {
        final String input = null;
        final var actual = stringCalc.add(input);
        
        assertThat(actual).isEqualTo(0);
    }

    @Test
    @DisplayName("커스텀 구분자 테스트")
    void addWithCustomDelimiter() {
        final var input = "//;\n1;2;3";
        final var actual = stringCalc.add(input);
        
        assertThat(actual).isEqualTo(6);
    }

    @Test
    @DisplayName("음수 입력 예외 테스트")
    void addNegativeNumberThrowsException() {
        final var input = "1,-2,3";
        
        assertThatThrownBy(() -> stringCalc.add(input))
            .isInstanceOf(RuntimeException.class)
            .hasMessage("음수는 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("숫자가 아닌 값 입력 예외 테스트")
    void addNonNumericValueThrowsException() {
        final var input = "1,a,3";
        
        assertThatThrownBy(() -> stringCalc.add(input))
            .isInstanceOf(RuntimeException.class)
            .hasMessage("숫자 이외의 값이 포함되어 있습니다.");
    }
}