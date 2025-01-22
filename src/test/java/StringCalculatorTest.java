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
            assertEquals(3, calc.sum("1,2"));
            assertEquals(6, calc.sum("1,2,3"));
            assertEquals(3, calc.sum("1:2"));
            assertEquals(38, calc.sum("1:2,3:4,5:6:7:10"));
            assertEquals(0, calc.sum(""));
        }

        @Test
        void custom_delimiter_Test(){
            StringCalculator calc = new StringCalculator();
            assertEquals(6, calc.sum("//;\n1;2;3"));
            assertEquals(5, calc.sum("//;;\n1;;1;;2;;1"));
            assertEquals(6, calc.sum("//.\n1.2.3"));
            assertEquals(3, calc.sum("//|\n1|2"));
            assertEquals(101, calc.sum("//?\n10?11?12?13?14?20?21"));
        }

        @Test
        void exceptionTest(){
            StringCalculator calc = new StringCalculator();

            RuntimeException exception = assertThrows(RuntimeException.class, () ->
                calc.sum("-1,2")
            );

            assertEquals("음수는 입력이 불가합니다.", exception.getMessage());
        }
    }

    //test 파일 더 작성하기 1. 커스텀 문자 다양하게 2. 숫자 다양하게 3. 에러 메세지 정상작동 검사, 빈문자 0 처리
}
