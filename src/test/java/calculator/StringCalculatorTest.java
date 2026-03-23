package calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class StringCalculatorTest {
    private static StringCalculator stringCalculator;

    @BeforeAll
    static void beforeAll() {
        stringCalculator = new StringCalculator();
    }

    @DisplayName("구분자를 기준으로 분리한 숫자의 합을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"'1,2,3,4,5'& 15", "'1:2:33:4:5'& 45", "'1,22,3:4:5'& 35", "'//;\n1,22;3:44;5'& 75", "'//a\n1a2a3a4a55'& 65", "'//a[|\n1[22|3a4,55'& 85"}, delimiter = '&')
    void testSumString(String value, int expected) {
        // when
        int actual = stringCalculator.calculateSumOfString(value);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("잘못된 형식이나 음수를 입력했을 때 RuntimeException을 throw한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1a2,3", "//a1a2a3", "//a\n-1a2a3", "//a\n1a-2a3", "//a\n1a2b3", "1[2[3"})
    void testSumStringException(String value) {
        // when & then
        assertThatThrownBy(() -> stringCalculator.calculateSumOfString(value)).isInstanceOf(RuntimeException.class);
    }
}
