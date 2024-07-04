import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    @DisplayName("두 개의 숫자를 더하는 테스트")
    void add() {
        int result = calculator.add(20, 10);
        assertEquals(30, result);
    }

    @Test
    @DisplayName("두 개의 숫자를 빼는 테스트")
    void subtract() {
        int result = calculator.subtract(20, 10);
        assertEquals(10, result);
    }

    @Test
    @DisplayName("두 개의 숫자를 곱 하는 테스트 ")
    void multiply() {
        int result = calculator.multiply(20, 10);
        assertEquals(200, result);
    }

    @Test
    @DisplayName("두 개의 숫자를 나누는 테스트")
    void divide() {
        int result = calculator.divide(20, 10);
        assertEquals(2, result);
    }

    @Test
    @DisplayName("숫자 0으로 나눴을 때 예외가 발생 하는 지 테스트")
    void divideByZero() {
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(20, 0));
    }

}
