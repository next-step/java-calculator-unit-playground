package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CalculatorTest {


    private Calculator calculator = new Calculator();

    @Test
    void add() {
        assertEquals(calculator.add(1, 2), 3);
    }

    @Test
    void minus() {
        assertEquals(calculator.minus(2, 1), 1);
    }

    @Test
    void multiple() {
        assertEquals(calculator.multiply(2, 1), 2);
        assertEquals(calculator.multiply(2, 4), 8);
    }

    @Test
    void divide() {
        assertEquals(calculator.divide(8, 4), 2);
    }
}
