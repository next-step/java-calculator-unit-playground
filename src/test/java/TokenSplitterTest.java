import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TokenSplitterTest {

    @ParameterizedTest
    @ValueSource(strings = {"1:2:3", "1,2:3"})
    @DisplayName("기본 구분자를 사용한 문자열을 입력했을 경우 정상적으로 나눈다.")
    void shouldRemove_whenBasicInput(String value) {
        // given
        TokenSplitter tokenSplitter = new TokenSplitter();

        // when
        String[] token = tokenSplitter.getToken(value);

        // then
        assertEquals(Arrays.toString(token), "[1, 2, 3]");
    }
}
