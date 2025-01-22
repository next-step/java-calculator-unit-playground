import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class TestWithAssertJ {
    @Nested
    class CalculatorTest{
        @Test
        void simpleCalcTest(){
            SimpleCalculator calc = new SimpleCalculator();
        }

        @Test
        void stringCalcTest(){

        }
    }
}
1