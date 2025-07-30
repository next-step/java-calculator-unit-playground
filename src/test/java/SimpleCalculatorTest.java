import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleCalculatorTest {
    @Nested
    class SimpleTest {

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

    @Nested
    class CalculatorTest{
        @Test
        void simpleCalcTest(){
            SimpleCalculator calc = new SimpleCalculator();
            assertThat(calc.add(1, 2)).isEqualTo(3);
            assertThat(calc.minus(1,2)).isEqualTo(-1);
            assertThat(calc.divide(4, 2)).isEqualTo(2);
            assertThat(calc.multiply(3,2)).isEqualTo(6);
        }
    }
}
