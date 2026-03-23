package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


class StringCalculatorTest {

    @Test
    @DisplayName("구분자를 기준으로 분리한 각 숫자의 합을 얻을 수 있다.")
    void customDelimiter() {
        // given
        StringCalculator stringCalculator = new StringCalculator();
        int expected = 6;

        // when
        String[] parsed = stringCalculator.parser("//;\n1;2;3");
        String[] tokens = stringCalculator.validator(parsed);
        int actual = stringCalculator.add(tokens);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("음수가 입력되었을 때 런타임 에러를 확인할 수 있다.")
    void negativeNumber() {
        // given
        StringCalculator stringCalculator = new StringCalculator();

        // when
        String[] parsed = stringCalculator.parser("//;\n1;-2;3");
        String[] tokens = stringCalculator.validator(parsed);
        int actual = stringCalculator.add(tokens);

        // then
        assertThat(actual).isEqualTo(6);
    }

    @Test
    @DisplayName("숫자가 아닌 문자가 입력되었을 때 런타임 에러를 확인할 수 있다.")
    void specialChar() {
        // given
        StringCalculator stringCalculator = new StringCalculator();

        // when
        String[] parsed = stringCalculator.parser("//;\n1;?2;3");
        String[] tokens = stringCalculator.validator(parsed);
        int actual = stringCalculator.add(tokens);

        // then
        assertThat(actual).isEqualTo(6);
    }
}