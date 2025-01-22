import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class String_calTest {

    @Nested
    @DisplayName("문자열 계산기 사칙연산 테스트")
    class CalTest {

        @Test
        void AddTest() {
            String_Calculator calc = new String_Calculator();
            assertEquals(6, calc.add("1,2;3"));
        }
        @Test
        void AddTest2() {
            String_Calculator calc = new String_Calculator();
            assertEquals(6, calc.add("//;\n1;2;3"));
        }

        @Test
        void SubTest() {
            String_Calculator calc = new String_Calculator();
            assertEquals(1, calc.sub("8,6;1"));
        }

        @Test
        void SubTest2() {
            String_Calculator calc = new String_Calculator();
            assertEquals(1, calc.sub("//;\n8,6;1"));
        }

        @Test
        void MulTest() {
            String_Calculator calc = new String_Calculator();
            assertEquals(6, calc.mul("1,2;3"));
        }

        @Test
        void MulTest2() {
            String_Calculator calc = new String_Calculator();
            assertEquals(6, calc.mul("//;\n1,2;3"));
        }

        @Test
        void DivTest() {
            String_Calculator calc = new String_Calculator();
            assertEquals(2, calc.div("12,2;3"));
        }

        @Test
        void DivTest2() {
            String_Calculator calc = new String_Calculator();
            assertEquals(2, calc.div("//;\n12,2;3"));
        }

    }
}
