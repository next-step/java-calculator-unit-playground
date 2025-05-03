import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("문자열 계산 구현 테스트 ")
public class StringCalculateTest {
    StringCalculateClass stringCalculateClass = new StringCalculateClass();
    @Test
    @DisplayName("콤마를 구분자로 가진다")
    void addComma(){
        assertThat(stringCalculateClass.combineString("1,2,3")).isEqualTo(6);
    }

    @Test
    @DisplayName("쉼표를 구분자로 가진다")
    void addColons() {
        assertThat(stringCalculateClass.combineString("1;2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName("콤마,쉼표 동시에 구분자로 가진다")
    void addCommaAndColons() {
        assertThat(stringCalculateClass.combineString("1,2;3")).isEqualTo(6);
    }
    @Test
    @DisplayName("음수를 입력하면 예외를 던진다")
    void exceptionMinus(){
        assertThatThrownBy(() -> stringCalculateClass.combineString("-1"))
            .isInstanceOf(RuntimeException.class)
            .hasMessage("음수가 포함되었습니다");
    }

    @Test
    @DisplayName("숫자 아닌 값을 입력하면 예외를 던진다")
    void exceptionEng(){
        assertThatThrownBy(() -> stringCalculateClass.combineString("a"))
                .isInstanceOf(RuntimeException.class);
                //.hasMessage("오류");
                //콘솔 문자값 깨짐
    }
    @Test
    @DisplayName("null 입력이면 0을 반환한다")
    void nullInputReturnsZero() {
        assertThat(stringCalculateClass.combineString(null)).isEqualTo(0);
    }

    @Test
    @DisplayName("커스텀 구분자를 사용할 수 있다")
    void customDelimiter() {
        int result = stringCalculateClass.combineString("//;\n1;2");
        assertThat(result).isEqualTo(3);
    }


}
