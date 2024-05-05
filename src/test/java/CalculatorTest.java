import domain.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    @DisplayName("더하기 테스트")
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
    @DisplayName("잘못된 더하기 테스트")
    void 잘못된_더하기_테스트() {
        //given
        final Calculator calculator = new Calculator();
        final int num1 = 1;
        final int num2 = 2;
        final int unexpected = 4;

        //when
        final int actual = calculator.add(num1, num2);

        //then
        assertNotEquals(unexpected, actual);
    }

    @Test
    @DisplayName("빼기 테스트")
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
    @DisplayName("잘못된 빼기 테스트")
    void 잘못된_빼기_테스트() {
        //given
        final Calculator calculator = new Calculator();
        final int num1 = 1;
        final int num2 = 2;
        final int unexpected = 0;

        //when
        final int actual = calculator.subtract(num1, num2);

        //then
        assertNotEquals(unexpected, actual);
    }

    @Test
    @DisplayName("곱하기 테스트")
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
    @DisplayName("잘못된 곱하기 테스트")
    void 잘못된_곱하기_테스트() {
        //given
        final Calculator calculator = new Calculator();
        final int num1 = 1;
        final int num2 = 2;
        final int expected = 0;

        //when
        final int actual = calculator.multiple(num1, num2);

        //then
        assertNotEquals(expected, actual);
    }

    @Test
    @DisplayName("나누기 테스트")
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
    @DisplayName("분모가 0일때 나누기 테스트")
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

    @Test
    @DisplayName("잘못된_나누기 테스트")
    void 잘못된_나누기_테스트() {
        //given
        final Calculator calculator = new Calculator();
        final int num1 = 1;
        final int num2 = 2;
        final int expected = 1;

        //when
        final int actual = calculator.divide(num1, num2);

        //then
        assertNotEquals(expected, actual);
    }

}
