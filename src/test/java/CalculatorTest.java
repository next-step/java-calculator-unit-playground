import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("계산기 기능 테스트")
class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    @DisplayName("더하기 기능을 테스트한다")
    void addTest() {
        assertEquals(8, calculator.add(5, 3));
    }

    @Test
    @DisplayName("빼기 기능을 테스트한다")
    void minusTest() {
        assertEquals(2, calculator.minus(5, 3));
    }

    @Test
    @DisplayName("곱하기 기능을 테스트한다")
    void multipleTest() {
        assertEquals(15, calculator.multiple(5, 3));
    }

    @Test
    @DisplayName("나누기 기능을 테스트한다")
    void divideTest() {
        assertEquals(1, calculator.divide(5, 3));
    }

    @Test
    @DisplayName("문자열 더하기 기능을 테스트한다")
    void stringAddTest() {
        assertEquals(8, calculator.stringAdd("5,3"));
    }

    @Test
    @DisplayName("문자열 커스텀더하기 기능을 테스트한다")
    void stringCustomAddTest() {
        assertEquals(8, calculator.stringAdd("//;\n5;3"));
    }

    @Test
    @DisplayName("음수가 있으면 RuntimeExcrption")
    void negativeRuntimeException() {
        assertThrows(RuntimeException.class, this::addNegative);
    }

    private void addNegative() {
        calculator.stringAdd("-5,3");
    }

    @Test
    @DisplayName("빈 문자열은 0")
    void emptyString() {
        assertEquals(0, calculator.stringAdd(""));
    }
}
