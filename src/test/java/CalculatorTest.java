import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Nested
    class CalculatorMethodTest {
        @Test
        @DisplayName("덧셈 테스트")
        void testAdd() {
            Assertions.assertThat(calculator.plus(1, 2)).isEqualTo(3);
            Assertions.assertThat(calculator.plus(30, -35)).isEqualTo(-5);
            Assertions.assertThat(calculator.plus(3.6, 0.4)).isEqualTo(4);
            Assertions.assertThat(calculator.plus(4.1, 1)).isEqualTo(5);
            Assertions.assertThatThrownBy(() -> calculator.plus(1, Integer.MAX_VALUE))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("뺄셈 테스트")
        void testMinus() {
            Assertions.assertThat(calculator.minus(10, 5)).isEqualTo(5);
            Assertions.assertThat(calculator.minus(10, 20)).isEqualTo(-10);
            Assertions.assertThat(calculator.minus(7.1, 4.1)).isEqualTo(3);
            Assertions.assertThat(calculator.minus(-1, -5.9)).isEqualTo(4);
            Assertions.assertThatThrownBy(() -> calculator.minus(Integer.MIN_VALUE, 1))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("곱셈 테스트")
        void testMultiply() {
            Assertions.assertThat(calculator.multiply(2, 5)).isEqualTo(10);
            Assertions.assertThat(calculator.multiply(1, 0)).isEqualTo(0);
            Assertions.assertThat(calculator.multiply(3.5, 2.4)).isEqualTo(8);
            Assertions.assertThat(calculator.multiply(2, -2)).isEqualTo(-4);
            Assertions.assertThat(calculator.multiply(-2.5, -4)).isEqualTo(10);
            Assertions.assertThatThrownBy(() -> calculator.multiply(Integer.MAX_VALUE, 2))
                    .isInstanceOf(IllegalArgumentException.class);
            Assertions.assertThatThrownBy(() -> calculator.multiply(Integer.MIN_VALUE, 0.5))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("나눗셈 테스트")
        void testDevide() {
            Assertions.assertThatThrownBy(() -> calculator.devide(10, 0))
                    .isInstanceOf(IllegalArgumentException.class);
            Assertions.assertThat(calculator.devide(10, 5)).isEqualTo(2);
            Assertions.assertThat(calculator.devide(0, 10)).isEqualTo(0);
            Assertions.assertThat(calculator.devide(12, -4)).isEqualTo(-3);
            Assertions.assertThat(calculator.devide(-30, -5)).isEqualTo(6);
            Assertions.assertThat(calculator.devide(8.6, 2)).isEqualTo(4);
            Assertions.assertThatThrownBy(() -> calculator.devide(Integer.MIN_VALUE, 0.5))
                    .isInstanceOf(IllegalArgumentException.class);
            Assertions.assertThatThrownBy(() -> calculator.devide(Integer.MAX_VALUE, 0.25))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
