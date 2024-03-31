package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("계산기 테스트")
class CalculatorTest {

    private static final Calculator calculator = new Calculator();

    private static Stream<Arguments> methodSourceOfPlus() {
        return Stream.of(
            Arguments.arguments(1.0, 1.0, 2),
            Arguments.arguments(1.0, 2.2, 3),
            Arguments.arguments(1.2, 2.8, 4)
        );
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @MethodSource("methodSourceOfPlus")
    @DisplayName("숫자 두 개가 들어오면 정상적으로 더해진(+) 값이 반환된다.")
    void plusTest(double x, double y, long result) {
        assertEquals(calculator.plus(x, y), result);
    }

    private static Stream<Arguments> methodSourceOfMinus() {
        return Stream.of(
            Arguments.arguments(3.0, 2.0, 1),
            Arguments.arguments(3.0, 4.0, -1),
            Arguments.arguments(3.0, 2.8, 0),
            Arguments.arguments(3.5, 2.2, 1)
        );
    }

    @ParameterizedTest(name = "{0} - {1} = {2}")
    @MethodSource("methodSourceOfMinus")
    @DisplayName("숫자 두 개가 들어오면 정상적으로 빼진(-) 값이 반환된다.")
    void minusTest(double x, double y, long result) {
        assertEquals(calculator.minus(x, y), result);
    }

    private static Stream<Arguments> methodSourceOfMultiply() {
        return Stream.of(
            Arguments.arguments(3.0, 2.0, 6),
            Arguments.arguments(3.0, -4.0, -12),
            Arguments.arguments(3.0, 2.8, 8),
            Arguments.arguments(-2.0, -4.0, 8),
            Arguments.arguments(3.5, 2.2, 7)
        );
    }

    @ParameterizedTest(name = "{0} x {1} = {2}")
    @MethodSource("methodSourceOfMultiply")
    @DisplayName("숫자 두 개가 들어오면 정상적으로 곱해진(x) 값이 반환된다.")
    void multiplyTest(double x, double y, long result) {
        assertEquals(calculator.multiply(x, y), result);
    }


    private static Stream<Arguments> methodSourceOfDivide() {
        return Stream.of(
            Arguments.arguments(6.0, 2.0, 3),
            Arguments.arguments(3.0, 4.0, 0),
            Arguments.arguments(-6.4, 3.2, -2),
            Arguments.arguments(-5.5, -1.1, 5)
        );
    }

    @ParameterizedTest(name = "{0} / {1} = {2}")
    @MethodSource("methodSourceOfDivide")
    @DisplayName("숫자 두 개가 들어오면 정상적으로 나눠진(%) 값이 반환된다.")
    void divideTest(double x, double y, long result) {
        assertEquals(calculator.divide(x, y), result);
    }

    @Test
    @DisplayName("두 번째 인자 값이 0이면 나누기(%) 계산시 에러가 발생한다.")
    void errorCaseOfDivideTest() {
        assertAll(
            () -> assertThrows(IllegalArgumentException.class, () -> calculator.divide(1.0, 0.0)),
            () -> assertThrows(IllegalArgumentException.class, () -> calculator.divide(3, calculator.minus(3,3)))
        );
    }

}
