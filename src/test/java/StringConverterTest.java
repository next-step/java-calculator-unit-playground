import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringConverterTest {

    private final StringConverter stringConverter = new StringConverter();

    @Test
    @DisplayName("입력된 문자열을 정상적으로 숫자로 변환한다.")
    void shouldConvertNumber_whenInputString() {
        // given
        List<String> token = List.of("1", "2", "3");

        // when
        List<Integer> numbers = stringConverter.convertAndValidateNumbers(token);

        // then
        assertThat(numbers).isEqualTo(List.of("1", "2", "3"));
    }

    @Test
    @DisplayName("숫자가 아닌 값을 입력했을 경우 예외가 발생한다.")
    void shouldThrowException_whenUn() {
        // given
        List<String> token = List.of("1", "ab", "3");

        // when & then
        assertThatThrownBy(() -> stringConverter.convertAndValidateNumbers(token))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아닌 다른 값이 입력되었습니다.");
    }

    @Test
    @DisplayName("음수를 입력했을 경우 예외가 발생한다.")
    void shouldThrowException_whenNegativeNumber() {
        // given
        List<String> token = List.of("-1", "2", "3");

        // when & then
        assertThatThrownBy(() -> stringConverter.convertAndValidateNumbers(token))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("양의 정수만 입력할 수 있습니다.");
    }
}
