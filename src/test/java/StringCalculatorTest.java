import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
    @Nested
    class StringTest{
        @Test
        void default_delimiter_Test(){
            StringCalculator calc = new StringCalculator();
            assertEquals(3, calc.sum("1,2"));
            assertEquals(6, calc.sum("1,2,3"));

        }

        @Test
        void exceptionTest(){
            StringCalculator calc = new StringCalculator();
            assertEquals(3, calc.sum("1:2"));
        }

        @Test
        void custom_delimiter_Test(){
            StringCalculator calc = new StringCalculator();
            assertEquals(6, calc.sum("//;\n1;2;3"));
        }
    }
    //test 파일 더 작성하기 1. 커스텀 문자 다양하게 2. 숫자 다양하게 3. 에러 메세지 정상작동 검사
}
