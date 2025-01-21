import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleCalculatorTest {
    @Nested
    class SimpleSimpleCalculatorTest {
        @Test
        void addTest(){
            SimpleCalculator calc = new SimpleCalculator();
            assertEquals(3, calc.add(1, 2));
            assertEquals(5, calc.add(3, 2));
        }
        @Test
        void minusTest(){
            SimpleCalculator calc = new SimpleCalculator();
            assertEquals(3, calc.minus(5, 2));
            assertEquals(-2, calc.minus(3, 5));
        }
        @Test
        void multiply(){
            SimpleCalculator calc = new SimpleCalculator();
            assertEquals(10, calc.multiply(5, 2));
            assertEquals(15, calc.multiply(3, 5));
        }
        @Test
        void divide(){
            SimpleCalculator calc = new SimpleCalculator();
            assertEquals(5, calc.divide(10, 2));
            assertEquals(30, calc.divide(180, 6));
        }
    }
}
