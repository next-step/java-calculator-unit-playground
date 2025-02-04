import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private final Calculator calc = new Calculator();

    @Nested
    @DisplayName("더하기_테스트_코드")
    class AddTest{
        @Test
        @DisplayName("더하기_테스트_case1:1+2")
        void add(){
            assertEquals(3, calc.add(1,2),"더하기(+)_테스트_통과!");
        }
    }

    @Nested
    @DisplayName("빼기_테스트_코드")
    class SubtractTest{
        @Test
        @DisplayName("빼기_테스트_case1:2-1")
        void subtract(){
            assertEquals(1, calc.subtract(2,1),"빼기(-)_테스트_통과!");
        }
    }

    @Nested
    @DisplayName("곱하기_테스트_코드")
    class MultiplyTest{
        @Test
        @DisplayName("곱하기_테스트_case1:3*4")
        void multiply(){
            assertEquals(12, calc.multiply(3,4),"곱하기(*)_테스트_통과!");
        }
    }

    @Nested
    @DisplayName("나누기_테스트_코드")
    class DivideTest{
        @Test
        @DisplayName("나누기_테스트_case1:2/1")
        void divide(){
            assertEquals(2, calc.divide(2,1),"나누기(/)_테스트_통과!");
        }

        @Test
        @DisplayName("나누기_테스트_case2:0을_이용한_나눗셈")
        void divideWithZero(){
            assertThrows(ArithmeticException.class, () -> calc.divide(2,0),"나누기(/)_테스트(0을_이용한_나눗셈)통과!");
        }
    }
}
