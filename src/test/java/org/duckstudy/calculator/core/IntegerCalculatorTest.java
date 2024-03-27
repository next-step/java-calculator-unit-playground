package org.duckstudy.calculator.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("정수 계산기 테스트")
public class IntegerCalculatorTest {
    @Nested
    @DisplayName("덧셈 테스트")
    class AddTest {

        @ParameterizedTest
        @MethodSource("methodSourceAddTestArguments")
        @DisplayName("[성공] 덧셈 테스트")
        void addTestSuccess(int expected, int... values) {
            // given
            IntegerCalculator ic = new IntegerCalculator();
            int result = 0;

            // when
            for (int value : values) {
                result = ic.add(value);
            }

            // then
            assertEquals(expected, result);
        }

        private static Stream<Arguments> methodSourceAddTestArguments() {
            return Stream.of(
                    Arguments.arguments(3, new int[]{1, 2}),
                    Arguments.arguments(9, new int[]{4, 5})
            );
        }
    }

    @Nested
    @DisplayName("뺄셈 테스트")
    class SubractTest {

        @ParameterizedTest
        @MethodSource("methodSourceSubtractTestArguments")
        @DisplayName("[성공] 뺄셈 테스트")
        void addTestSuccess(int expected, int... values) {
            // given
            IntegerCalculator ic = new IntegerCalculator();

            // when
            int result = 0;
            for (int value : values) {
                result = ic.subtract(value);
            }

            // then
            assertEquals(expected, result);
        }

        private static Stream<Arguments> methodSourceSubtractTestArguments() {
            return Stream.of(
                    Arguments.arguments(-4, new int[]{2, 2}),
                    Arguments.arguments(-9, new int[]{4, 5})
            );
        }
    }

    @Nested
    @DisplayName("곱셈 테스트")
    class MultiplyTest {

        @ParameterizedTest
        @MethodSource("methodSourceSubtractTestArguments")
        @DisplayName("[성공] 곱셈 테스트")
        void addTestSuccess(int expected, int... values) {
            // given
            IntegerCalculator ic = new IntegerCalculator();
            ic.add(2);

            // when
            int result = 0;
            for (int value : values) {
                result = ic.multiply(value);
            }

            // then
            assertEquals(expected, result);
        }

        private static Stream<Arguments> methodSourceSubtractTestArguments() {
            return Stream.of(
                    Arguments.arguments(12, new int[]{2, 3}),
                    Arguments.arguments(-40, new int[]{4, -5})
            );
        }
    }

    @Nested
    @DisplayName("나눗셈 테스트")
    class DivideTest {

        @ParameterizedTest
        @MethodSource("methodSourceSubtractTestArguments")
        @DisplayName("[성공] 나눗셈 테스트")
        void addTestSuccess(int expected, int... values) {
            // given
            IntegerCalculator ic = new IntegerCalculator();
            ic.add(12);

            // when
            int result = 0;
            for (int value : values) {
                result = ic.divide(value);
            }
            // then
            assertEquals(expected, result);
        }

        private static Stream<Arguments> methodSourceSubtractTestArguments() {
            return Stream.of(
                    Arguments.arguments(2, new int[]{2, 3}),
                    Arguments.arguments(1, new int[]{4, 3})
            );
        }

        @Test
        @DisplayName("[실패] 나눗셈 테스트")
        void addTestFail() {
            // given
            IntegerCalculator ic = new IntegerCalculator();
            ic.add(12);

            // when, then
            assertThrows(ArithmeticException.class, () -> ic.divide(0));
        }
    }

}