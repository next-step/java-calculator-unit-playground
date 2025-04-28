import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("Calculator Test")
class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "3, 5, 8",
            "-1, -2, -3",
            "-5, 5, 0"
    })
    @DisplayName("덧셈: 두 수를 더한 결과를 반환한다.")
    void addMethod(int firstNumber, int secondNumber, int expected) {
        int result = calculator.add(firstNumber, secondNumber);
        assertEquals(expected, result);
    }

}