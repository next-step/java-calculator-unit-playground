import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("문자열 계산 구현 테스트 ")
public class StringCalculateTest {
    StringCalculateClass stringCalculateClass = new StringCalculateClass();
    @Test
    @DisplayName("콤마를 구분자로 가진다")
    void addComma(){
        assertEquals(6,stringCalculateClass.combineString("1,2,3"));
    }

    @Test
    @DisplayName("쉼표를 구분자로 가진다")
    void addColons() {
        assertEquals(6,stringCalculateClass.combineString("1;2;3"));
    }

    @Test
    @DisplayName("콤마,쉼표 동시에 구분자로 가진다")
    void addCommaAndColons() {
        assertEquals(6,stringCalculateClass.combineString("1,2;3"));
    }
    @Test
    @DisplayName("음수를 입력하면 예외를 던진다")
    void exceptionMinus(){
        assertThrows(RuntimeException.class, () -> {
            stringCalculateClass.combineString("-1");
        });
    }

    @Test
    @DisplayName("숫자 아닌 값을 입력하면 예외를 던진다")
    void exceptionEng(){
        assertThrows(RuntimeException.class, () -> {
            stringCalculateClass.combineString("a");
        });
    }


}
