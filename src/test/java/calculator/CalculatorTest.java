package calculator;

import calculator.domain.Calculator;
import view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @Nested
    @DisplayName("사칙연산 테스트")
    class CalculateTest {

        final Calculator calculator = new Calculator();

        @Test
        @DisplayName("덧셈")
        void 더하기() {
            int a = 1;
            int b = 2;
            int expected = 3;

            int result = calculator.add(a,b);
            assertThat(result).isEqualTo(expected);
        }

        @Test
        @DisplayName("뺄셈")
        void 빼기() {
            int a = 2;
            int b = 1;
            int expected = 1;

            int result = calculator.subtract(a,b);
            assertThat(result).isEqualTo(expected);
        }

        @Test
        @DisplayName("곱셈")
        void 곱하기() {
            int a = 3;
            int b = 4;
            int expected = 12;

            int result = calculator.multiply(a,b);
            assertThat(result).isEqualTo(expected);
        }

        @Test
        @DisplayName("나눗셈")
        void 나누기() {
            int a = 4;
            int b = 2;
            int expected = 2;

            int result = calculator.divide(a,b);
            assertThat(result).isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("예외처리 테스트")
    class validationTest {

        @Test
        @DisplayName("연산자 예외처리")
        void 연산자_예외처리_테스트() {
            String simulatedInput = "%";
            System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

            assertThatThrownBy(() -> {
                InputView.InputOperator();
            }).isInstanceOf(IllegalArgumentException.class);

        }

        @Test
        @DisplayName("나눗셈 예외처리")
        void divider가_0일_시에_예외처리() {
            int a = 3;
            int b = 0;

            assertThatThrownBy(() -> {
                Calculator.divide(a,b);
            }).isInstanceOf(IllegalArgumentException.class);
        }

    }

}
