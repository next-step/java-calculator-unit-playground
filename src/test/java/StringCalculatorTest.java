import domain.StringCalculator;
import exception.ErrorMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import util.DelimiterUtil;
import util.ParseUtil;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    private final StringCalculator stringCalculator = new StringCalculator();

    @ParameterizedTest
    @ValueSource(strings = {
            "1,2,3:4",
            "1 , 2: 3,4 "
    })
    public void 기본_구분자_문자열_계산기_테스트(String str) {
        int actual = stringCalculator.calculate(str);

        assertThat(actual).isEqualTo(10);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "//+\n1+2+3+4",
            "// \n1 2 3 4",
            "//||\n1||2||3||4"
    })
    public void 커스텀_구분자_문자열_계산기_테스트(String str) {
        int actual = stringCalculator.calculate(str);

        assertThat(actual).isEqualTo(10);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "//1;2;3;4",
            "\n1;2;3;4",
            "//\n1;2;3;4"
    })
    public void 커스텀_구분자_형식에_맞지_않은_경우_예외_발생(String str) {
        assertThatThrownBy(() -> stringCalculator.calculate(str))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining(ErrorMessage.CUSTOM_DELIMITER_NOT_FOUND);
    }

    @ParameterizedTest
    @NullSource
    public void 문자열이_널값인_경우_예외_발생(String str) {
        assertThatThrownBy(() -> stringCalculator.calculate(str))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining(ErrorMessage.NULL_STRING);
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "",
        " "
    })
    public void 문자열이_비어있는_경우_결과값으로_0리턴(String str) {
        int actual = stringCalculator.calculate(str);

        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void 구분자_없이_숫자만_입력한_경우() {
        String str = "1";
        int actual = stringCalculator.calculate(str);

        assertThat(actual).isEqualTo(1);
    }
}
