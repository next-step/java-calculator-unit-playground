import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void devideTest() {
        assertEquals(1,calculator.devide(5, 3));
    }
}
