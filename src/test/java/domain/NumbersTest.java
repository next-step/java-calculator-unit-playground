package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class NumbersTest {

    @Test
    @DisplayName("숫자 문자열 리스트를 합산한다")
    void sumNumbers_success() {
        // given
        List<String> tokens = List.of("1", "2", "3");

        // when
        Numbers numbers = new Numbers(tokens);

        // then
        assertThat(6).isEqualTo(numbers.sum());
    }

    @Test
    @DisplayName("음수가 포함된 경우 예외를 던진다")
    void throwException_whenNegativeNumberExists() {
        // given
        List<String> tokens = List.of("1", "-2", "3");

        // when & then
        assertThatThrownBy(() -> new Numbers(tokens))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("빈 리스트가 주어지면 합은 0이다")
    void sumZero_whenEmptyList() {
        // given
        List<String> tokens = List.of();

        // when
        Numbers numbers = new Numbers(tokens);

        // then
        assertThat(0).isEqualTo(numbers.sum());
    }
}
