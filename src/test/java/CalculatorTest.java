import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    @DisplayName("두 개의 정수를 더해본다")
    void add() {
        final int expected = 12;
        final int actual = new Calculator().add(8, 4);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("두 개의 정수를 빼본다")
    void subtract() {
        final int expected = 4;
        final int actual = new Calculator().subtract(8, 4);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("두 개의 정수를 곱해본다")
    void multiply() {
        final int expected = 32;
        final int actual = new Calculator().multiply(8, 4);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("두 개의 정수를 나눠본다")
    void divide() {
        final int expected = 2;
        final int actual = new Calculator().divide(8, 4);

        assertEquals(expected, actual);
    }
}
