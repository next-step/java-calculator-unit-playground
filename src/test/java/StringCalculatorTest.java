import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {
    @ParameterizedTest
    @DisplayName("문자열 계산기 기능 테스트")
    @ValueSource(strings = {"1:2:3", "1,2,3", "3:2,1", "3,2:1"})
    public void testDefaultDelimeter(String str) {
        assertEquals(6, StringCalculator.test(str));
    }

    @Test
    @DisplayName("공백을 줬을 경우 테스트")
    public void testEmptyValue() {
        assertEquals(0, StringCalculator.test(""));
    }
}