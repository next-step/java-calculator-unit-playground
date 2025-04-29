import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import stringCalc.StringCalculator;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("문자열 계산기 unit 테스트")
public class StringCalculatorTest {
    @Nested
    @DisplayName("기본 구분자 처리 테스트")
    class BasicDelimiterTest {
        @DisplayName("빈 문자열은 0을 반환한다.")
        void emptyStringInputTest() {
            int actual = StringCalculator.add("");
            assertEquals(0, actual);
        }

        @DisplayName("숫자 하나만 있을 경우, 그 숫자를 반환한다.")
        void oneSizeStringInputTest() {
            int actual = StringCalculator.add("1");
            assertEquals(1, actual);
        }

        @ParameterizedTest
        @MethodSource("basicDelimeterStringInputArguments")
        @DisplayName("쉼표와 콜론으로 구분된 숫자들의 합을 반환한다.")
        void basicDelimeterStringInputTest(String value, int expected) {
            int actual = StringCalculator.add(value);
            assertEquals(expected, actual);
        }

        private static Stream<Arguments> basicDelimeterStringInputArguments() {
            return Stream.of(
                    Arguments.arguments("1:2", 3),
                    Arguments.arguments("1,2", 3),
                    Arguments.arguments("1,2:3", 6)
            );
        }
    }

    @Nested
    @DisplayName("커스텀 구분자 처리 테스트")
    class CustomDelimiterTest {

        @ParameterizedTest
        @MethodSource("customDelimeterStringInputArguments")
        @DisplayName("커스텀 구분자를 인식하여 합을 반환한다.")
        void customDelimeterStringInputTest(String value, int expected) {
            assertEquals(expected, StringCalculator.add(value));
        }

        private static Stream<Arguments> customDelimeterStringInputArguments() {
            return Stream.of(
                    Arguments.arguments(
                            Arguments.arguments("//;\\n1;2;3;4", 10),
                            Arguments.arguments("//;\\n1,2;3,4", 10),
                            Arguments.arguments("//;\\n1,2;3,4", 10),
                            Arguments.arguments("//;\\n1,2;3,4", 10),
                            Arguments.arguments("//;\\n1,2,3,4", 10)
                    )
            );
        }

    }

    @Nested
    @DisplayName("예외 처리 테스트")
    class ExceptionThrowingTest {

        @ParameterizedTest
        @MethodSource("negativeIncludedStringInputArguments")
        @DisplayName("음수가 포함될 경우 RuntimeException이 발생한다.")
        void negativeInputExceptionThrowTest(String value) {
            assertThrows(RuntimeException.class, () -> StringCalculator.add(value));
        }

        @ParameterizedTest
        @MethodSource("noneAcceptedValueIncludedStringInputArguments")
        @DisplayName("숫자 이외의 값이 포함될 경우 RuntimeException이 발생한다.")
        void noneAcceptedValueInputExceptionThrowTest(String value) {
            assertThrows(RuntimeException.class, () -> StringCalculator.add(value));
        }

        @ParameterizedTest
        @MethodSource("spaceIncludedStringInputArguments")
        @DisplayName("공백이 포함될 경우 RuntimeException이 발생한다.")
        void spaceIncludedInputExceptionThrowTest(String value) {
            assertThrows(RuntimeException.class, () -> StringCalculator.add(value));
        }

        private static Stream<Arguments> negativeIncludedStringInputArguments() {
            return Stream.of(
                    Arguments.arguments("-1,2:3"),
                    Arguments.arguments("1,-2:3"),
                    Arguments.arguments("1,2:-3"),
                    Arguments.arguments("//;\\n-1,2;3"),
                    Arguments.arguments("//;\\n1,-2;3"),
                    Arguments.arguments("//;\\n1,2;-3")
            );
        }

        private static Stream<Arguments> noneAcceptedValueIncludedStringInputArguments() {
            return Stream.of(
                    Arguments.arguments("a,2:3"),
                    Arguments.arguments("1,+2:3"),
                    Arguments.arguments("1,2:*3"),
                    Arguments.arguments("//;\\n-1,2;3,(,4")
            );

        }

        private static Stream<Arguments> spaceIncludedStringInputArguments() {
            return Stream.of(
                    Arguments.arguments("1,2 3"),
                    Arguments.arguments("1, "),
                    Arguments.arguments(" "),
                    Arguments.arguments("//;\\n ;2;3"),
                    Arguments.arguments("//;\\n "),
                    Arguments.arguments("//;\\n1; ;3")
            );
        }
    }

}
