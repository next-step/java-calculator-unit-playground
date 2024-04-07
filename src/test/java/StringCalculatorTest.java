import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("문자열 계산기 JUnit5 테스트")
public class StringCalculatorTest {
    @DisplayName("문자열 계산기 덧셈 테스트")
    @Test
    public void addTest() {
        assertEquals(11, StringCalculator.sum("6:5"));
        assertEquals(15, StringCalculator.sum("//'\n6'5:4"));
        assertEquals(23, StringCalculator.sum("6:5,7,5"));
        assertThrows(RuntimeException.class, () -> StringCalculator.sum("6,6;7;3"));
        assertThrows(RuntimeException.class, () -> StringCalculator.sum("//}\n6,6,;3"));
    }
}
