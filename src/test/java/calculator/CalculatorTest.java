package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
class CalculatorTest {

    @Test
    @DisplayName("인자 두 개를 받아서, 덧셈을 테스트한다.")
    void testAdd() {
        // given
        Calculator calculator = new Calculator();

        // when
        int result = calculator.add(1, 2);

        // then
        assertEquals(3, result);

    }

    @Test
    void testSubtract() {
        // given
        Calculator calculator = new Calculator();

        // when
        int result = calculator.subtract(3, 2);

        // then
        assertEquals(1, result);
    }

    @Test
    void testMultiply() {
        // given
        Calculator calculator = new Calculator();

        // when
        int result = calculator.multiply(1, 2);

        // then
        assertEquals(2, result);
    }

    @Test
    void testDivide() {
        // given
        Calculator calculator = new Calculator();

        // when
        int result = calculator.divide(4,2);

        // then
        assertEquals(2, result);
    }

    @Test
    void testStringAdd() {
        Calculator calculator = new Calculator();

        int result = calculator.add("//:\\n1:2:3:4");

        assertEquals(10, result);
    }
}