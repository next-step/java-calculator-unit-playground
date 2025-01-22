import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

public class StringCal_AssertJTest {
    @Nested
    @DisplayName("문자열 계산기 사칙연산 테스트")
    class AssertJ_CalTest {

        @Test
        void AddTest() {
            String_Calculator calc = new String_Calculator();
            assertThat(7).isEqualTo(calc.add("3,4"));
        }
        @Test
        void AddTest2() {
            String_Calculator calc = new String_Calculator();
            assertThat(6).isNotEqualTo(calc.add("//;\n1;2;4"));
        }

        @Test
        void SubTest() {
            String_Calculator calc = new String_Calculator();
            assertThat(6).isEqualTo(calc.add("1;2;3"));
        }

        @Test
        void SubTest2() {
            String_Calculator calc = new String_Calculator();
            assertThat(6).isNotEqualTo(calc.sub("//;\n8,6;1"));
        }

        @Test
        void MulTest() {
            String_Calculator calc = new String_Calculator();
            assertThat(6).isEqualTo(calc.mul("2;3;1"));
        }

        @Test
        void MulTest2() {
            String_Calculator calc = new String_Calculator();
            assertThat(6).isNotEqualTo(calc.mul("//;\n8;6;1"));
        }

        @Test
        void DivTest() {
            String_Calculator calc = new String_Calculator();
            assertThat(1).isEqualTo(calc.div("10;2;5"));
        }

        @Test
        void DivTest2() {
            String_Calculator calc = new String_Calculator();
            assertThat(6).isNotEqualTo(calc.div("//;\n10;2;5"));
        }

    }
}
