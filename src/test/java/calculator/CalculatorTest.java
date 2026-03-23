package calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest{

    @DisplayName("인자 두 개를 받아서 더한 값을 반환한다.")
    @Test
    void testAdd(){
        Calculator calculator = new Calculator();

        int result = calculator.add(1, 2);

        assertEquals(3, result);
    }

    @DisplayName("인자 두 개를 받아서 뺀 값을 반환한다.")
    @Test
    void testSubtract(){
        Calculator calculator = new Calculator();

        int result = calculator.subtract(3, 2);

        assertEquals(1, result);
    }

    @DisplayName("인자 두 개를 받아서 곱한 값을 반환한다.")
    @Test
    void testMultiply(){
        Calculator calculator = new Calculator();

        int result = calculator.multiply(3, 2);

        assertEquals(6, result);
    }

    @DisplayName("인자 두 개를 받아서 나눈 값을 반환한다.")
    @Test
    void testDivide(){
        Calculator calculator = new Calculator();

        int result = calculator.divide(4, 2);

        assertEquals(2, result);
    }

    @DisplayName("0으로 나누었을 때의 오류 검출")
    @Test
    void testDividebyZero(){
        Calculator calculator = new Calculator();

        assertThrows(ArithmeticException.class, ()->calculator.divide(4, 0));
    }

}
