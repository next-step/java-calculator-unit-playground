import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Cal_Test1 {

    @Nested
    @DisplayName("계산기 사칙연산 테스트")
    class CalTest {

        @Test
        void AddTest() {
            Calculator calc = new Calculator();
            assertEquals(3, calc.add(1,2));
        }

        @Test
        void SubTest() {
            Calculator calc = new Calculator();
            assertEquals(2, calc.sub(8,6));
        }

        @Test
        void MulTest() {
            Calculator calc = new Calculator();
            assertEquals(2, calc.mul(1,2));
        }

        @Test
        void DivTest() {
            Calculator calc = new Calculator();
            assertEquals(6, calc.div(12,2));
        }

    }
}
