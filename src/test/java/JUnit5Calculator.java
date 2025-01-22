import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class JUnit5Calculator {

    @Nested
    @DisplayName("사칙연산 테스트")
    class ArithmeticOperations {
        Calculator calculator = new Calculator();

        private static Stream<Arguments> exampleSource() {
            return Stream.of(
                    Arguments.arguments(1, 2),
                    Arguments.arguments(5, 6)
            );
        }

        @ParameterizedTest
        @MethodSource("exampleSource")
        @DisplayName("덧셈")
        void addition(int a, int b) {
            assertEquals(a + b, calculator.add(a, b));
        }

        @ParameterizedTest
        @MethodSource("exampleSource")
        @DisplayName("뺄셈")
        void subtraction(int a, int b) {
            assertEquals(a - b, calculator.subtract(a, b));
        }

        @ParameterizedTest
        @MethodSource("exampleSource")
        @DisplayName("곱셈")
        void multiplication(int a, int b) {
            assertEquals(a * b, calculator.multiply(a, b));
        }

        @ParameterizedTest
        @MethodSource("exampleSource")
        @DisplayName("나눗셈")
        void division(int a, int b) {
            assertEquals(a / b, calculator.divide(a, b));
        }
    }
}
