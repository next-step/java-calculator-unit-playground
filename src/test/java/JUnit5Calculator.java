import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.*;


public class JUnit5Calculator {

    @Nested
    @DisplayName("사칙연산 테스트")
    class ArithmeticOperations {
        // Calculator calculator = new Calculator(); 이 객체를 만들어줄 격우 Calculator.java의 메서드에 붙어있는 static 키워드는 필요 없음.

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
            // assertEquals(a + b, Calculator.add(a, b));
            assertThat(Calculator.add(a, b)).isEqualTo(a + b);
        }

        @ParameterizedTest
        @MethodSource("overflowSource")
        @DisplayName("덧셈 오버플로우 테스트")
        void additionOverflow(int a, int b) {
//            assertDoesNotThrow(() -> {
//                Calculator.add(a, b);
//            });
            assertThatCode(() -> Calculator.add(a, b)).doesNotThrowAnyException();
        }

        @ParameterizedTest
        @MethodSource("exampleSource")
        @DisplayName("뺄셈")
        void subtraction(int a, int b) {
            // assertEquals(a - b, Calculator.subtract(a, b));
            assertThat(Calculator.subtract(a, b)).isEqualTo(a - b);
        }

        @ParameterizedTest
        @MethodSource("overflowSource")
        @DisplayName("뺄셈 오버플로우 테스트")
        void subtractionOverflow(int a, int b) {
//            assertDoesNotThrow(() -> {
//                Calculator.subtract(a, b);
//            });
            assertThatCode(() -> Calculator.subtract(a, b)).doesNotThrowAnyException();
        }

        @ParameterizedTest
        @MethodSource("exampleSource")
        @DisplayName("곱셈")
        void multiplication(int a, int b) {
            // assertEquals(a * b, Calculator.multiply(a, b));
            assertThat(Calculator.multiply(a, b)).isEqualTo(a * b);
        }

        @ParameterizedTest
        @MethodSource("overflowSource")
        @DisplayName("곱셈 오버플로우 테스트")
        void multiplicationOverflow(int a, int b) {
//            assertDoesNotThrow(() -> {
//                Calculator.multiply(a, b);
//            });
            assertThatCode(() -> Calculator.multiply(a, b)).doesNotThrowAnyException();
        }

        @ParameterizedTest
        @MethodSource("exampleSource")
        @DisplayName("나눗셈")
        void division(int a, int b) {
            if (b != 0) {
                // assertEquals(a / b, Calculator.divide(a, b));
                assertThat(Calculator.divide(a, b)).isEqualTo(a / b);
            }
            // assertThrows(ArithmeticException.class, () -> Calculator.divide(a, 0));
            assertThatThrownBy(() -> Calculator.divide(a, 0)).isInstanceOf(ArithmeticException.class);
        }
    }

    @Nested
    @DisplayName("문자열 계산기 테스트")
    class StringCalculatorTest {
        private static Stream<Arguments> exampleSource() {
            return Stream.of(
                    Arguments.arguments("//.\n1.5.3", 9),
                    Arguments.arguments("1;8,3", 12)
            );
        }

        @ParameterizedTest
        @MethodSource("exampleSource")
        @DisplayName("문자열 덧셈 테스트")
        void stringSumTest(String str, int expacted){
            // assertEquals(expacted, StringCalculator.calculateSum(str));
            assertThat(StringCalculator.calculateSum(str)).isEqualTo(expacted);
        }

        @Test
        @DisplayName("문자열 덧셈 예외 테스트")
        void stringErrorSumTest() {
//            RuntimeException exception1 = assertThrows(RuntimeException.class, () -> {
//                StringCalculator.calculateSum("//.\n1.-5.3");
//            });
//            assertEquals("음수가 아닌 정수를 입력해주세요", exception1.getMessage());
            assertThatThrownBy(() -> StringCalculator.calculateSum("//.\n1.-5.3"))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessage("음수가 아닌 정수를 입력해주세요");

//            RuntimeException exception2 = assertThrows(RuntimeException.class, () -> {
//                StringCalculator.calculateSum("//.\n1.a.3");
//            });
//            assertEquals("숫자가 아닙니다. 숫자를 입력해주세요.", exception2.getMessage());
            assertThatThrownBy(() -> StringCalculator.calculateSum("//.\n1.a.3"))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessage("숫자가 아닙니다. 숫자를 입력해주세요.");
        }
    }
}
