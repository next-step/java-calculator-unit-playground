import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class StringCalculatorJunit5Test {
    private final StringCalculator stringCalculator = new StringCalculator();

    @Nested
    @DisplayName("덧셈 테스트")
    class AddTest {
        @Test
        void 빈_문자열() {
            assertEquals(0, stringCalculator.add(""));
        }

        @Test
        void 하나의_숫자() {
            assertEquals(1, stringCalculator.add("1"));
            assertEquals(5, stringCalculator.add("5"));
        }

        @Test
        void 두_숫자_더하기() {
            assertEquals(3, stringCalculator.add("1,2"));
            assertEquals(7, stringCalculator.add("3,4"));
        }

        @Test
        void 여러_숫자_더하기() {
            assertEquals(6, stringCalculator.add("1,2,3"));
            assertEquals(15, stringCalculator.add("4,5,6"));
        }

        @Test
        void 커스텀_구분자() {
            assertEquals(3, stringCalculator.add("//;\n1;2"));
            assertEquals(12, stringCalculator.add("//;\n4;5,1:2"));
        }

        @Test
        void 음수_예외() {
            Exception exception = assertThrows(RuntimeException.class, () -> {
                stringCalculator.add("-1");
            });
        }

        @Test
        void 숫자가_아닌_예외() {
            Exception exception = assertThrows(RuntimeException.class, () -> {
                stringCalculator.add("1,a");
            });
        }
    }
}
