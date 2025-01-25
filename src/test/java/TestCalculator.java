import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import static org.junit.jupiter.api.Assertions.*;


@DisplayName("초간단 계산기 단위 테스트")
public class TestCalculator {

    Calculator calculator = new Calculator();

    @Nested
    @DisplayName("초간단 계산기 기능별 단위 테스트")
    class CalculateFeatureTest {
        @Test
        @DisplayName("덧셈 테스트")
        void testAdd(){
            assertEquals(5, calculator.add(2 ,3));
            assertEquals(8, calculator.add(-2 ,10));
            assertEquals(-4,calculator.add(6,-10));
            assertEquals(-10, calculator.add(-4,-6));
        }

        @Test
        @DisplayName("뺄셈 테스트")
        void testSub(){
            assertEquals(-1, calculator.sub(2 ,3));
            assertEquals(-12, calculator.sub(-2 ,10));
            assertEquals(16,calculator.sub(6,-10));
            assertEquals(2, calculator.sub(-4,-6));
        }

        @Test
        @DisplayName("곱셈 테스트")
        void testMul(){
            assertEquals(6, calculator.mul(2 ,3));
            assertEquals(-20, calculator.mul(-2 ,10));
            assertEquals(-60, calculator.mul(6,-10));
            assertEquals(24, calculator.mul(-4,-6));
        }

        @Test
        @DisplayName("나눗셈 테스트")
        void testDiv(){
            assertEquals(0, calculator.div(2 ,3));
            assertEquals(1, calculator.div(3 ,2));
            assertEquals(-1, calculator.div(3,-2));
            assertEquals(2, calculator.div(-4,-2));
            assertEquals(0, calculator.div(0,-10));
            //0으로 나누는 예외
            assertThrows(RuntimeException.class, () -> calculator.div(6,0));

        }
    }
}
