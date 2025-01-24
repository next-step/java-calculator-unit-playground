import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator();

    @Test
    public void testEmptyString() {
        assertEquals(0, calculator.add(""));
    }


    @Test
    public void testNumbers() {
        assertEquals(3, calculator.add("1,2"));
        assertEquals(7, calculator.add("3:4"));
        assertEquals(6, calculator.add("1,2,3"));
        assertEquals(10, calculator.add("4:2:4"));
        assertEquals(15, calculator.add("1,2:3,4,5"));
    }

    @Test
    public void testNegativeNumber() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            calculator.add("1,-2");
        });
        assertEquals("음수가 포함되어 있습니다.", exception.getMessage());
    }

    @Test
    public void testInvalidString() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            calculator.add("1,a");
        });
        assertEquals("잘못된 입력입니다.", exception.getMessage());
    }

    @Test
    public void testMixedDelimiters() {
        assertEquals(10, calculator.add("1,2:3,4"));
        assertEquals(15, calculator.add("1,2:3,4,5"));
    }
}


