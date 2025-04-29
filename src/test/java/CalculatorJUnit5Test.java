import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Calculator junit5 Test")
public class CalculatorJUnit5Test {

    private Calculator calculator = new Calculator();

    @Test
    @DisplayName("add")
    void add_test() {
        int a = 1;
        int b = 2;
        int expected = a + b;

        int actual = calculator.add(1, 2);

        if (actual != expected) {
            throw new RuntimeException("expected: <" + expected + "> but was: <" + actual + ">");
        }
    }

    @Test
    @DisplayName("subtract")
    void subtract_test() {
        int a = 1;
        int b = 2;
        int expected = 1 - 2;

        int actual = calculator.subtract(a, b);

        if (actual != expected) {
            throw new RuntimeException("expected: <" + expected + "> but was: <" + actual + ">");
        }
    }

    @Test
    @DisplayName("multiply")
    void multiply_test() {
        int a = 1;
        int b = 2;
        int expected = a * b;

        int actual = calculator.multiply(a, b);

        if (actual != expected) {
            throw new RuntimeException("expected: <" + expected + "> but was: <" + actual + ">");
        }
    }

    @Test
    @DisplayName("divide")
    void divide_test() {
        int a = 1;
        int b = 2;
        int expected = a / b;

        int actual = calculator.divide(a, b);

        if (actual != expected) {
            throw new RuntimeException("expected: <" + expected + "> but was: <" + actual + ">");
        }
    }
}
