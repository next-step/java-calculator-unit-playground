import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorTest {

    private final StringCalculator stringCalculator = new StringCalculator();

    @Nested
    @DisplayName("입력된 문자열 합 계산")
    class addTest {

        @Test
        @DisplayName("쉼표와 콜론을 구분자로 가지는 문자열의 합을 반환한다.")
        public void shouldReturnSumOfString() {
            final String expression = "1,2:3";
            assertThat(6).isSameAs(stringCalculator.add(expression));
        }

        @Test
        @DisplayName("숫자 문자 1개만 입력 되었을 때 해당 숫자를 반환한다.")
        public void shouldReturnSumOfChar() {
            final String expression = "1";
            assertThat(1).isSameAs(stringCalculator.add(expression));
        }

        @Test
        @DisplayName("숫자가 아닌 문자열이 입력 되었을 때 RuntimeException이 발생한다.")
        public void shouldReturnRuntimeExceptionToNumberFormatException() {
            final String expression = "example";
            assertThatThrownBy(() -> stringCalculator.add(expression)).isInstanceOf(RuntimeException.class);
        }

        @Test
        @DisplayName("커스텀 구분자를 사용한 문자열의 합을 반환한다.")
        public void shouldReturnSumWithCustomDistinguishedOfString() {
            final String expression = "1//;\n2,3:4";
            assertThat(10).isSameAs(stringCalculator.add(expression));
        }

    }

    @Nested
    @DisplayName("입력된 문자열의 차 계산")
    class subtractTest {

        @Test
        @DisplayName("쉽표와 콜론을 구분자로 가지는 문자열의 차로 양수를 반환한다.")
        public void shouldReturnSubtractWithPositiveOfString() {
            final String expression = "4,2:1";
            assertThat(1).isSameAs(stringCalculator.subtract(expression));
        }

        @Test
        @DisplayName("쉽표와 콜론을 구분자로 가지는 문자열의 차로 0을 반환한다.")
        public void shouldReturnSubtractWithZeroOfString() {
            final String expression = "3:2,1";
            assertThat(0).isSameAs(stringCalculator.subtract(expression));
        }

        @Test
        @DisplayName("쉼표와 콜론을 구분자로 가지는 문자열의 차로 음수를 반환한다.")
        public void shouldReturnSubtractWithNegativeOfString() {
            final String expression = "1,2:3";
            assertThat(-4).isSameAs(stringCalculator.subtract(expression));
        }

        @Test
        @DisplayName("숫자 문자 1개만 입력 되었을 때 해당 숫자를 반환한다.")
        public void shouldReturnSubtractOfChar() {
            final String expression = "1";
            assertThat(1).isSameAs(stringCalculator.subtract(expression));
        }

        @Test
        @DisplayName("숫자가 아닌 문자열이 입력 되었을 때 RuntimeException이 발생한다.")
        public void shouldReturnRuntimeExceptionToNumberFormatException() {
            final String expression = "example";
            assertThatThrownBy(() -> stringCalculator.subtract(expression)).isInstanceOf(RuntimeException.class);
        }

        @Test
        @DisplayName("커스텀 구분자를 사용한 문자열의 차을 반환한다.")
        public void shouldReturnSumWithCustomDistinguishedOfString() {
            final String expression = "4:1//;\n2,1";
            assertThat(0).isSameAs(stringCalculator.subtract(expression));
        }
    }

    @Nested
    @DisplayName("입력된 문자열의 곱 계산")
    class multiplyTest {

        @Test
        @DisplayName("쉼표와 콜론을 구분자로 가지는 문자열의 곱으로 양수를 반환한다.")
        public void shouldReturnMultiplyWithPositiveOfString() {
            final String expression = "1,2:3";
            assertThat(6).isSameAs(stringCalculator.multiply(expression));
        }

        @Test
        @DisplayName("쉼표와 콜론을 구분자로 가지는 문자열의 곱으로 0을 반환한다.")
        public void shouldReturnMultiplyWithZeroOfString() {
            final String expression = "1,2:0";
            assertThat(0).isSameAs(stringCalculator.multiply(expression));
        }

        @Test
        @DisplayName("쉽표와 콜론을 구분자로 가지는 문자열의 곱으로 음수를 반환한다.")
        public void shouldReturnMultiplyWithNegativeOfString() {
            final String expression = "1,2:-3";
            assertThat(-6).isSameAs(stringCalculator.multiply(expression));
        }

        @Test
        @DisplayName("숫자가 아닌 문자열이 입력 되었을 때 RuntimeException이 발생한다.")
        public void shouldReturnRuntimeExceptionToNumberFormatException() {
            final String expression = "example";
            assertThatThrownBy(() -> stringCalculator.multiply(expression)).isInstanceOf(RuntimeException.class);
        }

        @Test
        @DisplayName("커스텀 구분자를 사용한 문자열의 곱을 반환한다.")
        public void shouldReturnSumWithCustomDistinguishedOfString() {
            final String expression = "2:4,1//;\n2";
            assertThat(16).isSameAs(stringCalculator.multiply(expression));
        }
    }

    @Nested
    @DisplayName("입력된 문자열의 몫 계산")
    class divideTest {

        @Test
        @DisplayName("쉼표와 콜론을 구분자로 가지는 문자열의 몫으로 양수를 반환한다.")
        public void shouldReturnDivideOfStringToPositive() {
            final String expression = "24,2:3";
            assertThat(4).isSameAs(stringCalculator.divide(expression));
        }

        @Test
        @DisplayName("0으로 나누면 ArithmeticException이 발생한다..")
        void shouldReturnDivideWithZeroOfString() {
            final String expression = "1,2:0";
            assertThatThrownBy(() -> stringCalculator.divide(expression)).isInstanceOf(ArithmeticException.class);
        }

        @Test
        @DisplayName("숫자가 아닌 문자열이 입력 되었을 때 RuntimeException이 발생한다.")
        public void shouldReturnRuntimeExceptionToNumberFormatException() {
            final String expression = "example";
            assertThatThrownBy(() -> stringCalculator.divide(expression)).isInstanceOf(RuntimeException.class);
        }

        @Test
        @DisplayName("커스텀 구분자를 사용한 문자열의 몫을 반환한다.")
        public void shouldReturnSumWithCustomDistinguishedOfString() {
            final String expression = "50:2,5//;\n1";
            assertThat(5).isSameAs(stringCalculator.divide(expression));
        }
    }
}
