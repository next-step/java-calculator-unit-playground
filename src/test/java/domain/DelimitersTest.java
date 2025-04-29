package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class DelimitersTest {

    @Test
    @DisplayName("기본 구분자가 등록되어 있어야 한다")
    void 기본구분자등록_검증() {
        Delimiters delimiters = new Delimiters();

        List<String> expected = List.of(",", ":");
        assertEquals(expected, delimiters.getDelimiters());
    }

    @Test
    @DisplayName("커스텀 구분자를 추가할 수 있다")
    void 커스텀구분자_추가() {
        Delimiters delimiters = new Delimiters();
        delimiters.addCustomDelimiters(";");

        List<String> expected = List.of(",", ":", ";");
        assertEquals(expected, delimiters.getDelimiters());
    }

    @Test
    @DisplayName("null 또는 빈 문자열을 추가해도 구분자가 추가되지 않는다")
    void 커스텀구분자_null또는빈문자열() {
        Delimiters delimiters = new Delimiters();
        delimiters.addCustomDelimiters(null);
        delimiters.addCustomDelimiters("");

        List<String> expected = List.of(",", ":");
        assertEquals(expected, delimiters.getDelimiters());
    }
}
