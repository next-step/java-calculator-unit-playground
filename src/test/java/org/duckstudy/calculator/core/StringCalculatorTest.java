package org.duckstudy.calculator.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("문자열 계산기 테스트")
class StringCalculatorTest {

    private StringCalculator sc = new StringCalculator();

    @AfterEach
    void tearDown() {
        sc.reset();
    }

    @Nested
    @DisplayName("덧셈 테스트")
    class AddTest {

        @ParameterizedTest
        @MethodSource("methodSourceAddTestWithDefaultDelimiterSuccessArguments")
        @DisplayName("기본 구분자를 통해 각 숫자의 합을 반환한다")
        void addTestWithDefaultDelimiterSuccess(int expected, String value) {
            Integer actual = sc.add(value);

            assertThat(actual).isEqualTo(expected);
        }

        private static Stream<Arguments> methodSourceAddTestWithDefaultDelimiterSuccessArguments() {
            return Stream.of(
                    Arguments.arguments(0, ""),
                    Arguments.arguments(3, "1,2"),
                    Arguments.arguments(6, "1,2:3")
            );
        }

        @ParameterizedTest
        @MethodSource("methodSourceAddTestWithCustomDelimiterSuccessArguments")
        @DisplayName("커스텀 구분자를 입력받는 경우 커스텀 구분자를 통해 각 숫자의 합을 반환한다")
        void addTestWithCustomDelimiterSuccess(int expected, String value) {
            Integer actual = sc.add(value);

            assertThat(actual).isEqualTo(expected);
        }

        private static Stream<Arguments> methodSourceAddTestWithCustomDelimiterSuccessArguments() {
            return Stream.of(
                    Arguments.arguments(6, "//abc\\n1abc2abc3"),
                    Arguments.arguments(10, "//!\\n1,2:3!4")
            );
        }

        @ParameterizedTest
        @MethodSource("methodSourceAddTestFailArguments")
        @DisplayName("숫자 이외의 값 또는 음수 전달시 RuntimeException 발생한다")
        void addTestFail(String value) {
            // given, when, then
            assertThatThrownBy(() -> sc.add(value))
                    .isExactlyInstanceOf(RuntimeException.class)
                    .hasMessage("Invalid input");
        }

        private static Stream<Arguments> methodSourceAddTestFailArguments() {
            return Stream.of(
                    Arguments.arguments("//;\\n1;k;3"),
                    Arguments.arguments("//;\\n-1;2;3"),
                    Arguments.arguments("//;\\n;;;2;3"),
                    Arguments.arguments("//;\\n;1.1;2;3")

            );
        }

        @ParameterizedTest
        @MethodSource("methodSourceAddTestFailCustomDelimiterArguments")
        @DisplayName("커스텀 구분자를 제대로 지정하지 않을 경우 RuntimeException 발생한다")
        void addTestFailCustomDelimiter(String value) {
            // given, when, then
            assertThatThrownBy(() -> sc.add(value))
                    .isExactlyInstanceOf(RuntimeException.class)
                    .hasMessage("Invalid input");
        }

        private static Stream<Arguments> methodSourceAddTestFailCustomDelimiterArguments() {
            return Stream.of(
                    Arguments.arguments("/;\\n1,2:3;4"),
                    Arguments.arguments("//;\\k1,2:3;4"),
                    Arguments.arguments("a;\\n1,2:3;4")
            );
        }
    }
}
