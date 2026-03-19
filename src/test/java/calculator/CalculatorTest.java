package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @DisplayName("두 개의 정수를 더한 결과를 반환할 수 있다.")
    @Test
    void testAdd() {
        // given
        Calculator calculator = new Calculator();

        // when
        int actual = calculator.add(3, 6);


        // then
        assertEquals(9, actual);
    }

    @DisplayName("두 개의 정수를 뺀 결과를 반환할 수 있다.")
    @Test
    void testSubtract() {
        // given
        Calculator calculator = new Calculator();

        // when
        int actual = calculator.subtract(6, 3);


        // then
        assertEquals(3, actual);
    }

    @DisplayName("두 개의 정수를 곱한 결과를 반환할 수 있다.")
    @Test
    void testMultiply() {
        // given
        Calculator calculator = new Calculator();

        // when
        int actual = calculator.multiply(3, 6);


        // then
        assertEquals(18, actual);
    }

    @DisplayName("두 개의 정수를 나눈 결과를 반환할 수 있다.")
    @Test
    void testDivide() {
        // given
        Calculator calculator = new Calculator();

        // when
        int actual = calculator.divide(6, 3);


        // then
        assertEquals(2, actual);
    }

}