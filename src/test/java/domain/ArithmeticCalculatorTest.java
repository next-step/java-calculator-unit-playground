package domain;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class ArithmeticCalculatorTest {

    @Test
    void 덧셈을_한다() {
        // given
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(5);
        numbers.add(7);
        ArithmeticCalculator calculator = new ArithmeticCalculator(numbers);
        // when
        int result = calculator.plusCalculate();
        // then
        assertEquals(15, result);
    }

    @Test
    void 뺄셈을_한다() {
        // given
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(5);
        numbers.add(7);
        ArithmeticCalculator calculator = new ArithmeticCalculator(numbers);
        // when
        int result=calculator.minusCalculate();
        // then
        assertEquals(-15,result);
    }

    @Test
    void 곱셈을_한다() {
        // given
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(5);
        numbers.add(7);
        ArithmeticCalculator calculator = new ArithmeticCalculator(numbers);
        // when
        int result=calculator.multipleCalculate();
        // then
        assertEquals(105,result);
    }

    @DisplayName("나눗셈 테스트")
    @Nested
    class DivideTest {

        @Test
        void 나눗셈을_한다() {
            // given
            ArrayList<Integer> numbers = new ArrayList<>();
            numbers.add(4);
            numbers.add(2);
            numbers.add(1);
            ArithmeticCalculator calculator = new ArithmeticCalculator(numbers);
            // when
            int result=calculator.divideCalculate();
            // then
            assertEquals(2 ,result);
        }
    }
}