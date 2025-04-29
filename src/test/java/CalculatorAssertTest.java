import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Calculator Assert Test")
public class CalculatorAssertTest {

    private Calculator calculator = new Calculator();

    @Test
    @DisplayName("add")
    void add_test() {
        int a = 1;
        int b = 2;
        int expected = a + b;

        int actual = calculator.add(1, 2);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("subtract")
    void subtract_test() {
        int a = 1;
        int b = 2;
        int expected = 1 - 2;

        int actual = calculator.subtract(a, b);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("multiply")
    void multiply_test() {
        int a = 1;
        int b = 2;
        int expected = a * b;

        int actual = calculator.multiply(a, b);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("divide")
    void divide_test() {
        int a = 1;
        int b = 2;
        int expected = a / b;

        int actual = calculator.divide(a, b);

        assertEquals(expected, actual);
    }
}
