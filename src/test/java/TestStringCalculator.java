import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import static org.junit.jupiter.api.Assertions.*;


@DisplayName("문자열 계산기 단위 테스트")
public class TestStringCalculator {

    StringCalculator stringCalculator = new StringCalculator();

    @Nested
    @DisplayName("문자열 계산기 기능 테스트")
    class StringCalculatorFeatureTest {

        @Test
        @DisplayName("빈 문자열 케이스")
        void testEmptyString(){
            assertEquals(0, stringCalculator.addAll(""));
        }

        @Test
        @DisplayName("올바른 입력 케이스")
        void testValidInputs(){
            //기본 구분자 사용
            assertEquals(10,stringCalculator.addAll("1:2:3:4"));
            assertEquals(10,stringCalculator.addAll("1,2,3,4"));
            assertEquals(6,stringCalculator.addAll("1,2,3"));
            assertEquals(6,stringCalculator.addAll("1:2:3"));
            assertEquals(3,stringCalculator.addAll("1,2"));
            assertEquals(3,stringCalculator.addAll("1:2"));
            assertEquals(1,stringCalculator.addAll("1"));

            //커스텀 구분자 사용
            assertEquals(10,stringCalculator.addAll("//;\n1;2;3;4"));
            assertEquals(6,stringCalculator.addAll("//;\n1;2;3"));
            assertEquals(3,stringCalculator.addAll("//;\n1;2"));
            assertEquals(1,stringCalculator.addAll("//;\n1"));

            assertEquals(10,stringCalculator.addAll("//^\n1^2^3^4"));
            assertEquals(6,stringCalculator.addAll("//^\n1^2^3"));
            assertEquals(3,stringCalculator.addAll("//^\n1^2"));
            assertEquals(1,stringCalculator.addAll("//^\n1"));
        }

        @Test
        @DisplayName("RuntimeException 발생 케이스")
        void testRuntimeException() {
            //숫자 이외의 값
            assertThrows(RuntimeException.class, () -> stringCalculator.addAll("1,a,3"));
            assertThrows(RuntimeException.class, () -> stringCalculator.addAll("1:a:3"));
            assertThrows(RuntimeException.class, () -> stringCalculator.addAll("//^\n1^a^3"));

            //음수 입력 케이스
            assertThrows(RuntimeException.class, () -> stringCalculator.addAll("1,-2,3"));
            assertThrows(RuntimeException.class, () -> stringCalculator.addAll("1:-2:3"));
            assertThrows(RuntimeException.class, () -> stringCalculator.addAll("//^\n1^-2^3"));

            //잘못된 커스텀 지정자 구문
            assertThrows(RuntimeException.class, () -> stringCalculator.addAll("//;\t1;2;3"));
            assertThrows(RuntimeException.class, () -> stringCalculator.addAll("//;1;2;3"));
            assertThrows(RuntimeException.class, () -> stringCalculator.addAll("1^2^3"));
            assertThrows(RuntimeException.class, () -> stringCalculator.addAll("^\n1^2^3"));

        }
    }
}
