package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class DelimitersTest {

    @Test
    @DisplayName("기본 구분자가 등록되어 있어야 한다")
    void shouldContainDefaultDelimiters() {
        Delimiters delimiters = new Delimiters();

        List<String> expected = List.of(",", ":");
        assertThat(delimiters.getDelimiters()).isEqualTo(expected);
    }

    @Test
    @DisplayName("커스텀 구분자를 추가할 수 있다")
    void shouldAddCustomDelimiter() {
        Delimiters delimiters = new Delimiters();
        delimiters.registerCustomDelimiter(";");

        List<String> expected = List.of(",", ":", ";");
        assertThat(delimiters.getDelimiters()).isEqualTo(expected);
    }

    @Test
    @DisplayName("null을 입력하면 예외가 발생한다")
    void shouldThrowExceptionWhenCustomDelimiterIsNull() {
        Delimiters delimiters = new Delimiters();
        assertThatThrownBy(() -> delimiters.registerCustomDelimiter(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 커스텀 구분자는 비어 있을 수 없습니다.");
    }

    @Test
    @DisplayName("빈 문자열을 입력하면 예외가 발생한다")
    void shouldThrowExceptionWhenCustomDelimiterIsBlank() {
        Delimiters delimiters = new Delimiters();
        assertThatThrownBy(() -> delimiters.registerCustomDelimiter(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 커스텀 구분자는 비어 있을 수 없습니다.");
    }

    @Test
    @DisplayName("이미 등록된 구분자를 추가하면 예외가 발생한다")
    void shouldThrowExceptionWhenCustomDelimiterIsDuplicate() {
        Delimiters delimiters = new Delimiters();
        delimiters.registerCustomDelimiter(";");

        assertThatThrownBy(() -> delimiters.registerCustomDelimiter(";"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이미 등록된 구분자입니다.");
    }
}
