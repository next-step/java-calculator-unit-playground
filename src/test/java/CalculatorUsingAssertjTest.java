import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorUsingAssertjTest {

    Calculator calculator = new Calculator();

    @Test
    @DisplayName("두 개의 숫자를 더하는 테스트")
    void add() {
        int result = calculator.add(20, 10);
        assertThat(result).isEqualTo(30);
    }

    @Test
    @DisplayName("두 개의 숫자를 빼는 테스트")
    void subtract() {
        int result = calculator.subtract(20, 10);
        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("두 개의 숫자를 곱 하는 테스트 ")
    void multiply() {
        int result = calculator.multiply(20, 10);
        assertThat(result).isEqualTo(200);
    }

    @Test
    @DisplayName("두 개의 숫자를 나누는 테스트")
    void divide() {
        int result = calculator.divide(20, 10);
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("숫자 0으로 나눴을 때 예외가 발생 하는 지 테스트")
    void divideByZero() {
        assertThatThrownBy(() -> calculator.divide(20, 0))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
