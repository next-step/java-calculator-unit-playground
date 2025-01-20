import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculateTest {

    private final Calculate calculate = new Calculate();

    @Test
    @DisplayName("OK : 두 수 덧셈 성공")
    void sum() {
        int a = 6;
        int b = 3;
        int result = calculate.add(a, b);
        assertEquals(a + b, result);
    }

    @Test
    @DisplayName("OK : 두 수 뺄셈 성공")
    void subtract() {
        int a = 6;
        int b = 3;
        int result = calculate.subtract(a, b);
        assertEquals(a - b, result);
    }

    @Test
    @DisplayName("OK : 두 수 곱셈 성공")
    void multiply() {
        int a = 6;
        int b = 3;
        int result = calculate.multiply(a, b);
        assertEquals(a * b, result);
    }

    @Test
    @DisplayName("OK : 두 수 나누기 성공")
    void divide() {
        int a = 6;
        int b = 3;
        int result = calculate.divide(a, b);
        assertEquals(a / b, result);
    }
}
