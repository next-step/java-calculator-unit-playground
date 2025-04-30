package utils;

import domain.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("parser.NumberParser Test")
class NumberParserTest {

    @Test
    @DisplayName("정상 입력: 문자열을 정수로 변환하여 domain.Number 객체를 반환한다.")
    void parseValidInput() {
        Number number = NumberParser.parse("42");
        assertThat(number).isEqualTo(new Number(42));
    }

    @Test
    @DisplayName("비정상 입력: 숫자가 아닌 문자열 입력 시 예외를 발생시킨다.")
    void parseInvalidInput() {
        assertThatThrownBy(() -> NumberParser.parse("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
