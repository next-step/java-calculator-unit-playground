import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class StringCalculatorTest {

    @Nested
    public class TestFunction {
        @Test
        @DisplayName("문자열 테스트")
        void stringTest() {
            StringCalculator c = new StringCalculator();
            assertEquals(0, c.sumCalculator(""), "예외 발생1");
            assertEquals(3, c.sumCalculator("1,2"), "예외 발생2");
            assertEquals(6, c.sumCalculator("1,2,3"), "예외 발생3");
            assertEquals(6, c.sumCalculator("1,2:3"), "예외 발생4");
            assertEquals(6, c.sumCalculator("//;\\n1;2;3"), "예외 발생5");
            assertEquals(32, c.sumCalculator("//;123\\n4;4;5162637"), "예외 발생6");
            assertEquals(99, c.sumCalculator("//;6\\n4;4;516261;37"), "예외 발생7");
        }
    }
}
