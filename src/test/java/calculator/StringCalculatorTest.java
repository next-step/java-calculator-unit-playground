package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    private StringCalculator stringCalculator=new StringCalculator();

    @Nested
    @DisplayName("기본 구분자 , 또는 : 구분자 테스트")
    class DefaultDelimiterTest {
        @ParameterizedTest(name="input: {0}, expected:{1}")
        @CsvSource({
                "'',0",
                "'1',1",
                "'1,2',3",
                "'1,2:3',6"
        })
        void testDefaultDelimiter(String input, int expected) {
            int result=stringCalculator.add(input);
            assertThat(result).as(", 또는 : 구분자를 사용한 계산").isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("커스텀 구분자 테스트")
    class CustomDelimiterTest {
        @Test
        @DisplayName("//;\n1;2;3 -> 6")
        void testCustomDelimiter1() {
            int result=stringCalculator.add("//;\n1;2;3");
            assertThat(result).as("커스텀 구분자를 사용한 계산").isEqualTo(6);
        }
        @Test
        @DisplayName("//#\n10#20#30 => 60")
        void testCustomDelimiter2() {
            assertThat(stringCalculator.add("//#\n10#20#30")).isEqualTo(60);
        }
    }

    @Nested
    @DisplayName("잘못된 입력 테스트")
    class ExceptionTest {
        @Test
        @DisplayName("숫자가 아닌 토큰")
        void checkInvalidToken(){
            assertThatThrownBy(() -> stringCalculator.add("1,abc,3"))
                    .as("숫자가 아닌 토큰 입력시 IllegalArgumentException")
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("Invalid token");
        }

        @Test
        @DisplayName("음수 토큰")
        void checkNegativeToken() {
            String input = "-1,3";
            assertThatThrownBy(() -> stringCalculator.add(input))
                    .as("음수 토큰 입력 시 IllegalArgumentException")
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("Negative number");
        }

        @Test
        @DisplayName("음수 토큰")
        void checkNegativeWithCustomDelimiter() {
            String input = "//;\n-1;3";
            assertThatThrownBy(() -> stringCalculator.add(input))
                    .as("음수 토큰 입력 시 IllegalArgumentException")
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("Negative number");
        }

    }

}
