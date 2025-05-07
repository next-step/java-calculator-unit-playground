import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("문자열 계산기 테스트")
public class StringCalculatorTest {

    StringCalculator stringCalculator = new StringCalculator();

    @Nested
    @DisplayName("입력된 값에 따라 결과값을 출력한다.")
    class ReturnResultTest{

        @Nested
        @DisplayName("입력된 값이 null 또는 빈 값일 경우")
        class ReturnResultNullOrBlankTest{

            @Test
            @DisplayName("null 입력")
            public void separateResult_InputIsNull_ReturnZero() {

                // given
                String input = null;

                // when
                int actual = stringCalculator.separateResult(input);

                assertThat(actual).isEqualTo(0);
            }

            @Test
            @DisplayName("빈 값 입력")
            public void separateResult_InputIsEmpty_ReturnZero() {

                // given
                String input = "";

                // when
                int actual = stringCalculator.separateResult(input);

                assertThat(actual).isEqualTo(0);
            }
        }

        @Nested
        @DisplayName("입력된 값에 음수 또는 숫자가 아닌 문자가 입력되었을 경우")
        class ReturnResultExceptionTest{

            @Test
            @DisplayName("음수 포함")
            public void separateResult_NegativeInput_ThrowException() {

                // given

                String input = "//;\n-142;34;3";


                assertThatThrownBy(() -> stringCalculator.separateResult(input))
                        .isInstanceOf(RuntimeException.class)
                        .hasMessageContaining("음수는 입력할 수 없습니다.");

            }

            @Test
            @DisplayName("숫자가 아닌 문자 포함")
            public void separateResult_NotNumberInput_ThrowException() {

                // given

                String input = "//#\n-감자;66;3";


                assertThatThrownBy(() -> stringCalculator.separateResult(input))
                        .isInstanceOf(RuntimeException.class)
                        .hasMessageContaining("숫자만 입력할 수 있습니다.");

            }
        }

        @Nested
        @DisplayName("정상적으로 입력된 경우")
        class ReturnResultNormalTest{

            @Test
            @DisplayName("기본 구분자를 가진 입력값")
            public void separateResult_InputDefaultDelimiter_ReturnSum() {

                // given

                String input = "1,4,2";

                // when

                int actual = stringCalculator.separateResult(input);
                assertThat(actual).isEqualTo(7);
            }

            @Test
            @DisplayName("커스텀 구분자를 가진 입력값")
            public void separateResult_InputCustomDelimiter_ReturnSum() {

                // given

                String input = "//;\n2;8;3";

                // when

                int actual = stringCalculator.separateResult(input);

                assertThat(actual).isEqualTo(13);
            }
        }
    }
}
