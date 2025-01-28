import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;

@DisplayName("초간단 문자열 테스트")
class SimpleCalculatorTest {

    private SimpleCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new SimpleCalculator(); // 테스트 실행 전 Calculator 초기화
    }

    @Test
    @DisplayName("덧셈 테스트")
    void testAdd() {
        assertEquals(5, calculator.add(2, 3));
        assertEquals(0, calculator.add(0, 0));
        assertEquals(-5, calculator.add(-2, -3));
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void testSubtract() {
        assertEquals(1, calculator.subtract(3, 2));
        assertEquals(-3, calculator.subtract(0, 3));
        assertEquals(0, calculator.subtract(5, 5));
    }

    @Test
    @DisplayName("곱셈 테스트")
    void testMultiply() {
        assertEquals(10, calculator.multiply(2, 5));
        assertEquals(0, calculator.multiply(0, 3));
        assertEquals(-15, calculator.multiply(-5, 3));
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void testDivide() {
        assertEquals(2, calculator.divide(6, 3));
        assertEquals(-2, calculator.divide(-6, 3));
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(9, 0), "0으로 나눗셈 불가");
    }
}
