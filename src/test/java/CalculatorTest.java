import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void add() {
        assertEquals(3, calculator.add(1, 2));
    }

    @Test
    void subtract() {
        assertEquals(-1, calculator.subtract(1, 2));
    }

    @Test
    void multiply() {
        assertEquals(6, calculator.multiply(2, 3));
        assertEquals(20, calculator.multiply(4, 5));
    }

    @Test
    void divide() {
        assertEquals(0, calculator.divide(2, 3));
        assertEquals(2, calculator.divide(8, 4));
        assertThrows(RuntimeException.class, () -> calculator.divide(3, 0));
    }

    @Test
    void parseAndSum() {
        assertEquals(0, calculator.parseAndSum(""));

        assertEquals(6, calculator.parseAndSum("1,2,3"));
        assertEquals(6, calculator.parseAndSum("1,2:3"));
        assertEquals(6, calculator.parseAndSum("1:2:3"));
    }

    @Test
    void pareAndSumWithCustomSep() {
        assertEquals(6, calculator.parseAndSum("//;\n1;2;3"));
    }

    @Test
    void parseAndSumWithWrongString() {
        assertThrows(RuntimeException.class, () -> calculator.parseAndSum("//a\n1;2;3"));
        assertThrows(RuntimeException.class, () -> calculator.parseAndSum("1;2;3"));
    }
}
