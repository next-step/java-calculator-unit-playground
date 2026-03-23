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
    @DisplayName("인자 두 개를 받아서, 뺄셈을 테스트한다.")
    void testSubtract() {
        // given
        Calculator calculator = new Calculator();

        // when & then
        assertThat(calculator.subtract(3,2)).isEqualTo(1);
    }

    @Test
    @DisplayName("인자 두 개를 받아서, 곱셈을 테스트한다.")
    void testMultiply() {
        // given
        Calculator calculator = new Calculator();

        // when & then
        assertThat(calculator.multiply(1, 2)).isEqualTo(2);
    }

    @Test
    @DisplayName("인자 두 개를 받아서, 나눗셈을 테스트한다.")
    void testDivide() {
        // given
        Calculator calculator = new Calculator();

        // when & then
        assertThat(calculator.divide(6, 2)).isEqualTo(3);
    }

    @Test
    @DisplayName("문자열을 받아서 덧셈을 테스트한다.")
    void testAddByString() {
        // given
        Calculator calculator = new Calculator();

        // when & then
        assertThat(calculator.add("//:\\n1:2:3:4")).isEqualTo(10);
        assertThat(calculator.add("133\\:-2:3:4")).isEqualTo(6); //error
    }
}
