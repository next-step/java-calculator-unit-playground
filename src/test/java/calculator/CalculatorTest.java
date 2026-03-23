package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    @DisplayName("인자 두 개를 받아서, 덧셈을 테스트한다.")
    void testAdd() {
        // given
        Calculator calculator = new Calculator();

        // when & then
        assertThat(calculator.add(1, 2)).isEqualTo(3);

    }

    @Test
    void testSubtract() {
        // given
        Calculator calculator = new Calculator();

        // when & then
        assertThat(calculator.subtract(3,2)).isEqualTo(1);
    }

    @Test
    void testMultiply() {
        // given
        Calculator calculator = new Calculator();

        // when & then
        assertThat(calculator.multiply(1, 2)).isEqualTo(2);
    }

    @Test
    void testDivide() {
        // given
        Calculator calculator = new Calculator();

        // when & then
        assertThat(calculator.divide(6, 2)).isEqualTo(3);
    }

}
