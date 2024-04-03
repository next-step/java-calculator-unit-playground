import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    private final StringCalculator calculator = new StringCalculator();

    @Test
    void addEmptyString() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    void addNormal() {
        assertEquals(3, calculator.add("1,2"));
    }

    @Test
    void addWithSeparator() {
        assertEquals(6, calculator.add("1,2:3"));
    }

    @Test
    void addWithCustomSeparator() {
        assertEquals(6, calculator.add("//;\n1;2;3"));
    }

    @Test
    void addWithNegative() {
        assertThrows(RuntimeException.class, () -> calculator.add("-1,2,3"));
    }
}
