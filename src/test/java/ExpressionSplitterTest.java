import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExpressionSplitterTest {

    @Test
    @DisplayName("기본 구분자(쉼표, 콜론)로 문자열을 분리한다")
    void 기본구분자_분리() {
        // given
        Delimiters delimiters = new Delimiters();
        ExpressionSplitter splitter = new ExpressionSplitter(delimiters);
        String expression = "1,2:3";

        // when
        String[] result = splitter.split(expression);

        // then
        assertArrayEquals(new String[]{"1", "2", "3"}, result);
    }

    @Test
    @DisplayName("커스텀 구분자가 추가된 경우 문자열을 분리한다")
    void 커스텀구분자_추가후_분리() {
        // given
        Delimiters delimiters = new Delimiters();
        delimiters.addCustomDelimiters(";");
        ExpressionSplitter splitter = new ExpressionSplitter(delimiters);
        String expression = "1;2,3:4";

        // when
        String[] result = splitter.split(expression);

        // then
        assertArrayEquals(new String[]{"1", "2", "3", "4"}, result);
    }

    @Test
    @DisplayName("빈 문자열을 분리하면 빈 배열을 반환한다")
    void 빈문자열_분리() {
        // given
        Delimiters delimiters = new Delimiters();
        ExpressionSplitter splitter = new ExpressionSplitter(delimiters);
        String expression = "";

        // when
        String[] result = splitter.split(expression);

        // then
        assertArrayEquals(new String[]{""}, result);
    }
}
