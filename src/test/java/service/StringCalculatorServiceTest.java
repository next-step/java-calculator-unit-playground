package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class StringCalculatorServiceTest {

    static StringCalculatorService stringCalculatorService;

    @BeforeEach
    void makeStringCalculatorService() {
        stringCalculatorService = new StringCalculatorService();
    }


    @ParameterizedTest(name = "{0}을 입력하면 커스텀 구분자 {1}이 추출된다.")
    @CsvSource({"//.\\n, .", "//~\\n, ~", "//123\\n, 123"})
    @DisplayName("//과 \\n 사이의 string은 커스텀 구분자이다")
    void testCustomSeparator(String expression, String expectedCustomSeparator) {
        assertEquals(stringCalculatorService.getCustomSeparator(expression), expectedCustomSeparator);
    }

    private static Stream<Arguments> validMethodSourceOfPlusAllTokens() {
        return Stream.of(
            Arguments.arguments(List.of("1", "2", "3"), 6),
            Arguments.arguments(List.of("10", "20", "30", "40"), 100)
        );
    }

    @ParameterizedTest(name = "{0}을 모두 더한 값은 {1}이다.")
    @MethodSource("validMethodSourceOfPlusAllTokens")
    @DisplayName("유효한 String[] 숫자 배열이 주어지면 그 값을 모두 더한 값이 return 된다.")
    void validTestOfPlusAllTokens(List<String> tokens, int expectedResult) {
        assertEquals(stringCalculatorService.plusAllTokens(tokens), expectedResult);
    }

    private static Stream<Arguments> invalidMethodSourceOfPlusAllTokens() {
        return Stream.of(
            Arguments.arguments(List.of("-1", "0", "1")),
            Arguments.arguments(List.of("a", "1", "2")),
            Arguments.arguments(List.of(".", "3"))
        );
    }

    @ParameterizedTest(name = "숫자가 아니거나 음수가 포함된 값 {0}을 입력하면 에러가 반환된다.")
    @MethodSource("invalidMethodSourceOfPlusAllTokens")
    @DisplayName("숫자가 아니거나 음수인 값이 들어오면 에러가 반환된다.")
    void invalidTestOfPlusAllTokens(List<String> tokens) {
        assertThrows(IllegalArgumentException.class, () -> stringCalculatorService.plusAllTokens(tokens));
    }

    private static Stream<Arguments> methodSourceOfGetTokens() {
        return Stream.of(
            Arguments.arguments("1,2,3", List.of("1", "2", "3")),
            Arguments.arguments("//.\\n1.2:3.4", List.of("1", "2", "3", "4")),
            Arguments.arguments("//[\\n1[2[3", List.of("1", "2", "3")),
            Arguments.arguments("//!\\n1!2!3", List.of("1", "2", "3"))
        );
    }

    @ParameterizedTest(name = "{0}의 입력에서 더할 숫자들의 집합은 {1}이다.")
    @MethodSource("methodSourceOfGetTokens")
    @DisplayName("기본 구분자 ','와 ':' 그리고 커스텀 구분자를 활용하여 더할 숫자들의 집합을 구할 수 있다.")
    void getTokensTest(String expression, List<String> expectedTokens) {
        assertEquals(stringCalculatorService.getTokens(expression), expectedTokens);
    }

    private static Stream<Arguments> methodSourceOfCalculateTest() {
        return Stream.of(
            Arguments.arguments("1,2|3", 6),
            Arguments.arguments("//|\\n10|20:30", 60),
            Arguments.arguments("//.\\n10.20:30,40", 100)
        );
    }

    @ParameterizedTest(name = "{0}의 입력의 문자열 계산기 결과값은 {2}이다.")
    @MethodSource("methodSourceOfCalculateTest")
    @DisplayName("기본 구분자와 커스텀 구분자를 활용하여 숫자를 구분해내고 그 합을 정상적으로 반환할 수 있다.")
    void calculateTest(String expression, int expectedResult) {
        assertEquals(stringCalculatorService.calculate(expression), expectedResult);
    }

}
