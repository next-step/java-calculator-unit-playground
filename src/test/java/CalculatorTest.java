import domain.Calculator;
import exception.ErrorMessage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void 덧셈_테스트() {
        final int num1 = 1;
        final int num2 = 2;
        final int actual = calculator.add(num1, num2);

        assertThat(actual).isEqualTo(num1 + num2);
    }

    @Test
    public void 뺄셈_테스트() {
        final int num1 = 3;
        final int num2 = 2;
        final int actual = calculator.sub(num1, num2);

        assertThat(actual).isEqualTo(num1 - num2);
    }

    @Test
    public void 곱셈_테스트() {
        final int num1 = 3;
        final int num2 = 2;
        final int actual = calculator.mul(num1, num2);

        assertThat(actual).isEqualTo(num1 * num2);
    }

    @Test
    public void 나눗셈_테스트() {
        final int num1 = 4;
        final int num2 = 2;
        final int actual = calculator.div(num1, num2);

        assertThat(actual).isEqualTo(num1 / num2);
    }

    @Test
    public void 덧셈_오버플로우_예외_발생() {
        final int num1 = Integer.MAX_VALUE;
        final int num2 = Integer.MAX_VALUE;

        assertThatThrownBy(() -> calculator.add(num1, num2))
                .isInstanceOf(ArithmeticException.class);
    }

    @Test
    public void 뺄셈_오버플로우_예외_발생() {
        final int num1 = Integer.MIN_VALUE;
        final int num2 = Integer.MAX_VALUE;

        assertThatThrownBy(() -> calculator.sub(num1, num2))
                .isInstanceOf(ArithmeticException.class);
    }

    @Test
    public void 곱셈_오버플로우_예외_발생() {
        final int num1 = Integer.MAX_VALUE;
        final int num2 = Integer.MAX_VALUE;

        assertThatThrownBy(() -> calculator.mul(num1, num2))
                .isInstanceOf(ArithmeticException.class);
    }

    @Test
    public void 나눗셈_0으로_나누면_예외_발생() {
        final int num1 = Integer.MAX_VALUE;
        final int num2 = 0;

        assertThatThrownBy(() -> calculator.div(num1, num2))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining(ErrorMessage.DIVIDE_BY_ZERO);
    }
}
