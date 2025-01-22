import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("계산기 기능 테스트 클래스")
public class CalculatorTest {
    @Test
    @DisplayName("더하기 연산 테스트")
    public void testAdd() {
        int num1 = 1, num2 = 2;

        assertEquals(3, Calculator.add(num1, num2));
    }

    @Test
    @DisplayName("빼기 연산 테스트")
    public void testSub() {
        int num1 = 1, num2 = 2;

        assertEquals(-1, Calculator.sub(num1, num2));
    }

    @Test
    @DisplayName("곱하기 연산 테스트")
    public void testMul() {
        int num1 = 10, num2 = 2;

        assertEquals(20, Calculator.mul(num1, num2));
    }

    @Test
    @DisplayName("나누기 연산 테스트")
    public void testDiv() {
        int num1 = 1, num2 = 2;

        assertEquals(0, Calculator.div(num1, num2));
    }

    @Test
    @DisplayName("나누기 연산에서 나누는 값이 0인지 테스트")
    public void testDivideByZero() {
        int num1 = 2, num2 = 0;

        assertThrows(ArithmeticException.class, () -> Calculator.div(num1, num2));
    }

    @Test
    @DisplayName("연산 후 int 범위를 벗어나는 지 테스트")
    public void testOverflow() {
        assertThrows(ArithmeticException.class, () -> Calculator.add(Integer.MAX_VALUE, 1));
        assertThrows(ArithmeticException.class, () -> Calculator.sub(Integer.MIN_VALUE, 1));
        assertThrows(ArithmeticException.class, () -> Calculator.mul(Integer.MAX_VALUE, 2));
    }
}
