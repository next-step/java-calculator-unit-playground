import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculateStringDataTest {
    @Test
    void singleNumberCaseAdd() {
        // 하나의 숫자만 입력한 경우
        assertEquals(2025, CalculateStringData.add("2025"), "하나의 숫자만 입력했다면 그 값 그대로 반환해야 해요");
    }

    @Test
    void multipleNumbersCaseAdd() {
        // 쉼표 또는 콜론으로 구분된 여러 숫자일 경우
        assertEquals(9, CalculateStringData.add("2,0,2:5"), "쉼표 또는 콜론으로 구분된 숫자 합이 틀린 것 같아요");
    }

    @Test
    void customDelimiterCaseAdd() {
        // 커스텀 구분자를 사용한 경우
        assertEquals(6, CalculateStringData.add("//;\n1;2;3"), "커스텀 구분자를 사용한 숫자 합이 틀린 것 같아요");
        assertEquals(6, CalculateStringData.add("//!@\n1!@2!@3"), "커스텀 구분자를 사용한 숫자 합이 틀린 것 같아요");
    }

    @Test
    void negativeNumbersCaseAdd() {
        // 음수를 입력한 경우
        RuntimeException exception = assertThrows(RuntimeException.class, () -> CalculateStringData.add("1,-2,3"),
                "음수 입력 시 예외가 발생해야 해요");
        assertEquals("음수는 사용하시면 안 돼요", exception.getMessage());
    }

    @Test
    void invalidDelimiterCaseAdd() {
        // 숫자가 아닌 값을 입력한 경우 예외 발생 확인
        RuntimeException exception = assertThrows(RuntimeException.class, () -> CalculateStringData.add("1,a,3"),
                "숫자가 아닌 값 입력 시 예외가 발생해야 해요");
        assertEquals("숫자가 아닌 값이 포함되어 있는 것 같아요", exception.getMessage());
    }
}
