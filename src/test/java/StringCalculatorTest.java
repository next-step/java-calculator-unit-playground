import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;


@DisplayName("문자열 계산기 테스트")
public class StringCalculatorTest {

    StringCalculator stringCalculator = new StringCalculator();

    @Nested
    @DisplayName("문자열 계산기 입력 시 구분자를 반환한다.")
    class DelimiterTest {

        @Test
        @DisplayName("기본 구분자 반환")
        public void findDelimiter_ReturnDefaultDelimiter() {
            SoftAssertions softly = new SoftAssertions();

            softly.assertThat(stringCalculator.findDelimiter("1,4,5")).isEqualTo("[,|:]");
            softly.assertThat(stringCalculator.findDelimiter("1:4:5")).isEqualTo("[,|:]");
            softly.assertThat(stringCalculator.findDelimiter("1,4:5")).isEqualTo("[,|:]");

            softly.assertAll();

        }

        @Test
        @DisplayName("커스텀 구분자 반환")
        public void findDelimiter_ReturnCustomDelimiter() {
            SoftAssertions softly = new SoftAssertions();

            softly.assertThat(stringCalculator.findDelimiter("//;\n142;34;3")).isEqualTo(";");
            softly.assertThat(stringCalculator.findDelimiter("//!\n13!8!9!51!91")).isEqualTo("!");
            softly.assertThat(stringCalculator.findDelimiter("//~\n22~34~21")).isEqualTo("~");

            softly.assertAll();

        }
    }

    @Nested
    @DisplayName("구분자를 기준으로 입력된 문자열을 나눠 문자열 배열 형태로 반환한다.")
    class ParseInputTest{

        @Test
        @DisplayName("기본 구분자 - 입력된 문자열 -> 문자열 배열 반환")
        public void parseInput_DefaultDelimiter_ReturnStringArray() {

            // Given
            String input = "1,4,6:9";
            String delimiter = "[,|:]";

            // When
            String[] actual = stringCalculator.parseInput(input, delimiter);

            // then
            String[] expected = new String[]{"1","4","6","9"};

            assertThat(actual).isEqualTo(expected);
        }

        @Test
        @DisplayName("커스텀 구분자 - 입력된 문자열 -> 문자열 배열 반환")
        public void parseInput_CustomDelimiter_ReturnStringArray() {

            // Given
            String input = "//&\n10&8&9";
            String delimiter = "&";

            // When
            String[] actual = stringCalculator.parseInput(input, delimiter);

            // then
            String[] expected = new String[]{"10","8","9"};

            assertThat(actual).isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("문자열 배열을 숫자 리스트로 변환한다.")
    class StringToNumberTest{

        @Test
        @DisplayName("숫자 리스트 형태로 반환")
        public void makeNumberList_StringArray_ReturnIntegerList() {

            // given
            String[] tokens = {"3","55","23"};

            // when
            List<Integer> actual = stringCalculator.makeNumberList(tokens);

            // then
            List<Integer> expected = new ArrayList<>(Arrays.asList(3,55,23));

            assertEquals(expected,actual);


        }
    }

    @Nested
    @DisplayName("만들어진 숫자리스트의 합을 출력한다.")
    class AddNumbersTest{

        @Test
        @DisplayName("리스트의 합 반환")
        public void addNumbers_ReturnSum() {

            SoftAssertions softly = new SoftAssertions();

            softly.assertThat(stringCalculator.addNumbers(Arrays.asList(1,5,3))).isEqualTo(9);
            softly.assertThat(stringCalculator.addNumbers(Arrays.asList(33,22,11))).isEqualTo(66);

        }
    }

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
