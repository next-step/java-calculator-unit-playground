import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringCalculatorTest {
    private final StringCalculator sc = new StringCalculator();

    @Nested
    @DisplayName("올바르게 입력한 경우 테스트")
    class ExpectedInput {
        @Test
        @DisplayName("아무것도 입력하지 않은 경우")
        void noInput() {
            assertThat(0).isEqualTo(sc.add(""));
        }

        @Test
        @DisplayName(", 로만 구분한 경우")
        void delimiterOnlyComma() {
            assertThat(6).isEqualTo(sc.add("1,2,3"));
        }

        @Test
        @DisplayName(": 로만 구분한 경우")
        void delimiterOnlyColon() {
            assertThat(6).isEqualTo(sc.add("1:2:3"));
        }

        @Test
        @DisplayName(", 와 : 를 섞은 경우")
        void delimiterComplex() {
            assertThat(6).isEqualTo(sc.add("1,2:3"));
        }

        @Test
        @DisplayName("커스텀 구분자를 사용한 경우")
        void delimeterCustom() {
            assertThat(6).isEqualTo(sc.add("//;\n1;2;3;"));
        }
    }

    @Nested
    @DisplayName("입력이 올바르지 못한 경우 테스트")
    class UnexpectedInput {
        @Test
        @DisplayName("입력값으로 null이 들어온 경우")
        void invalidInputNull() {
            assertThat(0).isEqualTo(sc.add(null));
        }

        @Test
        @DisplayName("음수를 입력한 경우 올바른 예외가 발생하는지 확인")
        void invalidInputNegativeNumber() {
            assertThatThrownBy(() -> {
                sc.add("-1:2:3");
            }).isInstanceOf(RuntimeException.class)
                    .hasMessage("음수는 입력할 수 없습니다");
        }

        @Test
        @DisplayName("숫자가 아닌 다른 것을 입력한 경우 올바른 예외가 발생하는지 확인")
        void invalidInputNotNumber() {
            assertThatThrownBy(() -> {
                sc.add("2~3*9");
            }).isInstanceOf(RuntimeException.class)
                    .hasMessage("숫자만 입력해 주세요");
        }

    }
}
