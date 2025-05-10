import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {
    StringCalculator stringCalculator = new StringCalculator();

    @Test
    @DisplayName("기본 구분자만 사용했을 때 제대로 작동하는지 확인한다")
    void defaultDelimiterTest() {
        final var input = "1,3:4";
        final var actual = stringCalculator.calculate(input);
        final var expected = 8;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("커스텀 구분자를 사용했을 때 제대로 작동하는지 확인한다")
    void customDelimiterTest() {
        final var input = "//@\n1,3:4@5";
        final var actual = stringCalculator.calculate(input);
        final var expected = 13;
        assertThat(actual).isEqualTo(expected);
    }

    @Nested
    @DisplayName("특정 예외 메시지가 발생하는지 확인한다")
    class ExceptionTest{
        @Test
        @DisplayName("음수가 있을 때 예외가 발생하는지 확인한다")
        void negativeExceptionTest(){
            final var input = "1,-2,3";
            assertThatThrownBy(() -> stringCalculator.calculate(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("음수는 허용되지 않습니다: -2");
        }

        @Test
        @DisplayName("문자가 있을 때 예외가 발생하는지 확인한다")
        void stringExceptionTest(){
            final var input = "3:a:2";
            assertThatThrownBy(() -> stringCalculator.calculate(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("숫자가 아닌 값이 포함되어 있습니다: a");
        }

    }
}
