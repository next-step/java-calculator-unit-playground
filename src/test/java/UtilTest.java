import exception.ErrorMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import util.DelimiterUtil;
import util.ParseUtil;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UtilTest {
    @ParameterizedTest
    @CsvSource({
        "'//+\n', '+'",
        "'// \n', ' '",
        "'//||\n', '||'"
    })
    public void 커스텀_구분자_파싱_테스트(String str, String expected) {
        String customDelimiter = DelimiterUtil.findCustomDelimiter(str);

        assertThat(customDelimiter).isEqualTo(expected);
    }

    @Test
    public void 문자열_리스트_정수_리스트로_변환() {
        String[] tokens = {"1", "2", "3", "4"};

        List<Integer> actual = ParseUtil.parseNumber(tokens);

        assertThat(actual).containsExactly(1, 2, 3, 4);
    }

    @Test
    public void 문자열_리스트_정수_리스트로_변환_음수가_포함되면_예외_발생() {
        String[] tokens = {"1", "2", "-3", "4"};

        assertThatThrownBy(() -> ParseUtil.parseNumber(tokens))
            .isInstanceOf(RuntimeException.class)
            .hasMessageContaining(ErrorMessage.NEGATIVE_NUMBER_NOT_ALLOWED);
    }

    @Test
    public void 문자열_리스트_정수_리스트로_변환_문자가_포함되면_예외_발생() {
        String[] tokens = {"a1", "b", " ", "4"};

        assertThatThrownBy(() -> ParseUtil.parseNumber(tokens))
            .isInstanceOf(RuntimeException.class)
            .hasMessageContaining(ErrorMessage.INVALID_STRING);
    }
}
