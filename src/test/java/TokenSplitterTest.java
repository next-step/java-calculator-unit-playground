import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TokenSplitterTest {

    private final TokenSplitter tokenSplitter = new TokenSplitter();

    @ParameterizedTest
    @ValueSource(strings = {"1:2:3", "1,2:3"})
    @DisplayName("기본 구분자를 사용한 문자열을 입력했을 경우 정상적으로 나누어진다.")
    void shouldRemove_whenBasicInput(String value) {
        // given & when
        List<String> token = tokenSplitter.tokenize(value);

        // then
        assertThat(token).isEqualTo(List.of("1", "2", "3"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\\n1;2;3"})
    @DisplayName("커스텀 구분자를 사용한 문자열을 입력했을 경우 정상적으로 나누어진다.")
    void shouldRemove_whenCustomInput(String customValue) {
        // given & when
        List<String> token = tokenSplitter.tokenize(customValue);

        // then
        assertThat(token).isEqualTo(List.of("1", "2", "3"));
    }

    @Test
    @DisplayName("커스텀 구분자 형식을 지키지 않았을 경우 예외가 발생한다.")
    void shouldThrowException_whenInvalidCustomFormat() {
        // given
        String input = "//;1;2;3";

        // when & then
        assertThatThrownBy(() -> tokenSplitter.tokenize(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("커스텀 구분자 형식이 올바르지 않습니다.");
    }
}
