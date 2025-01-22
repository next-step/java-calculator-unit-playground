import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWithAssertJ {
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

        @Test
        void stringCalcTest(){
            StringCalculator calc = new StringCalculator();
            assertThat(calc.sum("//;\n1;2;3")).isEqualTo(6);
            assertThat(calc.sum("//?\n10?11?12?13?14?20?21")).isEqualTo(101);
        }

        @Test
        void exceptionTest(){
            StringCalculator calc = new StringCalculator();
            assertThatThrownBy(() ->
                calc.sum("-1,2")).isInstanceOf(RuntimeException.class);

            assertThatThrownBy(() -> calc.sum("//:123")).isInstanceOf(RuntimeException.class);
        }
    }
}
