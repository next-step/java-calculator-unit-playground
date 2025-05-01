import static org.junit.jupiter.api.Assertions.*;

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
}