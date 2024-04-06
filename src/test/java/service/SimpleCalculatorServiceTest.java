package service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SimpleCalculatorServiceTest {

    private static final SimpleCalculateService SIMPLE_CALCULATE_SERVICE = new SimpleCalculateService();

    private static Stream<Arguments> methodSourceOfPlus() {
        return Stream.of(
            Arguments.arguments("1", "1", 2),
            Arguments.arguments("+1", "+2.2", 3),
            Arguments.arguments("1.2", "2.8", 4)
        );
    }


    @ParameterizedTest(name = "{0} + {1} = {2}")
    @MethodSource("methodSourceOfPlus")
    @DisplayName("숫자 형식의 문자열 두 개가 들어오면 정상적으로 더해진(+) 값이 반환된다.")
    void plusTest(String x, String y, long result) {
        assertEquals(SIMPLE_CALCULATE_SERVICE.plus(x, y), result);
    }


    private static Stream<Arguments> methodSourceOfMinus() {
        return Stream.of(
            Arguments.arguments("3", "2.0", 1),
            Arguments.arguments("3.0", "4.0", -1),
            Arguments.arguments("+3.0", "2.8", 0),
            Arguments.arguments("+3.5", "+2.2", 1)
        );
    }

    @ParameterizedTest(name = "{0} - {1} = {2}")
    @MethodSource("methodSourceOfMinus")
    @DisplayName("숫자 형식의 문자열 두 개가 들어오면 정상적으로 빼진(-) 값이 반환된다.")
    void minusTest(String x, String y, long result) {
        assertEquals(SIMPLE_CALCULATE_SERVICE.minus(x, y), result);
    }


    private static Stream<Arguments> methodSourceOfMultiply() {
        return Stream.of(
            Arguments.arguments("3", "2", 6),
            Arguments.arguments("3", "-4", -12),
            Arguments.arguments("3.0", "2.8", 8),
            Arguments.arguments("-2", "-4.0", 8),
            Arguments.arguments("3.5", "2.2", 7)
        );
    }

    @ParameterizedTest(name = "{0} x {1} = {2}")
    @MethodSource("methodSourceOfMultiply")
    @DisplayName("숫자 형식의 문자열 두 개가 들어오면 정상적으로 곱해진(x) 값이 반환된다.")
    void multiplyTest(String x, String y, long result) {
        assertEquals(SIMPLE_CALCULATE_SERVICE.multiply(x, y), result);
    }


    private static Stream<Arguments> methodSourceOfDivide() {
        return Stream.of(
            Arguments.arguments("6", "2", 3),
            Arguments.arguments("3.0", "+4", 0),
            Arguments.arguments("-6.4", "3.2", -2),
            Arguments.arguments("-5.5", "-1.1", 5)
        );
    }

    @ParameterizedTest(name = "{0} % {1} = {2}")
    @MethodSource("methodSourceOfDivide")
    @DisplayName("숫자 형식의 문자열 두 개가 들어오면 정상적으로 나눠진(%) 값이 반환된다.")
    void divideTest(String x, String y, long result) {
        assertEquals(SIMPLE_CALCULATE_SERVICE.divide(x, y), result);
    }


    private static Stream<Arguments> methodSourceOfNotNumberInput() {
        return Stream.of(
            Arguments.arguments(".1", "3"),
            Arguments.arguments("1", "1.1.1"),
            Arguments.arguments("일", "2"),
            Arguments.arguments("1.0", "x")
        );
    }

    @ParameterizedTest(name = "x = {0}, y = {1}")
    @MethodSource("methodSourceOfNotNumberInput")
    @DisplayName("숫자 형식이 아닌 문자열이 들어오면 에러가 발생한다.")
    void errorCaseOfIllegalInput(String x, String y) {
        assertAll(
            () -> assertThrows(IllegalArgumentException.class, () -> SIMPLE_CALCULATE_SERVICE.plus(x, y)),
            () -> assertThrows(IllegalArgumentException.class, () -> SIMPLE_CALCULATE_SERVICE.minus(x, y)),
            () -> assertThrows(IllegalArgumentException.class, () -> SIMPLE_CALCULATE_SERVICE.divide(x, y)),
            () -> assertThrows(IllegalArgumentException.class, () -> SIMPLE_CALCULATE_SERVICE.multiply(x, y))
        );
    }
}
