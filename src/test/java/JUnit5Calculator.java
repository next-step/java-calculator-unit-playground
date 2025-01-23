import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


public class JUnit5Calculator {

    @Nested
    @DisplayName("사칙연산 테스트")
    class ArithmeticOperations {
        // Calculator calculator = new Calculator(); 이 선언으로 Calculator.java의 메서드에 붙어있는 static 키워드는 필요 없음.
        // TODO: 준기형한테 이렇게 객체 생성하는게 나은지 아니면 static으로 받아주는 게 좋은지 물어보기

        private static Stream<Arguments> exampleSource() {
            return Stream.of(
                    Arguments.arguments(1, 2),
                    Arguments.arguments(5, 6),
                    Arguments.arguments(1, 0),
                    Arguments.arguments(-1, 2)
            );
        }

        private static Stream<Arguments> overflowSource() {
            return Stream.of(
                    Arguments.arguments(Integer.MAX_VALUE, 2),
                    Arguments.arguments(Integer.MIN_VALUE, -2)
            );
        }

        @ParameterizedTest
        @MethodSource("exampleSource")
        @DisplayName("덧셈")
        void addition(int a, int b) {
            assertEquals(a + b, Calculator.add(a, b));
        }

        @ParameterizedTest
        @MethodSource("overflowSource")
        @DisplayName("덧셈 오버플로우 테스트")
        void additionOverflow(int a, int b) {
            assertDoesNotThrow(() -> {
                Calculator.add(a, b);
            });
        }

        @ParameterizedTest
        @MethodSource("exampleSource")
        @DisplayName("뺄셈")
        void subtraction(int a, int b) {
            assertEquals(a - b, Calculator.subtract(a, b));
        }

        @ParameterizedTest
        @MethodSource("overflowSource")
        @DisplayName("뺄셈 오버플로우 테스트")
        void subtractionOverflow(int a, int b) {
            assertDoesNotThrow(() -> {
                Calculator.subtract(a, b);
            });
        }

        @ParameterizedTest
        @MethodSource("exampleSource")
        @DisplayName("곱셈")
        void multiplication(int a, int b) {
            assertEquals(a * b, Calculator.multiply(a, b));
        }

        @ParameterizedTest
        @MethodSource("overflowSource")
        @DisplayName("곱셈 오버플로우 테스트")
        void multiplicationOverflow(int a, int b) {
            assertDoesNotThrow(() -> {
                Calculator.multiply(a, b);
            });
        }

        @ParameterizedTest
        @MethodSource("exampleSource")
        @DisplayName("나눗셈")
        void division(int a, int b) {
            if (b != 0) {
                assertEquals(a / b, Calculator.divide(a, b));
            }
            assertThrows(ArithmeticException.class, () -> Calculator.divide(a, 0));
        }
    }
}
