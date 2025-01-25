import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import static org.assertj.core.api.Assertions.*;

public class TestStringCalculatorAssertJ {
    StringCalculator sc = new StringCalculator();

    @Nested
    @DisplayName("문자열 계산기 기능 테스트 (AssertJ)")
    class StringCalculatorFeatureTestAssertJ {

        @Test
        @DisplayName("빈 문자열 케이스")
        void testEmptyString(){
            //assertEquals(0, sc.addAll(""));
            assertThat(0).isEqualTo(sc.addAll(""));
        }

        @Test
        @DisplayName("올바른 입력 케이스")
        void testValidInputs(){
            //기본 구분자 사용
            /*
            assertEquals(10,sc.addAll("1:2:3:4"));
            assertEquals(10,sc.addAll("1,2,3,4"));
            assertEquals(6,sc.addAll("1,2,3"));
            assertEquals(6,sc.addAll("1:2:3"));
            assertEquals(3,sc.addAll("1,2"));
            assertEquals(3,sc.addAll("1:2"));
            assertEquals(1,sc.addAll("1"));
             */
            assertThat(10).isEqualTo(sc.addAll("1:2:3:4"));
            assertThat(10).isEqualTo(sc.addAll("1,2,3,4"));
            assertThat(6).isEqualTo(sc.addAll("1,2,3"));
            assertThat(6).isEqualTo(sc.addAll("1:2:3"));
            assertThat(3).isEqualTo(sc.addAll("1,2"));
            assertThat(3).isEqualTo(sc.addAll("1:2"));
            assertThat(1).isEqualTo(sc.addAll("1"));

            //커스텀 구분자 사용
            assertThat(10).isEqualTo(sc.addAll("//;\n1;2;3;4"));
            assertThat(6).isEqualTo(sc.addAll("//;\n1;2;3"));
            assertThat(3).isEqualTo(sc.addAll("//;\n1;2"));
            assertThat(1).isEqualTo(sc.addAll("//;\n1"));

            assertThat(10).isEqualTo(sc.addAll("//^\n1^2^3^4"));
            assertThat(6).isEqualTo(sc.addAll("//^\n1^2^3"));
            assertThat(3).isEqualTo(sc.addAll("//^\n1^2"));
            assertThat(1).isEqualTo(sc.addAll("//^\n1"));
        }

        @Test
        @DisplayName("RuntimeException 발생 케이스")
        void testRuntimeException() {
            //숫자 이외의 값
            assertThatThrownBy(() -> sc.addAll("1,a,3")).isInstanceOf(RuntimeException.class).hasMessage("숫자 이외의 값이 입력되었습니다.");
            assertThatThrownBy(() -> sc.addAll("1:a:3")).isInstanceOf(RuntimeException.class).hasMessage("숫자 이외의 값이 입력되었습니다.");
            assertThatThrownBy(() -> sc.addAll("//^\n1^a^3")).isInstanceOf(RuntimeException.class).hasMessage("숫자 이외의 값이 입력되었습니다.");

            //음수 입력 케이스
            assertThatThrownBy(() -> sc.addAll("1,-2,3")).isInstanceOf(RuntimeException.class).hasMessage("음수가 입력되었습니다.");
            assertThatThrownBy(() -> sc.addAll("1:-2:3")).isInstanceOf(RuntimeException.class).hasMessage("음수가 입력되었습니다.");
            assertThatThrownBy(() -> sc.addAll("//^\n1^-2^3")).isInstanceOf(RuntimeException.class).hasMessage("음수가 입력되었습니다.");

            //잘못된 커스텀 지정자 구문
            assertThatThrownBy(() -> sc.addAll("//;\t1;2;3")).isInstanceOf(RuntimeException.class).hasMessage("올바르지 않은 커스텀 구분자 지정 구문입니다.");
            assertThatThrownBy(() -> sc.addAll("//;1;2;3")).isInstanceOf(RuntimeException.class).hasMessage("올바르지 않은 커스텀 구분자 지정 구문입니다.");
            assertThatThrownBy(() -> sc.addAll("1^2^3")).isInstanceOf(RuntimeException.class).hasMessage("올바르지 않은 커스텀 구분자 지정 구문입니다.");
            assertThatThrownBy(() -> sc.addAll("^\n1^2^3")).isInstanceOf(RuntimeException.class).hasMessage("올바르지 않은 커스텀 구분자 지정 구문입니다.");

        }
    }
}
