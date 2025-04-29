import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringConverterTest {

    @Test
    @DisplayName("입력된 문자열을 정상적으로 숫자로 변환한다.")
    void shouldConvertNumber_whenInputString() {
        // given
        String[] token = new String[]{"1", "2", "3"};
        StringConverter stringConverter = new StringConverter();

        // when
        List<Integer> converterNumbers = stringConverter.convertAndValidateNumbers(token);

        // then
        assertThat(List.of(1, 2, 3)).isEqualTo(converterNumbers);
    }

    @Test
    @DisplayName("숫자가 아닌 값을 입력했을 경우 예외가 발생한다.")
    void shouldThrowException_whenUn() {
        // given
        String[] token = new String[]{"1", "ab", "3"};
        StringConverter stringConverter = new StringConverter();

        // when & then
        assertThatThrownBy(() -> stringConverter.convertAndValidateNumbers(token))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("숫자가 아닌 다른 값이 입력되었습니다.");
    }

    @Test
    @DisplayName("음수를 입력했을 경우 예외가 발생한다.")
    void shouldThrowException_whenNegativeNumber() {
        // given
        String[] token = new String[]{"-1", "2", "3"};
        StringConverter stringConverter = new StringConverter();

        // when & then
        assertThatThrownBy(() -> stringConverter.convertAndValidateNumbers(token))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("양의 정수만 입력할 수 있습니다.");
    }
}
