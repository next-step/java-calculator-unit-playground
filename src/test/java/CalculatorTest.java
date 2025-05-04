import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    @DisplayName("assertEquals:add_두수의_합을_반환")
    void add_두수의_합을_반환() {
        final var a = 3;
        final var b = 4;
        final var actual = 7;

        assertEquals(calculator.add(a,b), actual);
    }

    @Test
    @DisplayName("isEqualTo:add_두수의_합을_반환")
    void isEqualTo_add_두수의_합을_반환() {
        final var a = 3;
        final var b = 4;
        final var actual = 7;

        assertThat(actual).isEqualTo(calculator.add(a,b));
    }

    @Test
    @DisplayName("assertNotEquals:subtract_두수의_차를_반환")
    void subtract_두수의_차를_반환() {
        final var a = 5;
        final var b = 4;
        final var actual = -1;

        assertNotEquals(calculator.subtract(a,b), actual);
    }

    @Test
    @DisplayName("isNotEqualTo:subtract_두수의_차를_반환")
    void isNotEqualTo_subtract_두수의_차를_반환() {
        final var a = 5;
        final var b = 4;
        final var actual = -1;

        assertThat(actual).isNotEqualTo(calculator.subtract(a,b));
    }

    @Test
    @DisplayName("multiply_두수의_곱을_반환")
    void multiply_두수의_곱을_반환() {
        assertAll(
                () -> assertEquals(24, calculator.multiply(4,6)),
                () -> assertEquals(14, calculator.multiply(7,2)),
                () -> assertEquals(40, calculator.multiply(5,8))
        );

    }

    @Test
    @DisplayName("assertThrows:divide 메서드는 0으로 나누면 ArithmeticException을 던진다")
    void assertThrow_divide_0으로_나누면_예외발생() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(2,0);
        });
    }

    @Test
    @DisplayName("assertThatThrownBy:divide 메서드는 0으로 나누면 ArithmeticException을 던진다")
    void assertThatThrownBy_divide_0으로_나누면_예외발생() {
        assertThatThrownBy(() -> {
            calculator.divide(2,0);
        }).isInstanceOf(ArithmeticException.class)
                .hasMessage("/ by zero");
    }



}