import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class calTest {

    @Nested
    @DisplayName("계산기 사칙연산 테스트")
    class CalTest {

        @Test
        void AddTest() {
            Calculator calc = new Calculator();
            assertEquals(6, calc.add("1,2;3"));
        }
        @Test
        void AddTest2() {
            Calculator calc = new Calculator();
            assertEquals(6, calc.add("//;\n1;2;3"));
        }

        @Test
        void SubTest() {
            Calculator calc = new Calculator();
            assertEquals(1, calc.sub("8,6;1"));
        }

        @Test
        void SubTest2() {
            Calculator calc = new Calculator();
            assertEquals(1, calc.sub("//;\n8,6;1"));
        }

        @Test
        void MulTest() {
            Calculator calc = new Calculator();
            assertEquals(6, calc.mul("1,2;3"));
        }

        @Test
        void MulTest2() {
            Calculator calc = new Calculator();
            assertEquals(6, calc.mul("//;\n1,2;3"));
        }

        @Test
        void DivTest() {
            Calculator calc = new Calculator();
            assertEquals(2, calc.div("12,2;3"));
        }

        @Test
        void DivTest2() {
            Calculator calc = new Calculator();
            assertEquals(2, calc.div("//;\n12,2;3"));
        }

    }
}
