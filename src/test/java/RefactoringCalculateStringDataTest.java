import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class RefactoringCalculateStringDataTest {
    @Test
    void singleNumberCaseAdd() {
        // 하나의 숫자만 입력한 경우
        assertThat(CalculateStringData.add("2025"))
                .as("하나의 숫자만 입력했다면 그 값 그대로 반환해야 해요")
                .isEqualTo(2025);
    }

    @Test
    void multipleNumbersCaseAdd() {
        // 쉼표 또는 콜론으로 구분된 여러 숫자일 굥유
        assertThat(CalculateStringData.add("1,2,3:4"))
                .as("쉼표 또는 콜론으로 구분된 숫자 합이 틀린 것 같아요")
                .isEqualTo(10);
    }

    @Test
    void customDelimiterCaseAdd() {
        // 커스텀 구분자를 사용한 경우
        assertThat(CalculateStringData.add("//;\n1;2;3"))
                .as("커스텀 구분자를 사용한 숫자 합이 틀린 것 같아요")
                .isEqualTo(6);

        assertThat(CalculateStringData.add("//!@\n1!@2!@3"))
                .as("커스텀 구분자를 사용한 숫자 합이 틀린 것 같아요")
                .isEqualTo(6);
    }

    @Test
    void negativeNumbersCaseAdd() {
        // 음수를 입력한 경우
        assertThatThrownBy(() -> CalculateStringData.add("1,-2,3"))
                .as("음수 입력 시 예외가 발생해야 해요")
                .isInstanceOf(RuntimeException.class)
                .hasMessage("음수는 사용하시면 안 돼요");
    }

    @Test
    void invalidDelimiterCaseAdd() {
        // 숫자가 아닌 값을 입력한 경우 예외 발생 확인
        assertThatThrownBy(() -> CalculateStringData.add("1,a,3"))
                .as("숫자가 아닌 값 입력 시 예외가 발생해야 해요")
                .isInstanceOf(RuntimeException.class)
                .hasMessage("숫자가 아닌 값이 포함되어 있는 것 같아요");
    }
}
