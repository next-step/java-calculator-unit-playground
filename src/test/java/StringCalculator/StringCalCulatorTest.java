package StringCalculator;

import StringCalculator.domain.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalCulatorTest {

    @Nested
    @DisplayName("연산 테스트")
    class CalculateTest {
        @Test
        @DisplayName("기존 구분자를 이용한 연산")
        void 기존_구분자_사용_연산() {
            int result = StringCalculator.stringCalculate("1,2:3");
            int expected = 6;

            assertThat(result).isEqualTo(expected);
        }

        @Test
        @DisplayName("커스텀 구분자를 이용한 연산")
        void 커스텀_구분자_사용_연산() {
            int result = StringCalculator.stringCalculate("//;\\n1;2,3:4");
            int expected = 10;

            assertThat(result).isEqualTo(expected);
        }

        @Nested
        @DisplayName("input 값 예외처리 테스트")
        class ValidateTest {
            @Test
            @DisplayName("공백 입력")
            void 공백_입력_시_throw() {
                assertThatThrownBy(() -> {
                    StringCalculator.stringCalculate("");
                }).isInstanceOf(RuntimeException.class);

            }

            @Test
            @DisplayName("음수 입력")
            void 음수_입력_시_throw() {
                assertThatThrownBy(() -> {
                    StringCalculator.stringCalculate("3,-1,2");
                }).isInstanceOf(RuntimeException.class);
            }

            @Test
            @DisplayName("맨 앞이 숫자가 아닌 식 입력")
            void 숫자가_아닐_시_throw() {
                assertThatThrownBy(() -> {
                    StringCalculator.stringCalculate("//1,2:3");
                }).isInstanceOf(RuntimeException.class);
            }

            @Test
            @DisplayName("지정되지 않은 구분자 입력")
            void 지정된_구분자가_아닐_시_throw() {
                assertThatThrownBy(() -> {
                    StringCalculator.stringCalculate("//?\n1?2:3,4]5");
                }).isInstanceOf(RuntimeException.class);
            }
        }
    }
}
