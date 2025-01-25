import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @Nested
    @DisplayName("Simple Calculator")
    class Calculator_Simple_Test {
        @Test
        void addTest1() {
            Calculator_Simple cal = new Calculator_Simple();
            assertEquals(3, cal.add(1, 2));
        }

        @Test
        void addTest2(){
            Calculator_Simple cal = new Calculator_Simple();
            assertEquals(12, cal.add(3, 9));
        }

        @Test
        void subTest1() {
            Calculator_Simple cal = new Calculator_Simple();
            assertEquals(2, cal.sub(4, 2));
        }

        @Test
        void subTest2(){
            Calculator_Simple cal = new Calculator_Simple();
            assertEquals(171, cal.sub(324, 153));
        }

        @Test
        void mulTest1() {
            Calculator_Simple cal = new Calculator_Simple();
            assertEquals(8, cal.mul(4, 2));
        }

        @Test
        void mulTest2(){
            Calculator_Simple cal = new Calculator_Simple();
            assertEquals(49572, cal.mul(324, 153));
        }

        @Test
        void divTest1() {
            Calculator_Simple cal = new Calculator_Simple();
            assertEquals(2, cal.div(4, 2));
        }

        @Test
        void divTest2() {
            Calculator_Simple cal = new Calculator_Simple();
            assertEquals(21, cal.div(3234, 153));
        }
    }
    @Nested
    @DisplayName("String Calculator")
    class String_Calculator_Test {

        @Test
        void testEmpty(){
            assertEquals(0, Calculator.sum(""));
        }

        @Test
        void testOne(){
            assertEquals(1, Calculator.sum("1"));
        }

        @Test
        void testTwo(){
            assertEquals(3, Calculator.sum("1,2"));
        }

        @Test
        void testThree(){
            assertEquals(6, Calculator.sum("1,2,3"));
        }

        @Test
        void testCustom() {
            assertEquals(6, Calculator.sum("//;\n1;2;3"));
        }

        @Test
        void testNegativeNumber(){
            RuntimeException thrown = assertThrows(RuntimeException.class, () -> Calculator.sum("1,-2,3"));
            assertTrue(thrown.getMessage().contains("음수가 입력되었습니다"));
        }

        @Test
        void testInvalidNumber(){
            RuntimeException thrown = assertThrows(RuntimeException.class, () -> Calculator.sum("1,a,3"));
            assertTrue(thrown.getMessage().contains("유효하지 않은"));
        }
    }
}
