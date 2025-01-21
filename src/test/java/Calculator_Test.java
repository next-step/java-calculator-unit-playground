import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Calculator_Test {
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
        void divTest2(){
            Calculator_Simple cal = new Calculator_Simple();
            assertEquals(21, cal.div(3234, 153));
        }
    }
}
