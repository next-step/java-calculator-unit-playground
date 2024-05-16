import domain.BasicCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BasicCalculatorTest {

    final int a = 8;
    final int b = 4;

    final BasicCalculator basicCalculator = new BasicCalculator(a, b);

    @Test
    void 더하기_테스트() {
        assertEquals(basicCalculator.addNum(), a + b);
    }

    @Test
    void 빼기_테스트() {
        assertEquals(basicCalculator.subtractNum(), a - b);
    }

    @Test
    void 곱하기_테스트() {
        assertEquals(basicCalculator.multiplyNum(), a * b);
    }

    @Test
    void 나누기_테스트() {
        assertEquals(basicCalculator.divideNum(), a / b);
    }

    @Test
    void 분모를_0으로_나눈_경우_예외를_발생시킨다() {
        final int a = 5;
        final int b = 0;
        final BasicCalculator basicCalculator = new BasicCalculator(a, b);

        assertThrows(ArithmeticException.class, basicCalculator::divideNum);
    }
}
