import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("문자열 계산기 테스트")
public class StringCalculatorTest {
    private final StringCalculator calculator = new StringCalculator();

    @Nested
    @DisplayName("null 또는 빈 문자열일 때 0 반환")
    class Basic {

        @Test
        @DisplayName("null일때 0 반환")
        void returnsZeroWhenNull() {
            int result = calculator.add(null);

            assertThat(result).isZero();
        }

        @Test
        @DisplayName("빈 문자열일떄 0 반환")
        void returnsZeroWhenEmpty() {
            int result = calculator.add("");

            assertThat(result).isZero();
        }
    }

    @Nested
    @DisplayName("기본 구분자(, :)")
    class DefaultDelimiters {

        @ParameterizedTest
        @CsvSource({
                "'1,2', 3",
                "'1:2', 3",
                "'1,2:3', 6"
        })
        @DisplayName("쉼표/콜론으로 구분된 숫자 합을 반환한다")
        void addsWithCommaOrColon(String input, int expected) {
            int actual = calculator.add(input);
            assertThat(actual).isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("커스텀 구분자")
    class CustomDelimiter {

        @Test
        @DisplayName("커스텀 구분자로 정상 계산")
        void addsWithCustomDelimiter() {
            int result = calculator.add("//;\n1;2;3,4");
            assertThat(result).isEqualTo(10);
        }

        @Test
        @DisplayName("커스텀 구분자 형식에 \n이 없으면 예외 발생")
        void customDelimiterWithoutNewlineThrows() {
            assertThatThrownBy(() -> calculator.add("//;1;2;3"))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessage("\n이 없어 커스텀 구분자 형식이 올바르지 않습니다.");
        }

        @Test
        @DisplayName("커스텀 구분자가 비어있으면 예외 발생")
        void emptyCustomDelimiterThrows() {
            assertThatThrownBy(() -> calculator.add("//\n1,2"))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessage("커스텀 구분자가 비어있습니다.");
        }
    }

    @Nested
    @DisplayName("예외 처리")
    class Exceptions {

        @Test
        @DisplayName("음수가 포함되면 예외 발생")
        void negativeNumberThrows() {
            assertThatThrownBy(() -> calculator.add("1,-2,3"))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessage("음수는 허용되지 않습니다");
        }
    }
}
