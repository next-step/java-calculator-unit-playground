import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("계산기 JUnit5 테스트")
public class CalculatorTest {

    @DisplayName("계산기 기능 테스트")
    @Nested
    class CalculatorMethodsTest {

        @DisplayName("계산기 덧셈 테스트")
        @Test
        public void addTest() {
            assertEquals(11, Calculator.add("6", "5"));
            assertThrows(IllegalArgumentException.class, () -> Calculator.add("text", "4"));
        }

        @DisplayName("계산기 뺄셈 테스트")
        @Test
        public void subtractTest() {
            assertEquals(-1, Calculator.subtract("3", "4"));
        }

        @DisplayName("계산기 곱하기 테스트")
        @Test
        public void multiplyTest() {
            assertEquals(12, Calculator.multiply("3", "4"));
        }

        @DisplayName("계산기 나누기 테스트")
        @Test
        public void divideTest() {
            assertEquals(2, Calculator.divide("4", "2"));
            assertThrows(IllegalArgumentException.class, () -> Calculator.divide("7", "0"));
        }

        @DisplayName("계산기 Input 예외처리 테스트")
        @Test
        void formatterExceptionTest() {
            assertThrows(IllegalArgumentException.class, () -> Calculator.stringToDouble("이것은 한글"));
        }

        @DisplayName("계산기 Input 변환 테스트")
        @ParameterizedTest
        @MethodSource("methodSourceTestArguments")
        public void formatterTest(int expected, String value) {
            assertEquals(expected,Calculator.stringToDouble(value));
        }

        private static Stream<Arguments> methodSourceTestArguments() {
            return Stream.of(
                    Arguments.arguments(1, "1"),
                    Arguments.arguments(2.2, "2.2"),
                    Arguments.arguments(753, "753")
            );
        }
    }
}
