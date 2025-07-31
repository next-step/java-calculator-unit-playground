import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    private final StringCalculator calc = new StringCalculator();

    @Nested
    class StringTest{

        @Test
        void defaultDelimiterTest(){
            assertEquals(3, calc.calculate("1,2"));
            assertEquals(6, calc.calculate("1,2,3"));
            assertEquals(3, calc.calculate("1:2"));
            assertEquals(38, calc.calculate("1:2,3:4,5:6:7:10"));
        }

        @Test
        void customDelimiterTest(){
            assertEquals(6, calc.calculate("//;\n1;2;3"));
            assertEquals(5, calc.calculate("//;;\n1;;1;;2;;1"));
            assertEquals(6, calc.calculate("//.\n1.2.3"));
            assertEquals(3, calc.calculate("//|\n1|2"));
            assertEquals(101, calc.calculate("//?\n10?11?12?13?14?20?21"));
        }

        @Test
        void exceptionTest(){
            assertThatThrownBy(() -> calc.calculate("-1,2")).isInstanceOf(RuntimeException.class);
            assertThatThrownBy(() -> calc.calculate("2147483647,10")).isInstanceOf(RuntimeException.class);
            assertThatThrownBy(() -> calc.calculate("hello")).isInstanceOf(RuntimeException.class);
        }

        @Test
        void blankTest(){
            assertEquals(0, calc.calculate(""));
            assertThatThrownBy(() -> calc.calculate(" ")).isInstanceOf(RuntimeException.class);
        }
    }
}
