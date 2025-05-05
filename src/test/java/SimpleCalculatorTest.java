import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SimpleCalculatorTest {

    private final SimpleCalculator cal = new SimpleCalculator();

    @Test
    void add() {
        assertEquals(cal.add(5, 2), 7);
    }

    @Test
    void subtract() {
        assertEquals(cal.subtract(5, 2), 3);
    }

    @Test
    void multiply() {
        assertEquals(cal.multiply(5, 2), 10);
    }

    @Test
    void divide() {
        assertEquals(cal.divide(10, 2), 5);
    }

    @Test
    @DisplayName("0으로 나누면 예외가 발생한다")
    void divideByZero() {
        assertThatThrownBy(() -> cal.divide(1, 0)).isInstanceOf(RuntimeException.class);
    }
}
