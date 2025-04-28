import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    @DisplayName("두 개의 인자를 받아 정상적으로 덧셈 결과를 반환한다.")
    void shouldReturnResult_Add() {
        // given
        Calculator calculator = new Calculator();
        int a = 1;
        int b = 2;

        // when
        int expected = calculator.add(a, b);

        // then
        int actual = 3;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("두 개의 인자를 받아 정상적으로 뺄셈 결과를 반환한다.")
    void shouldReturnResult_Subtraction() {
        // given
        Calculator calculator = new Calculator();
        int a = 2;
        int b = 1;

        // when
        int expected = calculator.subtraction(a, b);

        // then
        int actual = 1;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("두 개의 인자를 받아 정상적으로 곱셈 결과를 반환한다.")
    void shouldReturnResult_Multiplication() {
        // given
        Calculator calculator = new Calculator();
        int a = 2;
        int b = 3;

        // when
        int expected = calculator.multiplication(a, b);

        // then
        int actual = 6;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("두 개의 인자를 받아 정상적으로 나눗셈 결과를 반환한다.")
    void shouldReturnResult_Division() {
        // given
        Calculator calculator = new Calculator();
        int a = 4;
        int b = 2;

        // when
        int expected = calculator.division(a, b);

        // then
        int actual = 2;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("두 개의 인자 중 작은 값에서 큰 값을 나누려고 할 경우 예외가 발생한다.")
    void shouldThrowException_whenIndivisibleValue() {
        // given
        Calculator calculator = new Calculator();
        int a = 2;
        int b = 4;

        // when
        ArithmeticException e = assertThrows(ArithmeticException.class,
                () -> calculator.division(a, b)
        );

        // then
        assertEquals(e.getMessage(), "작은 값으로 큰 값을 나눌 수 없습니다.");
    }
}
