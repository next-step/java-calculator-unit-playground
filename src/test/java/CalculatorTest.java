import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력 문자열이 없을 경우 0을 반환한다.")
    void shouldReturnZero_whenNothingInputValue(String input) {
        // given & when
        int actual = calculator.sum(input);

        //then
        assertThat(actual).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1:2,3", "1,2,3", "//;\\n1;2;3"})
    @DisplayName("입력한 문자열에 대해 올바른 덧셈 결과를 반환한다.")
    void shouldReturnSum_whenInputString(String input) {
        // given & when
        int actual = calculator.sum(input);

        // then
        int expected = 6;
        assertThat(actual).isEqualTo(expected);
    }
}
