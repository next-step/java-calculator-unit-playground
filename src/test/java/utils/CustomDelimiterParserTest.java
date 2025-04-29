package utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomDelimiterParserTest {

    private final CustomDelimiterParser parser = new CustomDelimiterParser();

    @Test
    @DisplayName("문자열이 커스텀 구분자 형식을 가지면 true를 반환한다")
    void hasCustomDelimiter_true() {
        String expression = "//;\n1;2;3";

        assertTrue(parser.hasCustomDelimiter(expression));
    }

    @Test
    @DisplayName("문자열이 커스텀 구분자 형식을 가지지 않으면 false를 반환한다")
    void hasCustomDelimiter_false() {
        String expression = "1,2:3";

        assertFalse(parser.hasCustomDelimiter(expression));
    }

    @Test
    @DisplayName("커스텀 구분자를 정상적으로 파싱한다")
    void parseCustomDelimiter_success() {
        String expression = "//;\n1;2;3";

        String customDelimiter = parser.parseCustomDelimiter(expression);

        assertEquals(";", customDelimiter);
    }

    @Test
    @DisplayName("커스텀 구분자 파싱 시 형식이 잘못되면 예외를 던진다")
    void parseCustomDelimiter_invalidFormat() {
        String invalidExpression = "//;1;2;3";

        assertThrows(IllegalArgumentException.class, () -> parser.parseCustomDelimiter(invalidExpression));
    }

    @Test
    @DisplayName("숫자 문자열을 정상적으로 파싱한다")
    void parseNumbersExpression_success() {
        String expression = "//;\n1;2;3";

        String numbers = parser.parseNumbersExpression(expression);

        assertEquals("1;2;3", numbers);
    }
}
