package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @DisplayName("두 개의 정수를 더한 결과를 반환할 수 있다.")
    @Test
    void testAdd(){
        //given
        Calculator calculator = new Calculator(); //클래스로 객체를 설정함.

        //when
        int actual = calculator.add(3,6);
        //then
        assertEquals(9,actual);
    }
    @DisplayName("두 개의 정수를 뺀 결과를 반환할 수 있다.")
    @Test
    void testSubtract(){
        //given
        Calculator calculator = new Calculator(); //클래스로 객체를 설정함.

        //when
        int actual = calculator.subtract(6,3);
        //then
        assertEquals(3,actual);
    }
    @DisplayName("두 개의 정수를 곱한 결과를 반환할 수 있다.")
    @Test
    void testMultiply(){
        //given
        Calculator calculator = new Calculator(); //클래스로 객체를 설정함.

        //when
        int actual = calculator.multiply(3,6);
        //then
        assertEquals(18,actual);
    }
    @DisplayName("두 개의 정수를 나눈 결과를 반환할 수 있다.")
    @Test
    void testDivide(){
        //given
        Calculator calculator = new Calculator(); //클래스로 객체를 설정함.

        //when
        int actual = calculator.divide(6,3);
        //then
        assertEquals(2,actual);
    }
    @DisplayName("기본 구분자(쉼표, 콜론)를 기준으로 분리한 각 숫자의 합을 반환한다.")
    @Test
    void testSplitAdd_DefaultDelimiter() {
        Calculator calculator = new Calculator();
        int actual = calculator.splitAdd("1,2:3");
        assertEquals(6, actual);
    }

    @DisplayName("커스텀 구분자를 지정하여 분리한 각 숫자의 합을 반환한다.")
    @Test
    void testSplitAdd_CustomDelimiter() {
        Calculator calculator = new Calculator();
        int actual = calculator.splitAdd("//;\n1;2;3");
        assertEquals(6, actual);
    }

    @DisplayName("문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외를 발생시킨다.")
    @Test
    void testSplitAdd_NegativeNumberException() {
        Calculator calculator = new Calculator();

        assertThrows(RuntimeException.class, () -> {
            calculator.splitAdd("-1,2,3");
        });
    }

    @DisplayName("문자열 계산기에 숫자 이외의 값을 전달하는 경우 RuntimeException 예외를 발생시킨다.")
    @Test
    void testSplitAdd_NotANumberException() {
        Calculator calculator = new Calculator();

        assertThrows(RuntimeException.class, () -> {
            calculator.splitAdd("1,a,3");
        });
    }
}