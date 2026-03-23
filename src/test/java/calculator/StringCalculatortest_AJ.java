package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class StringCalculatorTest_AJ{

    @DisplayName("기본 구분자 split 및 합 확인.")
    @Test
    void testSplit(){
        StringCalculator calculator = new StringCalculator();

        String[] result = calculator.basicSplit("1,2,4");
        int fin = calculator.addAll(result);

        assertThat(fin).isEqualTo(7);
    }

    @DisplayName("커스텀 구분자 split 및 합 확인.")
    @Test
    void testCustomSplit(){
        StringCalculator calculator = new StringCalculator();

        String[] result = calculator.setCustomSplit("//<\n1<3<5");
        int fin = calculator.addAll(result);

        assertThat(fin).isEqualTo(9);
    }
}
