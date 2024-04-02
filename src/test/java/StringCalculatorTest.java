import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("StringCalculator 클래스")
class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @Nested
    @DisplayName("add 메소드는")
    class DescribeAdd {

        @Nested
        @DisplayName("만약 [,] [:] 과 같은 기본 구분자를 가진 식이 주어지면")
        class ContextWithBasicExpression {

            @ParameterizedTest
            @CsvSource(
                    textBlock = """
                            '1,2:3', 6
                            '1, 2,3,', 6
                            '', 0
                            '    ', 0
                            '5', 5
                            """
            )
            @DisplayName("구분자로 분리한 숫자들의 합을 반환한다.")
            void add_basicExpression(String expression, int actualValue) {
                // when
                int result = calculator.add(expression);

                // then
                assertEquals(result, actualValue);
            }
        }

        @Nested
        @DisplayName("만약 커스텀한 구분자를 가진 식이 주어진다면")
        class ContextWithCustomExpression {

            @ParameterizedTest
            @CsvSource(textBlock = """
                    '//t\n', 0
                    '//t\n1t2', 3
                    '//t\n1t t2t3t', 6
                    """)
            @DisplayName("커스텀한 구분자로 분리한 숫자들의 합을 반환합니다.")
            void add_customExpression(String expression, int actualValue) {
                // when
                int result = calculator.add(expression);

                // then
                assertEquals(result, actualValue);
            }
        }

        @Nested
        @DisplayName("만약 기본 구분자와 다른 구분자를 가진 식이 주어진다면")
        class ContextWithWrongBasicExpression {

            @ParameterizedTest
            @ValueSource(strings = {"1;2,3", "1,2,3;", "'"})
            @DisplayName("포맷이 잘못되었다는 예외를 발생시킵니다.")
            void add_exception_withWrongBasicExpression(String expression) {
                // when
                String message = assertThrows(RuntimeException.class, () -> calculator.add(expression)).getMessage();

                // then
                assertEquals(message, "표현식의 입력이 잘못됐습니다. [잘못된 표현식 포맷]");
            }
        }

        @Nested
        @DisplayName("만약 커스텀 구분자와 다른 구분자를 가진 식이 주어진다면")
        class ContextWithWrongCustomExpression {

            @ParameterizedTest
            @ValueSource(strings = {"//;\n1:2:3", "//;\n1,2,3;", "//;n\n'"})
            @DisplayName("포맷이 잘못되었다는 예외를 발생시킵니다.")
            void add_exception_withWrongBasicExpression(String expression) {
                // when
                String message = assertThrows(RuntimeException.class, () -> calculator.add(expression)).getMessage();

                // then
                assertEquals(message, "표현식의 입력이 잘못됐습니다. [잘못된 표현식 포맷]");
            }
        }

        @Nested
        @DisplayName("만약 음수가 포함된 식이 주어진다면")
        class ContextWithNegativeValueInExpression {

            @ParameterizedTest
            @ValueSource(strings = {"//;\n1;2;-3", "1,-2:3", "//;\n-1", "-1"})
            @DisplayName("음수는 입력할 수 없다는 예외를 발생시킵니다.")
            void add_exception_withWrongBasicExpression(String expression) {
                // when
                String message = assertThrows(RuntimeException.class, () -> calculator.add(expression)).getMessage();

                // then
                assertEquals(message, "표현식의 입력이 잘못됐습니다. [음수 입력 예외]");
            }
        }

        @Nested
        @DisplayName("만약 숫자 이외의 값이 주어진다면")
        class ContextWithNonNumberExpression {

            @ParameterizedTest
            @ValueSource(strings = {"//;\na;b;c", "a,d:3", "//;\no", "g"})
            @DisplayName("포맷이 잘못되었다는 예외를 발생시킵니다.")
            void add_exception_withWrongBasicExpression(String expression) {
                // when
                String message = assertThrows(RuntimeException.class, () -> calculator.add(expression)).getMessage();

                // then
                assertEquals(message, "표현식의 입력이 잘못됐습니다. [잘못된 표현식 포맷]");
            }
        }
    }
}
