import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


@DisplayName("문자열 계산기 테스트")
public class StringCalculatorTest {

    StringCalculator stringCalculator = new StringCalculator();

    @Test
    @DisplayName("입력된 것이 아무것도 없을 때 0 반환하는지 테스트")
    public void nullTest() {

        // given
        String input = "";

        // when
        int actual = stringCalculator.calculate(input);

        // then
        int expected = 0;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    @DisplayName("기본 구분자 입력 시 제대로 결과값 반환되는지 테스트")
    public void basicDelimiterTest() {

        // given
        String input = "1,145:3";

        // when
        int actual = stringCalculator.calculate(input);

        // then
        int expected = 149;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    @DisplayName("커스텀 구분자 입력 시 제대로 결과값 반환하는지 테스트")
    public void customDelimiterTest() {

        // given
        String input = "//;\n142;34;3";

        // when
        int actual = stringCalculator.calculate(input);

        // then
        int expected = 179;

        Assertions.assertEquals(expected, actual);

    }


}
