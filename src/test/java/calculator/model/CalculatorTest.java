package calculator.model;

import calculator.exception.exceptions.DivideZeroOperationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("초간단 계산기 테스트")
@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void init() {
        calculator = new Calculator();
    }

    @Nested
    class 사칙연산_정상 {

        @Test
        void 덧셈() {
            // given
            int number1 = 10;
            int number2 = 30;

            // when
            int addValue = calculator.add(number1, number2);

            // then
            assertThat(addValue).isEqualTo(number1 + number2);
        }

        @Test
        void 뺄셈() {
            // given
            int number1 = 10;
            int number2 = 30;

            // when
            int minusValue = calculator.minus(number1, number2);

            // then
            assertThat(minusValue).isEqualTo(number1 - number2);
        }

        @Test
        void 곱셈() {
            // given
            int number1 = 10;
            int number2 = 30;

            // when
            int multipleValue = calculator.multiply(number1, number2);

            // then
            assertThat(multipleValue).isEqualTo(number1 * number2);
        }

        @Test
        void 나눗셈() {
            // given
            int number1 = 30;
            int number2 = 10;

            // when
            int divideValue = calculator.divide(number1, number2);

            // then
            assertThat(divideValue).isEqualTo(number1 / number2);
        }
    }

    @Test
    void 나눗셈_예외() {
        // given
        int number1 = 30;
        int number2 = 0;

        // when & then
        assertThatThrownBy(() -> calculator.divide(number1, number2))
                .isInstanceOf(DivideZeroOperationException.class);
    }
}
