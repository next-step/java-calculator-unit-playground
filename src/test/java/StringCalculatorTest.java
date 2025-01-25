import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {
    StringCalculator stringCalculator = new StringCalculator();

    @Nested
    @DisplayName("문자열 계산기 테스트")
    class StringCalculatorMethodTest {
        @Test
        @DisplayName("기본 구분자 연산 테스트")
        void 기본_구분자_연산_테스트() {
            assertEquals(6, stringCalculator.totalNumInString("1,1,2,2"));
            assertEquals(40, stringCalculator.totalNumInString("10:21,4,5"));
            assertEquals(3, stringCalculator.totalNumInString("1:1:1"));
        }

        @Test
        @DisplayName("기본 구분자 예외 테스트")
        void 기본_구분자_예외_테스트() {
            assertThrows(RuntimeException.class, () -> stringCalculator.totalNumInString("a:b,c:"));
            assertThrows(RuntimeException.class, () -> stringCalculator.totalNumInString("%010:1234:5678"));
            assertThrows(RuntimeException.class, () -> stringCalculator.totalNumInString("1:2,-3:4"));
        }

        @Test
        @DisplayName("커스텀 구분자 연산 테스트")
        void 커스텀_구분자_연산_테스트() {
            assertEquals(28, stringCalculator.totalNumInString("//-\n1-2-3-4-5-6-7"));
            assertEquals(7, stringCalculator.totalNumInString("//!\n2!5"));
            assertEquals(60, stringCalculator.totalNumInString("//@@\n10@@20@@30"));
            assertEquals(300, stringCalculator.totalNumInString("//!@\n100!@200"));
        }

        @Test
        @DisplayName("커스텀 구분자 예외 테스트")
        void 커스텀_구분자_예외_테스트() {
            assertThrows(RuntimeException.class, () -> stringCalculator.totalNumInString("//-1-2-3-4-5-6-7"));
            assertThrows(RuntimeException.class, () -> stringCalculator.totalNumInString("@\n1@3@10"));
            assertThrows(RuntimeException.class, () -> stringCalculator.totalNumInString("//%%\n3%8%2"));
        }
    }
}
