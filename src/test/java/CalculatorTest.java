import domain.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void 더하기_테스트() {
        //given
        final Calculator calculator = new Calculator();
        final int num1 = 1;
        final int num2 = 2;
        final int expected = 3;

        //when
        final int actual = calculator.add(num1, num2);

        //then
        assertEquals(expected, actual);
    }

    @Test
    void 빼기_테스트() {
        //given
        final Calculator calculator = new Calculator();
        final int num1 = 1;
        final int num2 = 2;
        final int expected = -1;

        //when
        final int actual = calculator.subtract(num1, num2);

        //then
        assertEquals(expected, actual);
    }

    @Test
    void 곱하기_테스트() {
        //given
        final Calculator calculator = new Calculator();
        final int num1 = 1;
        final int num2 = 2;
        final int expected = 2;

        //when
        final int actual = calculator.multiple(num1, num2);

        //then
        assertEquals(expected, actual);
    }

    @Test
    void 나누기_테스트() {
        //given
        final Calculator calculator = new Calculator();
        final int num1 = 1;
        final int num2 = 2;
        final int expected = 0;

        //when
        final int actual = calculator.divide(num1, num2);

        //then
        assertEquals(expected, actual);
    }

    @Test
    void 분모가_0일때_나누기_테스트() {
        //given
        final Calculator calculator = new Calculator();
        final int num1 = 1;
        final int num2 = 0;
        final var expected = "0으로 나눌 수 없습니다.";

        //when
        final ArithmeticException arithmeticException = assertThrows(ArithmeticException.class, () -> calculator.divide(num1, num2));

        //then
        assertEquals(expected, arithmeticException.getMessage());
    }
}
