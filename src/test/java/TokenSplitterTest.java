import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TokenSplitterTest {

    @ParameterizedTest
    @ValueSource(strings = {"1:2:3", "1,2:3"})
    @DisplayName("기본 구분자를 사용한 문자열을 입력했을 경우 정상적으로 나누어진다.")
    void shouldRemove_whenBasicInput(String value) {
        // given
        TokenSplitter tokenSplitter = new TokenSplitter();

        // when
        String[] token = tokenSplitter.getToken(value);

        // then
        assertEquals(Arrays.toString(token), "[1, 2, 3]");
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\\n1;2;3"})
    @DisplayName("커스텀 구분자를 사용한 문자열을 입력했을 경우 정상적으로 나누어진다.")
    void shouldRemove_whenCustomInput(String customValue) {
        // given
        TokenSplitter tokenSplitter = new TokenSplitter();

        // when
        String[] token = tokenSplitter.getToken(customValue);

        // then
        assertEquals(Arrays.toString(token), "[1, 2, 3]");
    }

    @Test
    @DisplayName("커스텀 구분자 형식을 지키지 않았을 경우 예외가 발생한다.")
    void shouldThrowException_whenInvalidCustomFormat() {
        // given
        String input = "//;1;2;3";
        TokenSplitter tokenSplitter = new TokenSplitter();

        // when
        RuntimeException e = assertThrows(RuntimeException.class,
                () -> tokenSplitter.getToken(input)
        );

        // then
        assertEquals(e.getMessage(), "커스텀 구분자 형식이 올바르지 않습니다.");
    }
}
