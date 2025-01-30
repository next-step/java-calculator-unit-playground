import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("초간단 계산기 테스트")
class SimpleCalculatorTest {

    private SimpleCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new SimpleCalculator();
    }

    @Test
    @DisplayName("덧셈 테스트")
    void testAdd() {
        assertThat(calculator.add(2, 3)).isEqualTo(5);
        assertThat(calculator.add(0, 0)).isEqualTo(0);
        assertThat(calculator.add(-2, -3)).isEqualTo(-5);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void testSubtract() {
        assertThat(calculator.subtract(3, 2)).isEqualTo(1);
        assertThat(calculator.subtract(0, 3)).isEqualTo(-3);
        assertThat(calculator.subtract(5, 5)).isEqualTo(0);
    }

    @Test
    @DisplayName("곱셈 테스트")
    void testMultiply() {
        assertThat(calculator.multiply(2, 5)).isEqualTo(10);
        assertThat(calculator.multiply(0, 3)).isEqualTo(0);
        assertThat(calculator.multiply(-5, 3)).isEqualTo(-15);
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void testDivide() {
        assertThat(calculator.divide(6, 3)).isEqualTo(2);
        assertThat(calculator.divide(-6, 3)).isEqualTo(-2);

        assertThatThrownBy(() -> calculator.divide(9, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로 나눗셈 불가");
    }
}
