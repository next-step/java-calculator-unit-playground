package function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Nested
    @DisplayName("입력관련 테스트")
    public class InputTest{

        @DisplayName("입력내용 저장 테스트")
        @Test
        void inputTest(){
            //given
            //when
            //then
        }

        @DisplayName("문자열 정수 변환 테스트")
        @Test
        void typeTest(){
            //given
            //when
            //then
        }
    }

    @Nested
    @DisplayName("계산기능 테스트")
    public class functionTest {

        @DisplayName("더하기 테스트")
        @Test
        void addTest(){
            //given
            int expectValue = 3;
            //when
            //then
            assertEquals(realValue, expectValue, "값이 일치합니다.");
        }

        @DisplayName("빼기 테스트")
        @Test
        void subTest(){
            //given
            int realValue = x - y;
            int expectValue = 1;
            //when
            //then
        }

        @DisplayName("나누기 테스트")
        @Test
        void divideTest(){
            //given
            int realValue = x / y;
            int expectValue = 2;
            //when

            //then
        }

        @DisplayName("곱하기 테스트")
        @Test
        void multipleTest(){
            //given
            int realValue = x * y;
            int expectValue = 2;

            //when
            //then
        }
    }
}
