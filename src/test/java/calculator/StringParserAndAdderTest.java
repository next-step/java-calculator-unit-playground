package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringParserAndAdderTest {

    @DisplayName("빈 값을 받았을때 0을 출력한다.")
    @Test
    void Test0() {
        StringParserAndAdder stringParserAndAdder = new StringParserAndAdder();
        int result = stringParserAndAdder.solver("");

        assertThat(result).isEqualTo(0);
    }
    @DisplayName("쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.")
    @Test
    void Test1() {
        StringParserAndAdder stringParserAndAdder = new StringParserAndAdder();
        int result = stringParserAndAdder.solver("5,1:4");

        assertThat(result).isEqualTo(10);
    }

    @DisplayName("커스텀 구분자를 가지는 문자열을 전달하는 경우")
    @Test
    void Test2() {
        StringParserAndAdder stringParserAndAdder = new StringParserAndAdder();
        int result = stringParserAndAdder.solver("//;\n3;1;4");

        assertThat(result).isEqualTo(8);
    }

    @DisplayName("음수를 전달하는 경우 RuntimeException 예외를 Throw한다.")
    @Test
    void testNegativeNumberException() {
        StringParserAndAdder stringParserAndAdder = new StringParserAndAdder();

        assertThatThrownBy(() -> stringParserAndAdder.solver("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("숫자 이외의 값을 전달하는 경우 RuntimeException 예외를 Throw한다.")
    @Test
    void testNonNumericException() {
        StringParserAndAdder stringParserAndAdder = new StringParserAndAdder();

        assertThatThrownBy(() -> stringParserAndAdder.solver("1,a,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
