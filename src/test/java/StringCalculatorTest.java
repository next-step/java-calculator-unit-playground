import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    private final StringCalculator calculator = new StringCalculator();

    @Test
    void add_withEmptyString_returnsZero() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    void add_withTwoNumbersSeparatedByComma_returnsTheirSum() {
        assertEquals(3, calculator.add("1,2"));
    }

    @Test
    void add_withNumbersSeparatedByCommaOrColon_returnsTheirSum() {
        assertEquals(6, calculator.add("1,2:3"));
    }

    @Test
    void add_withCustomDelimiter_returnsTheirSum() {
        assertEquals(6, calculator.add("//;\n1;2;3"));
    }

    @Test
    void add_withNegativeNumber_throwsRuntimeException() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            calculator.add("-1,2,3");
        });
        assertEquals("Negative value not allowed", exception.getMessage());
    }
}
