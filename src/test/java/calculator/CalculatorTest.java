package calculator;

import simpleCalculator.model.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import simpleCalculator.view.CalculatorView;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CalculatorTest {
    @Nested
    @DisplayName("입력관련 테스트")
    public class InputTest {

        @DisplayName("입력내용 저장 테스트")
        @Test
        void inputAndSaveTest() {
            //given
            InputStream input = System.in;
            ByteArrayInputStream in = new ByteArrayInputStream("2,1".getBytes());
            System.setIn(in);
            List<Integer> testList = CalculatorView.getNumber();
            int num1 = testList.get(0);
            int num2 = testList.get(1);
            //when
            //Then
            assertEquals(2, num1, "값이 일치하지 않습니다.");
            assertEquals(1, num2, "값이 일치하지 않습니다.");
            assertNotEquals(1, num1, "값이 일치합니다!");
            assertNotEquals(2, num2, "값이 일치합니다!");
        }
    }

    @Nested
    @DisplayName("계산기능 테스트")
    public class functionTest {

        int testNum1 = 2;
        int testNum2 = 1;

        Calculator calculator = new Calculator(testNum1, testNum2);

        @DisplayName("더하기 테스트 1")
        @Test
        void addTest() {
            //given
            int expectValue = 3;
            int testAdd = calculator.addNumbers();
            //when
            //then
            assertEquals(testAdd, expectValue, "값이 일치하지 않습니다.");
        }

        @DisplayName("더하기 테스트 2")
        @Test
        void addFailTest() {
            //given
            int failValue = 0;
            int testAdd = calculator.addNumbers();
            //when
            //then
            assertNotEquals(testAdd, failValue, "값이 일치합니다!");
        }

        @DisplayName("빼기 테스트 1")
        @Test
        void subTest() {
            //given
            int expectValue = 1;
            int testSub = calculator.subNumbers();
            //when
            //then
            assertEquals(testSub, expectValue, "값이 일치하지 않습니다.");
        }

        @DisplayName("빼기 테스트 2")
        @Test
        void subFailTest() {
            //given
            int failValue = 0;
            int testSub = calculator.addNumbers();
            //when
            //then
            assertNotEquals(testSub, failValue, "값이 일치합니다!");
        }

        @DisplayName("나누기 테스트 1")
        @Test
        void divideTest() {
            //given
            int expectValue = 2;
            int testDivide = calculator.divideNumbers();
            //when

            //then
            assertEquals(testDivide, expectValue, "값이 일치하지 않습니다.");
        }

        @DisplayName("나누기 테스트 2")
        @Test
        void divideFailTest() {
            //given
            int failValue = 0;
            int testDivide = calculator.addNumbers();
            //when
            //then
            assertNotEquals(testDivide, failValue, "값이 일치합니다!");
        }

        @DisplayName("곱하기 테스트 1")
        @Test
        void multipleTest() {
            //given
            int expectValue = 2;
            int testMultiple = calculator.multipleNumbers();
            //when
            //then
            assertEquals(testMultiple, expectValue, "값이 일치하지 않습니다.");
        }

        @DisplayName("곱하기 테스트 2")
        @Test
        void multipleFailTest() {
            //given
            int failValue = 0;
            int testMultiple = calculator.addNumbers();
            //when
            //then
            assertNotEquals(testMultiple, failValue, "값이 일치합니다!");
        }
    }
}
