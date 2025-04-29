import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import simpleCalc.SimpleCalculator;


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
        @DisplayName("divide 함수는 x,y가 인자로 주어지면 나눗 ㄸ 연산을 수행한다.")
        void testDivideOperation(int x, int y) {
            int actual = SimpleCalculator.divide(x, y);
            assertEquals(x / y, actual);
        }


        @Test
        @DisplayName("divide 함수는 0으로 나눌때 RuntimeException을 던진다.")
        void zeroDivisionRuntimeExceptionTest() {
            assertThrows(RuntimeException.class, () -> SimpleCalculator.divide(1, 0));
        }

        /**
         *operationTestArguments이 static으로 선언되는 이유
         *
         * 방법 1. (가장 일반적) operationTestArguments를 private static으로 만든다.
                 * @MethodSource는 테스트 인스턴스가 생성되기 전에 호출된다.
                 * 그래서 기본적으로 static 메서드를 요구한다.
         * 방법 2. @TestInstance(TestInstance.Lifecycle.PER_CLASS)를 클래스에 붙여서 non-static 메서드를 허용한다.
         *          이걸 붙이면, JUnit이 테스트 클래스 인스턴스를 미리 하나 만들어놓고 그 인스턴스에서 메서드를 찾아서 호출할 수 있게 된다.
         *          하지만 테스트 클래스는 최대한 stateless(상태 없는) 구조로 가는 게 좋기 때문에, 특별한 이유 없으면 static으로 만드는 것이 좋다.
         */
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
