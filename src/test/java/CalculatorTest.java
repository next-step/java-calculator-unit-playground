import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("두 개의 인자를 받아 덧셈을 할 수 있다.")
    void add() {
        // given
        int a = 2;
        int b = 3;

        // when
        int addedResult = calculator.add(a, b);

        // then
        assertThat(addedResult).isEqualTo(5);
    }

    @Test
    @DisplayName("두 개의 인자를 받아 뺄셈을 할 수 있다.")
    void subtract() {
        // given
        int a = 3;
        int b = 2;

        // when
        int subtractedResult = calculator.subtract(a, b);

        // then
        assertEquals(subtractedResult, 1);
    }

    @Test
    @DisplayName("두 개의 인자를 받아 곱셈을 할 수 있다.")
    void multiply() {
        // given
        int a = 3;
        int b = 2;

        // when
        int multipliedResult = calculator.multiply(a, b);

        // then
        assertThat(multipliedResult).isEqualTo(6);
    }

    @Test
    @DisplayName("두 개의 인자를 받아 나눗셈을 할 수 있다.")
    void divide() {
        // given
        int a = 32;
        int b = 2;

        // when
        int dividedResult = calculator.divide(a, b);

        // then
        assertThat(dividedResult).isEqualTo(16);
    }

    @Test
    @DisplayName("우항의 값이 0이라면 나눌 수 없다.")
    void canNot_divide_bvZero() {
        // given
        int a = 32;
        int b = 0;

        // expect
        assertThatThrownBy(() -> calculator.divide(a, b))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("0으로 나눌 수 없습니다.");
    }
}
