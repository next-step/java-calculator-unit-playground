package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasicCalculatorTest {

    private final Calculator calculator = new BasicCalculator();

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({"1,2,3", "4,5,9", "8,11,19", "0,0,0", "-1,1,0"})
    @DisplayName("덧셈 테스트")
    void add(int a, int b, int answer) {
        int result = calculator.add(a, b);

        assertEquals(result, answer);
    }

    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({"1,2,-1", "4,5,-1", "8,11,-3", "0,0,0", "-1,1,-2", "15,4,11","3,2,1"})
    @DisplayName("뺄셈 테스트")
    void subtract(int a, int b, int answer) {
        int result = calculator.subtract(a, b);

        assertEquals(result, answer);
    }

    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({"1,2,2", "4,5,20", "8,11,88", "0,0,0", "-1,1,-1", "3,4,12"})
    @DisplayName("곱셈 테스트")
    void multiply(int a, int b, int answer) {
        int result = calculator.multiply(a, b);

        assertEquals(result, answer);
    }

    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvSource({"4,2,2", "10,5,2", "8,4,2", "9,3,3", "-6,2,-3", "7,2,3"})
    @DisplayName("나눗셈 테스트")
    void divide(int a, int b, int answer) {
        int result = calculator.divide(a, b);

        assertEquals(result, answer);
    }
}
