package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class NumberTokensTest {

    @Test
    @DisplayName("숫자 문자열 리스트를 합산한다")
    void sumNumbers_success() {
        // given
        List<String> tokens = List.of("1", "2", "3");

        // when
        NumberTokens numberTokens = new NumberTokens(tokens);

        // then
        assertEquals(6, numberTokens.sum());
    }

    @Test
    @DisplayName("음수가 포함된 경우 예외를 던진다")
    void throwException_whenNegativeNumberExists() {
        // given
        List<String> tokens = List.of("1", "-2", "3");

        // when & then
        assertThrows(IllegalArgumentException.class, () -> new NumberTokens(tokens));
    }

    @Test
    @DisplayName("빈 리스트가 주어지면 합은 0이다")
    void sumZero_whenEmptyList() {
        // given
        List<String> tokens = List.of();

        // when
        NumberTokens numberTokens = new NumberTokens(tokens);

        // then
        assertEquals(0, numberTokens.sum());
    }
}
