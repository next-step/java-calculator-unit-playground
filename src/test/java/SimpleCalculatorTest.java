import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import simpleCalc.SimpleCalculator;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("초간단 계산기 unit 테스트")
public class SimpleCalculatorTest {

    @Nested
    @DisplayName("사칙 연산 계산 기능 테스트")
    class FourOperationTest {

        @ParameterizedTest(name = "{0} add {1} 은 {2}이다.")
        @CsvSource({"1,2,3", "-1,-2,-3", "2,1,3", "1,-1,0"})
        @DisplayName("add 함수는 두 정수를 더한 값을 반환한다.")
        void testAddOperation(int a, int b, int expected) {
            assertThat(SimpleCalculator.add(a, b)).isEqualTo(expected);
        }

        @ParameterizedTest(name = "{0} subtract {1} 은 {2}이다.")
        @CsvSource({"1,2,-1", "-1,-2,1", "2,1,1", "1,-1,2"})
        @DisplayName("substract 함수는 두 정수를 뺀 값을 반환한다.")
        void testSubstractOperation(int a, int b, int expected) {
            assertThat(SimpleCalculator.subtract(a, b)).isEqualTo(expected);
        }

        @ParameterizedTest(name = "{0} multiply {1} 은 {2}이다.")
        @CsvSource({"1,2,2", "-1,-2,2", "2,1,2", "1,-1,-1"})
        @DisplayName("multiply 함수는 두 정수를 곱한 값을 반환한다.")
        void testMultiplyOperation(int a, int b, int expected) {
            assertThat(SimpleCalculator.multiply(a, b)).isEqualTo(expected);
        }

        @ParameterizedTest(name = "{0} divide {1} 은 {2}이다.")
        @CsvSource({"1,2,0", "-1,-2,0", "2,1,2", "1,-1,-1"})
        @DisplayName("divide 함수는 두 정수를 나눈 값을 반환한다.")
        void testDivideOperation(int a, int b, int expected) {
            assertThat(SimpleCalculator.divide(a, b)).isEqualTo(expected);
        }

        @Test
        @DisplayName("divide 함수는 0으로 나눌 때 RuntimeException을 던진다.")
        void zeroDivisionRuntimeExceptionTest() {
            assertThrows(RuntimeException.class, () -> SimpleCalculator.divide(1, 0));
            assertThatThrownBy(() -> SimpleCalculator.divide(1, 0))
                    .isInstanceOf(RuntimeException.class);
        }
    }
}
