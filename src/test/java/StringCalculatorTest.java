import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;

public class StringCalculatorTest {
    StringCalculator stringCalculator = new StringCalculator();

    @Nested
    @DisplayName("문자열 계산기 테스트")
    class StringCalculatorMethodTest {
        @Test
        @DisplayName("기본 구분자 연산 테스트")
        void 기본_구분자_연산_테스트() {
            Assertions.assertThat(stringCalculator.totalNumInString("1,1,2,2")).isEqualTo(6);
            Assertions.assertThat(stringCalculator.totalNumInString("10:21,4,5")).isEqualTo(40);
            Assertions.assertThat(stringCalculator.totalNumInString("1:1:1")).isEqualTo(3);
        }

        @Test
        @DisplayName("기본 구분자 예외 테스트")
        void 기본_구분자_예외_테스트() {
            Assertions.assertThatThrownBy(() -> stringCalculator.totalNumInString("a:b,c:"))
                    .isInstanceOf(RuntimeException.class);
            Assertions.assertThatThrownBy(() -> stringCalculator.totalNumInString("%010:1234:5678"))
                    .isInstanceOf(RuntimeException.class);
            Assertions.assertThatThrownBy(() -> stringCalculator.totalNumInString("1:2,-3:4"))
                    .isInstanceOf(RuntimeException.class);
        }

        @Test
        @DisplayName("커스텀 구분자 연산 테스트")
        void 커스텀_구분자_연산_테스트() {
            Assertions.assertThat(stringCalculator.totalNumInString("//-\n1-2-3-4-5-6-7")).isEqualTo(28);
            Assertions.assertThat(stringCalculator.totalNumInString("//!\n2!5")).isEqualTo(7);
            Assertions.assertThat(stringCalculator.totalNumInString("//@@\n10@@20@@30")).isEqualTo(60);
            Assertions.assertThat(stringCalculator.totalNumInString("//!@\n100!@200")).isEqualTo(300);
        }

        @Test
        @DisplayName("커스텀 구분자 예외 테스트")
        void 커스텀_구분자_예외_테스트() {
            Assertions.assertThatThrownBy(() -> stringCalculator.totalNumInString("//-1-2-3-4-5-6-7"))
                    .isInstanceOf(RuntimeException.class);
            Assertions.assertThatThrownBy(() -> stringCalculator.totalNumInString("@\n1@3@10"))
                    .isInstanceOf(RuntimeException.class);
            Assertions.assertThatThrownBy(() -> stringCalculator.totalNumInString("//%%\n3%8%2"))
                    .isInstanceOf(RuntimeException.class);
        }
    }
}
