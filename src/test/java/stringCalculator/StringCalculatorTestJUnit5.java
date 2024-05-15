package stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import simpleCalculator.model.StringCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTestJUnit5 {

    private static final int EXPECT_VALUE_ZERO = 0;
    private static final int EXPECT_VALUE_SIX = 6;

    @DisplayName("연산기능 테스트")
    @Nested
    class functionTest {

        @Test
        @DisplayName("값이 없거나 비어있는 경우")
        public void nullAndEmpty() {
            StringCalculator calculator = new StringCalculator();
            assertEquals(EXPECT_VALUE_ZERO, calculator.add(null));
            assertEquals(EXPECT_VALUE_ZERO, calculator.add(""));
        }

        @Test
        @DisplayName("기본 구분자를 사용하는 경우")
        public void addWithDefault() {
            StringCalculator calculator = new StringCalculator();
            assertEquals(EXPECT_VALUE_SIX, calculator.add("1,2,3"));
            assertEquals(EXPECT_VALUE_SIX, calculator.add("1,2:3"));
            assertEquals(EXPECT_VALUE_SIX, calculator.add("1:2,3"));
            assertEquals(EXPECT_VALUE_SIX, calculator.add("1:2:3"));
        }

        @Test
        @DisplayName("커스텀 구분자를 사용하는 경우")
        public void addWithCustom() {
            StringCalculator calculator = new StringCalculator();
            assertEquals(EXPECT_VALUE_SIX, calculator.add("//;\n1;2;3"));
        }
    }

    @DisplayName("예외처리 테스트")
    @Nested
    class exceptionTest {
        @Test
        @DisplayName("숫자가 아닌 다른 값을 입력한 경우")
        public void isNotNumber() {
            StringCalculator calculator = new StringCalculator();
            assertThrows(RuntimeException.class, () -> calculator.add("hi,1,2"));
            assertThrows(RuntimeException.class, () -> calculator.add("hi"));
        }

        @Test
        @DisplayName("음수를 입력한 경우")
        public void isNegative() {
            StringCalculator calculator = new StringCalculator();
            assertThrows(RuntimeException.class, () -> calculator.add("-2,1,2"));
            assertThrows(RuntimeException.class, () -> calculator.add("-2"));
        }
    }
}