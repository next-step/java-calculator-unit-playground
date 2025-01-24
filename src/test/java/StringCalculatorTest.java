import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
    @Nested
    class StringTest{
        @Test
        void default_delimiter_Test(){
            StringCalculator calc = new StringCalculator();
            assertEquals(3, calc.calculate("1,2"));
            assertEquals(6, calc.calculate("1,2,3"));
            assertEquals(3, calc.calculate("1:2"));
            assertEquals(38, calc.calculate("1:2,3:4,5:6:7:10"));
            assertEquals(0, calc.calculate(""));
        }

        @Test
        void custom_delimiter_Test(){
            StringCalculator calc = new StringCalculator();
            assertEquals(6, calc.calculate("//;\n1;2;3"));
            assertEquals(5, calc.calculate("//;;\n1;;1;;2;;1"));
            assertEquals(6, calc.calculate("//.\n1.2.3"));
            assertEquals(3, calc.calculate("//|\n1|2"));
            assertEquals(101, calc.calculate("//?\n10?11?12?13?14?20?21"));
        }

        @Test
        void exceptionTest(){
            StringCalculator calc = new StringCalculator();

            RuntimeException exception = assertThrows(RuntimeException.class, () ->
                calc.calculate("-1,2")
            );

            assertEquals("음수는 입력이 불가합니다.", exception.getMessage());

            RuntimeException exception2 = assertThrows(RuntimeException.class, () ->
                    calc.calculate("2147483647,10")
            );

            assertEquals("int 범위를 벗어났습니다.", exception2.getMessage());
        }
    }
}
