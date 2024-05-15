package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import simpleCalculator.model.Calculator;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private static final int EXPECT_VALUE = 3;
    private Calculator calculator;

    @BeforeEach
    void setCalculator() {
        calculator = new Calculator();
    }

    @DisplayName("연산기능 테스트")
    @Nested
    class functionTest {

        @DisplayName("더하기")
        @Test
        void testAdd() {
            calculator.setNumber("1,2");
            assertEquals(EXPECT_VALUE, calculator.addNumbers());
        }

        @DisplayName("빼기")
        @Test
        void testSub() {
            calculator.setNumber("4,1");
            assertEquals(EXPECT_VALUE, calculator.subNumbers());
        }

        @DisplayName("나누기")
        @Test
        void testDiv() {
            calculator.setNumber("9,3");
            assertEquals(EXPECT_VALUE, calculator.divideNumbers());
        }

        @DisplayName("곱하기")
        @Test
        void testAMul() {
            calculator.setNumber("3,1");
            assertEquals(EXPECT_VALUE, calculator.multipleNumbers());
        }
    }

    @DisplayName("예외처리 테스트")
    @Nested
    class exceptionTest {

        @DisplayName("0으로 나누기를 시도한 경우")
        @Test
        void testDivideByZero() {
            calculator.setNumber("10,0");
            assertThrows(RuntimeException.class, () -> calculator.divideNumbers());
        }

        @DisplayName("입력을 2개 미만으로 시도한 경우")
        @Test
        void testInputUnderTwo() {
            assertThrows(RuntimeException.class, () ->  calculator.setNumber("1"));
        }

        @DisplayName("입력을 2개 초과로 시도한 경우")
        @Test
        void testInputOverTwo() {
            assertThrows(RuntimeException.class, () -> calculator.setNumber("1,2,3"));
        }
    }
}