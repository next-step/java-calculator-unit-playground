import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    private static final String CUSTOM_SEPARATOR_STARTER = CalculatorConstant.CUSTOM_SEPARATOR_STARTER;
    private static final String CUSTOM_SEPARATOR_TERMINATOR = CalculatorConstant.CUSTOM_SEPARATOR_TERMINATOR;
    private static final List<Integer> TEST_NUMBERS = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);

    private final Calculator calculator = new Calculator();

    @Nested
    class Add {

        @Test
        @DisplayName("0에 0을 더한다")
        void zero_zero() {
            // given
            int a = 0;
            int b = 0;
            int expectedResult = a + b;

            // when
            int actualResult = calculator.add(a, b);

            // then
            assertThat(actualResult).isEqualTo(expectedResult);
        }

        @Test
        @DisplayName("오버플로우 발생")
        void overflow() {
            // given
            int a = Integer.MAX_VALUE;
            int b = 1;

            // then
            assertThatThrownBy(() -> calculator.add(a, b))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("언더플로우 발생")
        void underflow() {
            // given
            int a = Integer.MIN_VALUE;
            int b = -1;

            // then
            assertThatThrownBy(() -> calculator.add(a, b))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("양수에 양수를 더한다")
        void positive_positive() {
            // given
            int a = 6;
            int b = 3;
            int expectedResult = a + b;

            // when
            int actualResult = calculator.add(a, b);

            // then
            assertThat(actualResult).isEqualTo(expectedResult);
        }

        @Test
        @DisplayName("양수에 음수를 더한다")
        void positive_negative() {
            // given
            int a = 6;
            int b = -3;
            int expectedResult = a + b;

            // when
            int actualResult = calculator.add(a, b);

            // then
            assertThat(actualResult).isEqualTo(expectedResult);
        }

        @Test
        @DisplayName("음수에 양수를 더한다")
        void negative_positive() {
            // given
            int a = -6;
            int b = 3;
            int expectedResult = a + b;

            // when
            int actualResult = calculator.add(a, b);

            // then
            assertThat(actualResult).isEqualTo(expectedResult);
        }

        @Test
        @DisplayName("음수에 음수를 더한다")
        void negative_negative() {
            // given
            int a = -6;
            int b = -3;
            int expectedResult = a + b;

            // when
            int actualResult = calculator.add(a, b);

            // then
            assertThat(actualResult).isEqualTo(expectedResult);
        }
    }

    @Nested
    class Subtract {

        @Test
        @DisplayName("0에 0을 뺀다")
        void zero_zero() {
            // given
            int a = 0;
            int b = 0;
            int expectedResult = a - b;

            // when
            int actualResult = calculator.subtract(a, b);

            // then
            assertThat(actualResult).isEqualTo(expectedResult);
        }

        @Test
        @DisplayName("오버플로우 발생")
        void overflow() {
            // given
            int a = Integer.MAX_VALUE;
            int b = -1;

            // then
            assertThatThrownBy(() -> calculator.subtract(a, b))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("언더플로우 발생")
        void underflow() {
            // given
            int a = Integer.MIN_VALUE;
            int b = 1;

            // then
            assertThatThrownBy(() -> calculator.subtract(a, b))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("양수에 양수를 뺀다")
        void positive_positive() {
            // given
            int a = 6;
            int b = 3;
            int expectedResult = a - b;

            // when
            int actualResult = calculator.subtract(a, b);

            // then
            assertThat(actualResult).isEqualTo(expectedResult);
        }

        @Test
        @DisplayName("양수에 음수를 뺀다")
        void positive_negative() {
            // given
            int a = 6;
            int b = -3;
            int expectedResult = a - b;

            // when
            int actualResult = calculator.subtract(a, b);

            // then
            assertThat(actualResult).isEqualTo(expectedResult);
        }

        @Test
        @DisplayName("음수에 양수를 뺀다")
        void negative_positive() {
            // given
            int a = -6;
            int b = 3;
            int expectedResult = a - b;

            // when
            int actualResult = calculator.subtract(a, b);

            // then
            assertThat(actualResult).isEqualTo(expectedResult);
        }

        @Test
        @DisplayName("음수에 음수를 뺀다")
        void negative_negative() {
            // given
            int a = -6;
            int b = -3;
            int expectedResult = a - b;

            // when
            int actualResult = calculator.subtract(a, b);

            // then
            assertThat(actualResult).isEqualTo(expectedResult);
        }
    }

    @Nested
    class Multiply {

        @Test
        @DisplayName("0에 0을 곱한다")
        void zero_zero() {
            // given
            int a = 0;
            int b = 0;
            int expectedResult = a * b;

            // when
            int actualResult = calculator.multiply(a, b);

            // then
            assertThat(actualResult).isEqualTo(expectedResult);
        }

        @Test
        @DisplayName("오버플로우 발생")
        void overflow() {
            // given
            int a = Integer.MAX_VALUE;
            int b = 2;

            // then
            assertThatThrownBy(() -> calculator.multiply(a, b))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("언더플로우 발생")
        void underflow() {
            // given
            int a = Integer.MIN_VALUE;
            int b = 2;

            // then
            assertThatThrownBy(() -> calculator.multiply(a, b))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("양수에 양수를 곱한다")
        void positive_positive() {
            // given
            int a = 6;
            int b = 3;
            int expectedResult = a * b;

            // when
            int actualResult = calculator.multiply(a, b);

            // then
            assertThat(actualResult).isEqualTo(expectedResult);
        }

        @Test
        @DisplayName("양수에 음수를 곱한다")
        void positive_negative() {
            // given
            int a = 6;
            int b = -3;
            int expectedResult = a * b;

            // when
            int actualResult = calculator.multiply(a, b);

            // then
            assertThat(actualResult).isEqualTo(expectedResult);
        }

        @Test
        @DisplayName("음수에 양수를 곱한다")
        void negative_positive() {
            // given
            int a = -6;
            int b = 3;
            int expectedResult = a * b;

            // when
            int actualResult = calculator.multiply(a, b);

            // then
            assertThat(actualResult).isEqualTo(expectedResult);
        }

        @Test
        @DisplayName("음수에 음수를 곱한다")
        void negative_negative() {
            // given
            int a = -6;
            int b = -3;
            int expectedResult = a * b;

            // when
            int actualResult = calculator.multiply(a, b);

            // then
            assertThat(actualResult).isEqualTo(expectedResult);
        }
    }

    @Nested
    class Divide {

        @Test
        @DisplayName("0으로 나눌 경우 예외가 발생한다")
        void divideZero() {
            // given
            int a = 6;
            int b = 0;

            // then
            assertThatThrownBy(() -> calculator.divide(a, b))
                    .isInstanceOf(ArithmeticException.class);
        }

        @Test
        @DisplayName("양수에 양수를 나눈다")
        void positive_positive() {
            // given
            int a = 6;
            int b = 3;
            int expectedResult = a / b;

            // when
            int actualResult = calculator.divide(a, b);

            // then
            assertThat(actualResult).isEqualTo(expectedResult);
        }

        @Test
        @DisplayName("양수에 음수를 나눈다")
        void positive_negative() {
            // given
            int a = 6;
            int b = -3;
            int expectedResult = a / b;

            // when
            int actualResult = calculator.divide(a, b);

            // then
            assertThat(actualResult).isEqualTo(expectedResult);
        }

        @Test
        @DisplayName("음수에 양수를 나눈다")
        void negative_positive() {
            // given
            int a = -6;
            int b = 3;
            int expectedResult = a / b;

            // when
            int actualResult = calculator.divide(a, b);

            // then
            assertThat(actualResult).isEqualTo(expectedResult);
        }

        @Test
        @DisplayName("음수에 음수를 나눈다")
        void negative_negative() {
            // given
            int a = -6;
            int b = -3;
            int expectedResult = a / b;

            // when
            int actualResult = calculator.divide(a, b);

            // then
            assertThat(actualResult).isEqualTo(expectedResult);
        }
    }

    @Nested
    class AddFromString {

        @ParameterizedTest
        @DisplayName("기본 구분자를 사용한다")
        @ValueSource(strings = {",", ":"})
        void useBasicSeparator(String separator) {
            // given
            String input = addAllInputGenerator.BASIC_SEPARATOR.createInputFromList(TEST_NUMBERS, separator);
            int expectedResult = getSumOfList(TEST_NUMBERS);

            // when
            int actualResult = calculator.addAll(input);

            // then
            assertThat(actualResult).isEqualTo(expectedResult);
        }

        @Test
        @DisplayName("여러 기본 구분자들을 동시에 사용한다")
        void useBasicSeparators() {
            // given
            String input = "1,2:3,4,5:6:7,8,9:10";
            int expectedResult = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10;

            // when
            int actualResult = calculator.addAll(input);

            // then
            assertThat(actualResult).isEqualTo(expectedResult);
        }

        @ParameterizedTest
        @DisplayName("한 글자인 커스텀 구분자를 사용한다")
        @ValueSource(strings = {"=", "/", ".", "^", "$", "*", "|"})
        void customSeparator_oneLetter(String separator) {
            // given
            String input = addAllInputGenerator.CUSTOM_SEPARATOR.createInputFromList(TEST_NUMBERS, separator);
            int expectedResult = getSumOfList(TEST_NUMBERS);

            // when
            int actualResult = calculator.addAll(input);

            // then
            assertThat(actualResult).isEqualTo(expectedResult);
        }

        @Test
        @DisplayName("두 글자인 커스텀 구분자를 사용한다")
        void customSeparator_twoLetters() {
            // given
            String input = addAllInputGenerator.CUSTOM_SEPARATOR.createInputFromList(TEST_NUMBERS, "/@");
            int expectedResult = getSumOfList(TEST_NUMBERS);
            System.out.println("input = " + input);

            // when
            int actualResult = calculator.addAll(input);

            // then
            assertThat(actualResult).isEqualTo(expectedResult);
        }

        @Test
        @DisplayName("공백 커스텀 구분자를 사용한다")
        void customSeparator_whiteSpace() {
            // given
            String input = addAllInputGenerator.CUSTOM_SEPARATOR.createInputFromList(TEST_NUMBERS, " ");
            int expectedResult = getSumOfList(TEST_NUMBERS);

            // when
            int actualResult = calculator.addAll(input);

            // then
            assertThat(actualResult).isEqualTo(expectedResult);
        }

        @Test
        @DisplayName("값이 없는 커스텀 구분자 사용시 예외가 발생한다")
        void customSeparator_empty() {
            // given
            String input = addAllInputGenerator.CUSTOM_SEPARATOR.createInputFromList(TEST_NUMBERS, "");

            // then
            assertThatThrownBy(() -> calculator.addAll(input))
                    .isInstanceOf(RuntimeException.class);
        }

        @Test
        @DisplayName("음수 전달시 에외가 발생한다")
        void negativeException() {
            // given
            String input = addAllInputGenerator.BASIC_SEPARATOR.createInputFromList(List.of(1, 2, 3, 4, -5, 6, 7, 8, 9), ",");

            // then
            assertThatThrownBy(() -> calculator.addAll(input))
                    .isInstanceOf(RuntimeException.class);
        }

        @ParameterizedTest
        @DisplayName("형식이 부적절한 커스텀 구분자를 전달시 예외가 발생한다")
        @ValueSource(strings = {
                "/-\n1-2-3-4-5-6-7-8-9-10", // 앞 부분의 형식이 부적절함
                "//-\\n1-2-3-4-5-6-7-8-9-10" // 뒷 부분의 형식이 부적절함
        })
        void illegalCustomSeparatorException(String input) {
            assertThatThrownBy(() -> calculator.addAll(input))
                    .isInstanceOf(RuntimeException.class);
        }

        @ParameterizedTest
        @DisplayName("선언되지 않은 커스텀 구분자 사용시 예외가 발생한다")
        @ValueSource(strings = {
                "1$2$3$4$5$6$7$8$9$10",
                "//%\n1-2-3-4-5-6-7-8-9-10"
        })
        void notDeclareCustomSeparator(String input) {
            assertThatThrownBy(() -> calculator.addAll(input))
                    .isInstanceOf(RuntimeException.class);
        }

        @Test
        @DisplayName("실수 전달시 예외가 발생한다")
        void floatException() {
            // given
            String input = "1,2,3.3,4,5,6,7,8,9,10";

            // then
            assertThatThrownBy(() -> calculator.addAll(input))
                    .isInstanceOf(RuntimeException.class);
        }
    }

    private int getSumOfList(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }

        return sum;
    }

    enum addAllInputGenerator {
        BASIC_SEPARATOR {
            @Override
            String createInputFromList(List<Integer> numbers, String separator) {
                StringBuilder builder = new StringBuilder();

                for (Integer number : numbers) {
                    builder.append(number)
                            .append(separator);
                }

                return builder.delete(builder.length() - separator.length(), builder.length())
                        .toString();
            }
        },
        CUSTOM_SEPARATOR {
            @Override
            String createInputFromList(List<Integer> numbers, String separator) {
                StringBuilder builder = new StringBuilder()
                        .append(CUSTOM_SEPARATOR_STARTER)
                        .append(separator)
                        .append(CUSTOM_SEPARATOR_TERMINATOR);

                for (Integer number : numbers) {
                    builder.append(number)
                            .append(separator);
                }

                return builder.delete(builder.length() - separator.length(), builder.length())
                        .toString();
            }
        };

        abstract String createInputFromList(List<Integer> numbers, String separator);
    }
}
