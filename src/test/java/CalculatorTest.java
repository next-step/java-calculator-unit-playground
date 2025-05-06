import NumberCalc.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("초간단 문자열 테스트")
public class CalculatorTest {

    Calculator calc = new Calculator();

    @Nested
    @DisplayName("사칙연산 테스트")
    class OperationTest {

        @ParameterizedTest
        @MethodSource("addArguments")
        @DisplayName("add는 x, y를 입력받아 덧셈 결과를 반환한다")
        void addTest(int x, int y, int expected) {
            int result = calc.add(x, y);
            assertEquals(expected, result);
        }

        @ParameterizedTest
        @MethodSource("subtractArguments")
        @DisplayName("subtract는 x, y를 입력받아 뺄셈 결과를 반환한다")
        void subtractTest(int x, int y, int expected) {
            int result = calc.subtract(x, y);
            assertEquals(expected, result);
        }

        @ParameterizedTest
        @MethodSource("multiplyArguments")
        @DisplayName("multiply는 x, y를 입력받아 곱셈 결과를 반환한다")
        void multiplyTest(int x, int y, int expected) {
            int result = calc.multiply(x, y);
            assertEquals(expected, result);
        }

        @ParameterizedTest
        @MethodSource("divideArguments")
        @DisplayName("divide는 x, y를 입력받아 나눗셈 결과를 반환한다")
        void divideTest(int x, int y, int expected) {
            int result = calc.divide(x, y);
            assertEquals(expected, result);
        }

        static Stream<Arguments> addArguments() {
            return Stream.of(
                    Arguments.of(1, 2, 3),
                    Arguments.of(-3, 3, 0)
            );
        }

        static Stream<Arguments> subtractArguments() {
            return Stream.of(
                    Arguments.of(5, 2, 3),
                    Arguments.of(10, 7, 3)
            );
        }

        static Stream<Arguments> multiplyArguments() {
            return Stream.of(
                    Arguments.of(2, 3, 6),
                    Arguments.of(0, 10, 0)
            );
        }

        static Stream<Arguments> divideArguments() {
            return Stream.of(
                    Arguments.of(10, 2, 5),
                    Arguments.of(9, 3, 3)
            );
        }
    }
}
