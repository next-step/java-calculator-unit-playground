import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringCalculatorTestWithAssertJ {

    @ParameterizedTest
    @ValueSource(strings = {",", ":"})
    @DisplayName("쉼표 또는 콜론만 넣었을 때 0을 반환한다")
    void onlyInsertCommaOrColon(String value) {
        final int expected = 0;
        final int actual = new StringCalculator(value).calculate();

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1aa2", "1:3aa5"})
    @DisplayName("지정된 구분자로 들어오지 않는 경우")
    void unsupportedDelimiter(String value) {
        assertThatThrownBy(() -> new StringCalculator(value).calculate())
            .hasMessage("유효하지 않은 포맷입니다")
            .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @MethodSource("methodSourcesStringAndIntegerTestArguments")
    @DisplayName("쉼표 또는 콜론을 구분자로 해서 정상적인 값을 넣으면 합계가 구해진다.")
    void insertValue(String value, int expected) {
        final int actual = new StringCalculator(value).calculate();
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> methodSourcesStringAndIntegerTestArguments() {
        return Stream.of(
            Arguments.arguments("1", 1),
            Arguments.arguments("1,2", 3),
            Arguments.arguments("1,2,3", 6),
            Arguments.arguments("1,2:3", 6)
        );
    }

    @ParameterizedTest
    @MethodSource("methodSourcesStringAndIntegerForCustomDelimiter")
    @DisplayName("커스텀 구분자 생성하기")
    void customDelimiter(String value, int expected) {
        final int actual = new StringCalculator(value).calculate();
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> methodSourcesStringAndIntegerForCustomDelimiter() {
        return Stream.of(
            Arguments.arguments("//;\n1;2;3", 6),
            Arguments.arguments("//aaaaaa\n1aaaaaa2aaaaaa3", 6),
            Arguments.arguments("//석주\n1석주2석주3", 6),
            Arguments.arguments("//석주next\n1석주next2석주next3", 6),
            Arguments.arguments("//석주next\n1석주next2석주next3", 6)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,a", "1,가,-3", "//석주\n1석주a석주-3"})
    @DisplayName("숫자 이외의 값을 전달하는 경우 RuntimeException throw")
    void insertNotNumber(String value) {
        assertThrows(RuntimeException.class, () -> new StringCalculator(value).calculate());
        assertThatThrownBy(() -> new StringCalculator(value).calculate())
            .hasMessage("문자열은 들어올 수 없습니다")
            .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,-3", "1,-5,-3", "//석주\n1석주2석주-3"})
    @DisplayName("음수를 전달하는 경우 RuntimeException throw")
    void insertNegativeNumber(String value) {
        assertThatThrownBy(() -> new StringCalculator(value).calculate())
            .hasMessage("음수는 들어올 수 없습니다")
            .isInstanceOf(RuntimeException.class);
    }
}
