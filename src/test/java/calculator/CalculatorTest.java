package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("계산기 테스트")
public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Nested
    @DisplayName("덧셈 테스트")
    class AddTest {

        @ParameterizedTest
        @CsvSource({"1, 2, 3", "10, 20, 30", "-9, 15, 6"})
        @DisplayName("두 수를 더한 값을 반환하는 테스트")
        void return_sum(int num1, int num2, int result) {
            assertEquals(result, calculator.add(num1, num2));
        }
    }

    @Nested
    @DisplayName("뺄셈 테스트")
    class SubtractTest {

        @ParameterizedTest
        @CsvSource({"1, 2, -1", "20, 10, 10", "-9, 15, -24"})
        @DisplayName("두 수를 뺀 값을 반환하는 테스트")
        void return_subtract(int num1, int num2, int result) {
            assertEquals(result, calculator.subtract(num1, num2));
        }
    }

    @Nested
    @DisplayName("곱셈 테스트")
    class MultiplyTest {

        @ParameterizedTest
        @CsvSource({"1, 2, 2", "20, 10, 200", "-9, 5, -45"})
        @DisplayName("두 수를 곱한 값을 반환하는 테스트")
        void return_multiply(int num1, int num2, int result) {
            assertEquals(result, calculator.multiply(num1, num2));
        }
    }

    @Nested
    @DisplayName("나눗셈 테스트")
    class DivideTest {

        @ParameterizedTest
        @CsvSource({"4, 2, 2", "20, 10, 2", "-9, 5, -1"})
        @DisplayName("두 수를 나눈 값을 반환하는 테스트")
        void return_divide(int num1, int num2, int result) {
            assertEquals(result, calculator.divide(num1, num2));
        }

        @Test
        @DisplayName("0으로 나눠 예외를 발생시키는 테스트")
        void return_multiply_fail_zero_division() {
            assertThrows(IllegalArgumentException.class, () -> calculator.divide(10, 0));
        }
    }
}