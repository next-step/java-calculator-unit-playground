package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("계산기 테스트")
public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Nested
    @DisplayName("Calculator 클래스의 덧셈, 뺄셈, 곱셈, 나눗셈 메서드는")
    class CalculatorMethods {
        @Nested
        @DisplayName("덧셈에서")
        class AddTest {

            @ParameterizedTest
            @CsvSource({"1, 2, 3", "10, 20, 30", "-9, 15, 6"})
            @DisplayName("두 수를 더한 값을 반환한다")
            void return_sum(int num1, int num2, int expected) {
                // assertEquals(expected, calculator.add(num1, num2));
                assertThat(calculator.add(num1, num2)).isEqualTo(expected);

            }
        }

        @Nested
        @DisplayName("뺄셈에서")
        class SubtractTest {

            @ParameterizedTest
            @CsvSource({"1, 2, -1", "20, 10, 10", "-9, 15, -24"})
            @DisplayName("두 수를 뺀 값을 반환한다")
            void return_subtract(int num1, int num2, int expected) {
                // assertEquals(expected, calculator.subtract(num1, num2));
                assertThat(calculator.subtract(num1, num2)).isEqualTo(expected);
            }
        }

        @Nested
        @DisplayName("곱셈 테스트")
        class MultiplyTest {

            @ParameterizedTest
            @CsvSource({"1, 2, 2", "20, 10, 200", "-9, 5, -45"})
            @DisplayName("두 수를 곱한 값을 반환하는 테스트")
            void return_multiply(int num1, int num2, int expected) {
                // assertEquals(expected, calculator.multiply(num1, num2));
                assertThat(calculator.multiply(num1, num2)).isEqualTo(expected);
            }
        }

        @Nested
        @DisplayName("나눗셈에서")
        class DivideTest {

            @ParameterizedTest
            @CsvSource({"4, 2, 2", "20, 10, 2", "-9, 5, -2"})
            @DisplayName("두 수를 나눈 값을 반환한다")
            void return_divide(int num1, int num2, int result) {
                // assertEquals(result, calculator.divide(num1, num2));
                assertThat(calculator.divide(num1, num2)).isEqualTo(result);
            }

            @Test
            @DisplayName("0으로 나누면 예외를 발생시킨다")
            void return_multiply_fail_zero_division() {
                // assertThrows(IllegalArgumentException.class, () -> calculator.divide(10, 0));
                assertThatThrownBy(() -> calculator.divide(10, 0))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("0으로 나눌 수 없습니다.");
            }
        }

        @Nested
        @DisplayName("산술 연산 결과가 유효하지 않을 때")

        class ArithmeticExceptionTest {

            @Test
            @DisplayName("소수점 결과는 반올림하여 정수(long)로 반환한다")
            void should_round_half_up() {
                // 0.5는 1로, 0.4는 0으로 반올림되는지 확인
                assertThat(calculator.add(0.4, 0.5)).isEqualTo(1L); // 0.9 -> 1
                assertThat(calculator.add(0.2, 0.2)).isEqualTo(0L); // 0.4 -> 0
            }

            @Test
            @DisplayName("연산 결과가 long 범위를 초과하면 ArithmeticException이 발생한다")
            void should_throw_exception_when_overflow() {
                double bigValue = Math.pow(10, 20); // long 최대값보다 큰 수

                assertThatThrownBy(() -> calculator.add(bigValue, 1.0))
                    .isInstanceOf(ArithmeticException.class)
                    .hasMessageContaining("산술 연산 결과가 long 타입의 범위를 벗어났습니다.");
            }

            @Test
            @DisplayName("연산 결과가 숫자가 아니면(NaN) ArithmeticException이 발생한다")
            void should_throw_exception_when_nan() {
                // Math.sqrt(-1.0)는 NaN을 반환
                assertThatThrownBy(() -> calculator.divide(Math.sqrt(-1.0), 2))
                    .isInstanceOf(ArithmeticException.class)
                    .hasMessageContaining("유효하지 않은 산술 연산 결과입니다.");
            }
        }
    }

}