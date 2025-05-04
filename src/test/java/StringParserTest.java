import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class StringParserTest {
    @Test
    @DisplayName("기본 구분자(쉼표와 콜론)로 문자열을 나눈다")
    void parseWithDefaultSeparator() {
        assertThat(StringParser.parse("1,2:3")).containsExactly("1","2","3");
    }

    @Test
    @DisplayName("커스텀 구분자에 대한 테스트를 수행한다")
    void parseWithCustomSeparator(){
        assertThat(StringParser.parse("//;\n1;2;3")).containsExactly("1","2","3");
    }

    @Test
    @DisplayName("길이가 하나인 문자열은 그대로 반환한다")
    void stringlengthIsOne(){
        assertThat(StringParser.parse("1")).containsExactly("1");
    }

    @Test
    @DisplayName("빈 문자열이면 빈 배열을 반환한다")
    void emptyStringResultEmptyArray(){
        assertThat(StringParser.parse("")).isEmpty();
    }
}
