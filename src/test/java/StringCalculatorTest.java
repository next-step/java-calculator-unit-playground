import StringCalc.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("문자열 계산기 테스트")
public class StringCalculatorTest {

    StringCalculator calc = new StringCalculator();

    @Nested
    @DisplayName("구분자 테스트")
    class DelimiterTest {

        @Test
        @DisplayName("빈 문자열은 0을 반환함")
        void emptyStringTest() {
            int result = calc.add("");
            assertEquals(0, result);
        }

        @ParameterizedTest
        @MethodSource("provideBasicInputs")
        @DisplayName(",와 :으로 구분된 숫자들의 합을 반환함")
        void basicDelimiterTest(String input, int expected) {
            int result = calc.add(input);
            assertEquals(expected, result);
        }

        static Stream<Arguments> provideBasicInputs() {
            return Stream.of(
                    Arguments.of("1,2", 3),
                    Arguments.of("1,2:3", 6),
                    Arguments.of("4:5:6", 15)
            );
        }

        @ParameterizedTest
        @MethodSource("provideCustomDelimiterInputs")
        @DisplayName("커스텀 구분자가 있는 경우 합을 반환함")
        void customDelimiterTest(String input, int expected) {
            int result = calc.add(input);
            assertEquals(expected, result);
        }

        static Stream<Arguments> provideCustomDelimiterInputs() {
            return Stream.of(
                    Arguments.of("//;\n1;2;3", 6),
                    Arguments.of("//@\n2@3@4", 9)
            );
        }
    }

    @Nested
    @DisplayName("예외처리 테스트")
    class ExceptionThrowingTest {

        @Test
        @DisplayName("음수가 있는 경우 RuntimeException 발생")
        void negativeNumberTest() {
            RuntimeException exception = assertThrows(RuntimeException.class, () -> {
                calc.add("1,-2,3");
            });
            assertTrue(exception.getMessage().contains("음수"));
        }

        @Test
        @DisplayName("숫자 이외의 값이 있는 경우 RuntimeException 발생")
        void nonNumberInputTest() {
            RuntimeException exception = assertThrows(RuntimeException.class, () -> {
                calc.add("1,a,3");
            });
            assertTrue(exception.getMessage().contains("숫자만"));
        }
    }
}