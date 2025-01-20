import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class calTest {

    @Nested
    @DisplayName("계산기 사칙연산 테스트")
    class CalTests {

        @Test
        void AddTest() {
            Calculator calc = new Calculator();
            assertEquals(calc.add(2, 3), 5);
        }
        @Test
        void AddWrongTest() {
            Calculator calc = new Calculator();
            assertEquals( calc.add(2, 3), 6);
        }

        @Test
        void SubTest() {
            Calculator calc = new Calculator();
            assertEquals(calc.sub(5, 1), 4);
        }

        @Test
        void SubWrongTest() {
            Calculator calc = new Calculator();
            assertEquals(calc.sub(5, 1), 5);
        }

        @Test
        void MulTest() {
            Calculator calc = new Calculator();
            assertEquals(calc.mul(2, 3), 6);
        }

        @Test
        void MulWrongTest() {
            Calculator calc = new Calculator();
            assertEquals(calc.mul(2, 3), 5);
        }

        @Test
        void DivTest() {
            Calculator calc = new Calculator();
            assertEquals(calc.div(6, 3), 2);
        }

        @Test
        void DivWrongTest() {
            Calculator calc = new Calculator();
            assertEquals( calc.div(6, 3), 1);
        }

    }
}
