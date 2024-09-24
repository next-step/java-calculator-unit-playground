package calculator;

import calculator.domain.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Nested
    @DisplayName("사칙연산 테스트")
    class CalculateTest {

        @Test
        @DisplayName("덧셈")
        void 더하기() {
            int a = 1;
            int b = 2;
            int expected = 3;

            Calculator calculator = new Calculator(a, b);
            int result = calculator.add();
            assertThat(result).isEqualTo(expected);
        }

        @Test
        @DisplayName("뺄셈")
        void 빼기() {
            int a = 2;
            int b = 1;
            int expected = 1;

            Calculator calculator = new Calculator(a, b);
            int result = calculator.subtract();
            assertThat(result).isEqualTo(expected);
        }

        @Test
        @DisplayName("곱셈")
        void 곱하기() {
            int a = 3;
            int b = 4;
            int expected = 12;

            Calculator calculator = new Calculator(a, b);
            int result = calculator.multiply();
            assertThat(result).isEqualTo(expected);
        }

        @Test
        @DisplayName("나눗셈")
        void 나누기() {
            int a = 4;
            int b = 2;
            int expected = 2;

            Calculator calculator = new Calculator(a, b);
            int result = calculator.divide();
            assertThat(result).isEqualTo(expected);
        }
    }

}
