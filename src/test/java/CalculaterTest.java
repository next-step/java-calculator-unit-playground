import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculaterTest {

    Calculater calculater = new Calculater();

    @Test
    void add() {
        int actual = calculater.add(1, 2);
        assertEquals(3, actual);
    }

    @Test
    void subtract() {
        int actual = calculater.subtract(1, 2);
        assertEquals(-1, actual);
    }

    @Test
    void multiply() {
        int actual = calculater.multiply(1, 2);
        assertEquals(2, actual);
    }

    @Test
    void divide() {
        int actual = calculater.divide(1, 2);
        assertEquals(0, actual);
    }
}
