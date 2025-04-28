import jdk.dynalink.linker.support.SimpleLinkRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("초간단 계산기 unit 테스트")
public class SimpleCaluculatorTest {

    @Nested
    @DisplayName("사칙 연산 계산 기능 테스트")
    class fourOperationTest {

        @ParameterizedTest
        @MethodSource("operationTestArguments")
        @DisplayName("add 함수는 x,y가 인자로 주어지면 덧셈 연산을 수행한다.")
        void testAddOperation(int x, int y) {
            int actual = SimpleCalculator.add(x, y);
            assertEquals(x + y, actual);
        }

        @ParameterizedTest
        @MethodSource("operationTestArguments")
        @DisplayName("substract 함수는 x,y가 인자로 주어지면 뺄셈 연산을 수행한다.")
        void testSubstractOperation(int x, int y) {
            int actual = SimpleCalculator.substract(x, y);
            assertEquals(x - y, actual);
        }

        @ParameterizedTest
        @MethodSource("operationTestArguments")
        @DisplayName("multiply 함수는 x,y가 인자로 주어지면 곱셈 연산을 수행한다.")
        void testMutiplyOperation(int x, int y) {
            int actual = SimpleCalculator.multiply(x, y);
            assertEquals(x * y, actual);
        }

        @ParameterizedTest
        @MethodSource("operationTestArguments")
        @DisplayName("divide 함수는 x,y가 인자로 주어지면 곱셈 연산을 수행한다.")
        void testDivideOperation(int x, int y) {
            int actual = SimpleCalculator.divide(x, y);
            assertEquals(x / y, actual);
        }


        @Test
        @DisplayName("divide 함수는 0으로 나눌때 RuntimeException을 던진다.")
        void zeroDivisionRuntimeExceptionTest() {
            assertThrows(RuntimeException.class, () -> SimpleCalculator.divide(1, 0));
        }

        private static Stream<Arguments> operationTestArguments() {
            return Stream.of(
                    Arguments.arguments(1, 2),
                    Arguments.arguments(-1, -2),
                    Arguments.arguments(2, 1),
                    Arguments.arguments(1, -1)
            );
        }
    }
}
