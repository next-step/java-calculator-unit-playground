package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("문자열 계산기 테스트")
class StringCalculatorTest {

    static StringCalculator stringCalculator = new StringCalculator();

    @AfterAll
    static void afterResetResult() {
        stringCalculator.resetResult();
    }

    @ParameterizedTest(name = "기존 값 +  {0} = {1}")
    @DisplayName("기존 값에 input 값을 더해준다. (초기 값 = 0)")
    @CsvSource({"1,1", "2,3", "3,6","4,10"})
    void testCalculatorPlusMethod(int input, int expectResult) {
        stringCalculator.plus(input);
        assertThat(stringCalculator.getResult())
            .isEqualTo(expectResult);
    }

    @Test
    @DisplayName("resetResult를 하면 결과값은 0이 된다.")
    void testCalculatorResetResult() {
        List<Integer> inputs = List.of(1, 2, 3);
        for (Integer input : inputs) {
            stringCalculator.plus(input);
        }
        stringCalculator.resetResult();
        assertThat(stringCalculator.getResult())
            .isEqualTo(0);
    }


}
