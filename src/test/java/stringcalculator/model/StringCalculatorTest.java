package stringcalculator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import stringcalculator.exception.exceptions.OperandArgumentFormatException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("문자열 계산기 테스트")
@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void init() {
        stringCalculator = new StringCalculator();
    }

    @ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3", "1:2,3"})
    @ParameterizedTest(name = "입력값이 [{0}]인 경우")
    void 쉼표_또는_콜론으로_구분된_문자열을_전달한_경우_정상_계산(final String input) {
        // when
        int sum = stringCalculator.extractSumNumbers(input);

        // then
        assertThat(sum).isEqualTo(6);
    }

    @Test
    void 빈_문자열은_0을_반환() {
        // given
        String input = "";

        // when
        int sum = stringCalculator.extractSumNumbers(input);

        // then
        assertThat(sum).isEqualTo(0);
    }

    @ValueSource(strings = {"//?\n1?2?3", "//.\n1.2.3"})
    @ParameterizedTest(name = "입력값이 [{0}]인 경우")
    void 커스텀_구분_문자_이용(final String input) {
        // when
        int sum = stringCalculator.extractSumNumbers(input);

        // then
        assertThat(sum).isEqualTo(6);
    }

    @Nested
    class 문자열_계산기_예외 {

        @Test
        void 쉼표_콜론_이외에_다른_구분자가_있으면_예외() {
            // given
            String input = "1-2:3";

            // when & then
            assertThatThrownBy(() -> stringCalculator.extractSumNumbers(input))
                            .isInstanceOf(OperandArgumentFormatException.class);
        }

        @Test
        void 아예_문자열이_null이면_예외() {
            // given
            String input = null;

            // when & then
            assertThatThrownBy(() -> stringCalculator.extractSumNumbers(input))
                    .isInstanceOf(OperandArgumentFormatException.class);
        }

        @Test
        void 커스텀_구분자를_사용하지_않을_경우_예외() {
            // given
            String input = "//!\n1!2?3";

            // when & then
            assertThatThrownBy(() -> stringCalculator.extractSumNumbers(input))
                    .isInstanceOf(OperandArgumentFormatException.class);
        }

        @ValueSource(strings = {"/!\n1!2!3", "//!\1!2!3"})
        @ParameterizedTest(name = "입력값이 [{0}]인 경우")
        void 커스텀_구분자_조건이_충족되지_않을_경우_예외(final String input) {
            // when & then
            assertThatThrownBy(() -> stringCalculator.extractSumNumbers(input))
                    .isInstanceOf(OperandArgumentFormatException.class);
        }

        @Test
        void 커스텀_구분자에_숫자가_아닌_게_들어갈_경우_예외() {
            // given
            String input = "//1\n1:2:3";

            // when & then
            assertThatThrownBy(() -> stringCalculator.extractSumNumbers(input))
                    .isInstanceOf(OperandArgumentFormatException.class);
        }
    }
}
