package utils;

import static org.assertj.core.api.Assertions.*;

import domain.Delimiters;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class ExpressionSplitterTest {

    @Test
    @DisplayName("기본 구분자(쉼표, 콜론)로 문자열을 분리한다")
    void splitByDefaultDelimiters() {
        // given
        Delimiters delimiters = new Delimiters();
        ExpressionSplitter splitter = new ExpressionSplitter(delimiters);
        String expression = "1,2:3";

        // when
        List<String> result = splitter.split(expression);

        // then
        assertThat(result).isEqualTo(List.of("1", "2", "3"));
    }

    @Test
    @DisplayName("커스텀 구분자가 추가된 경우 문자열을 분리한다")
    void splitByCustomDelimiter() {
        // given
        Delimiters delimiters = new Delimiters();
        delimiters.addCustomDelimiters(";");
        ExpressionSplitter splitter = new ExpressionSplitter(delimiters);
        String expression = "1;2,3:4";

        // when
        List<String> result = splitter.split(expression);

        // then
        assertThat(result).isEqualTo(List.of("1", "2", "3", "4"));
    }

    @Test
    @DisplayName("빈 문자열을 분리하면 빈 리스트를 반환한다")
    void splitEmptyString() {
        // given
        Delimiters delimiters = new Delimiters();
        ExpressionSplitter splitter = new ExpressionSplitter(delimiters);
        String expression = "";

        // when
        List<String> result = splitter.split(expression);

        // then
        assertThat(result).isEqualTo(List.of(""));
    }
}