import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력 문자열이 없을 경우 0을 반환한다.")
    void shouldReturnZero_whenNothingInputValue(String input) {
        // given
        Calculator calculator = new Calculator();

        // when
        int expected = calculator.sum(input);

        //then
        assertEquals(expected, 0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1:2,3", "1,2,3"})
    @DisplayName("입력한 문자열에 대해 올바른 덧셈 결과를 반환한다.")
    void shouldReturnSum_whenInputString(String input) {
        // given
        Calculator calculator = new Calculator();

        // when
        int expected = calculator.sum(input);

        // then
        int actual = 6;
        assertEquals(expected, actual);
    }
}
