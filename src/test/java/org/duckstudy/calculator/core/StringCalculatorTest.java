package org.duckstudy.calculator.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("문자열 계산기 테스트")
public class StringCalculatorTest {

    private StringCalculator sc = new StringCalculator();

    @AfterEach
    void tearDown() {
        sc.reset();
    }

    @Nested
    @DisplayName("덧셈 테스트")
    class AddTest {

        @ParameterizedTest
        @MethodSource("methodSourceAddTestSuccessArguments")
        @DisplayName("구분자를 기준으로 분리한 각 숫자의 합을 반환한다")
        void addTestSuccess(int expected, String value) {
            // given
            int result = 0;

            // when
            result = sc.add(value);

            // then
            assertEquals(expected, result);
        }

        private static Stream<Arguments> methodSourceAddTestSuccessArguments() {
            return Stream.of(
                    Arguments.arguments(0, ""),
                    Arguments.arguments(3, "1,2"),
                    Arguments.arguments(6, "1,2,3"),
                    Arguments.arguments(6, "1,2:3"),

                    Arguments.arguments(6, "//;\\n1;2;3"),
                    Arguments.arguments(6, "//!\\n1!2!3"),
                    Arguments.arguments(6, "//!!\\n1!!2!!3"),
                    Arguments.arguments(6, "//abc\\n1abc2abc3"),
                    Arguments.arguments(10, "//abc\\n1,2:3abc4")
            );
        }

        @ParameterizedTest
        @MethodSource("methodSourceAddTestFailArguments")
        @DisplayName("숫자 이외의 값 또는 음수 전달시 RuntimeException 발생한다")
        void addTestFail(String value) {
            // given

            // when, then
            assertAll(
                    () -> assertThrowsExactly(RuntimeException.class, () -> sc.add(value))

            );
        }

        private static Stream<Arguments> methodSourceAddTestFailArguments() {
            return Stream.of(
                    Arguments.arguments("//;\\n1;k;3"),
                    Arguments.arguments("//;\\n-1;2;3"),
                    Arguments.arguments("//;\\n1;-1;3"),
                    Arguments.arguments("//;\\n;;;2;3")
            );
        }
    }
}
