package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import stringcalculator.util.InputParser;

import static org.assertj.core.api.Assertions.*;

class BasicStringCalculatorTest {

    private final StringCalculator sc = new BasicStringCalculator(new InputParser());

    @ParameterizedTest
    @CsvSource({
            "'1,2,3', 6",
            "'1,2,3,4,5,6', 21",
            "'3,7,8,10,1,3', 32"
    })
    @DisplayName("값 입력시 올바른 반환")
    void addString(String input, int answer) {
        final int result = sc.add(input);

        assertThat(result).isEqualTo(answer);
    }

    @ParameterizedTest
    @CsvSource({
            "'1:2:3', 6",
            "'1,2,3:4:5:6', 21",
            "'3,7:8:10,1,3', 32"
    })
    @DisplayName("값 입력시 올바른 반환 + 콜론 구분자 추가")
    void addStringColon(String input, int answer) {
        final int result = sc.add(input);

        assertThat(result).isEqualTo(answer);
    }

    @ParameterizedTest
    @CsvSource({
            "'1:2:3', 4",
            "'1,2,3:4:5:6', 12",
            "'3,7:8:10,1,3', 31"
    })
    @DisplayName("값 입력시 틀린 값 반환 검사")
    void addStringFail(String input, int answer) {
        final int result = sc.add(input);

        assertThat(result).isNotEqualTo(answer);
    }


    @ParameterizedTest
    @CsvSource({
            "'', 0",
    })
    @DisplayName("빈 문자열 입력시 0 반환")
    void blankString(String input, int answer) {
        final int result = sc.add(input);

        assertThat(result).isEqualTo(answer);
    }

    @ParameterizedTest
    @CsvSource({
            "'-1,-2,-3'","'10,20:30,-40'"
    })
    @DisplayName("음수 입력시 RuntimeException 발생")
    void StringNegativeException(String input) {
        assertThatThrownBy(() -> sc.add(input)).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @CsvSource({
            "'t,-2,-3'",
            "'1,2,3:tyy'"
    })
    @DisplayName("숫자가 아닌 값 입력시 RuntimeException 발생")
    void StringIsNotValidException(String input) {
        assertThatThrownBy(() -> sc.add(input)).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @CsvSource({
            "'//;\n1;2;3', 6",
            "'//;\n4;5:6', 15",
            "'//;\n0,2:1;4', 7",
            "'//;\n1;1', 2",
    })
    @DisplayName("구분자 존재시 구분자를 포함한 문자열 계산")
    void addCustomDelimiter(String input, int answer) {
        final int result = sc.add(input);

        assertThat(result).isEqualTo(answer);
    }
}
