package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasicCalculatorTest {
    @DisplayName("인자 두 개를 받아서 더한 값을 변환한다.")
    @Test
    void testAdd(){
        //given
        BasicCalculator calculator = new BasicCalculator();

        //when
        int result = calculator.add(1,2);
        //then
        assertEquals(3, result);

    }
    @DisplayName("인자 두 개를 받아서 뺀 값을 변환한다.")
    @Test
    void testSubtract(){
        //given
        BasicCalculator calculator = new BasicCalculator();

        //when
        int result = calculator.subtract(1,2);
        //then
        assertEquals(-1, result);

    }
    @DisplayName("인자 두 개를 받아서 곱한 값을 변환한다.")
    @Test
    void testMultiply(){
        //given
        BasicCalculator calculator = new BasicCalculator();

        //when
        int result = calculator.multiply(1,2);
        //then
        assertEquals(2, result);

    }
    @DisplayName("인자 두 개를 받아서 나눈 값을 변환한다.")
    @Test
    void testDivide(){
        //given
        BasicCalculator calculator = new BasicCalculator();

        //when
        int result = calculator.divide(4,2);
        //then
        assertEquals(2, result);

    }

}
