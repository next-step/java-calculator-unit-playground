package calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class StringCalculatorTest {

    @DisplayName("기본 구분자 split 및 합 확인.")
    @Test
    void testSplit(){
        StringCalculator calculator = new StringCalculator();

        String[] result = calculator.basicSplit("1,2,4");
        int fin = calculator.addAll(result);

        assertEquals(7, fin);
    }

    @DisplayName("커스텀 구분자 split 및 합 확인.")
    @Test
    void testCustomSplit(){
        StringCalculator calculator = new StringCalculator();

        String[] result = calculator.setCustomSplit("//<\n1<3<5");
        int fin = calculator.addAll(result);

        assertEquals(9, fin);
    }

    @DisplayName("음수일 때, RuntimeException 예외 throw")
    @Test
    void testMinusException(){
        StringCalculator calculator = new StringCalculator();

        String[] result = calculator.basicSplit("-1, 4, 6");

        assertThrows(RuntimeException.class, () -> calculator.addAll(result));
    }

    @DisplayName("숫자가 아닐 때, RuntimeException 예외 throw")
    @Test
    void testNonNumberException(){
        StringCalculator calculator = new StringCalculator();

        String[] result = calculator.basicSplit("일, 4, 6");

        assertThrows(RuntimeException.class, () -> calculator.addAll(result));
    }
}
