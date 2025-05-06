import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import simpleCalc.SimpleCalculator;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("초간단 계산기 unit 테스트")
public class SimpleCalculatorTest {

    @Nested
    @DisplayName("사칙 연산 계산 기능 테스트")
    class FourOperationTest {

        @Test
        @DisplayName("add 함수는 두 정수를 더한 값을 반환한다.")
        void testAddOperation() {
            assertThat(SimpleCalculator.add(1, 2)).isEqualTo(3);
            assertThat(SimpleCalculator.add(-1, -2)).isEqualTo(-3);
            assertThat(SimpleCalculator.add(2, 1)).isEqualTo(3);
            assertThat(SimpleCalculator.add(1, -1)).isEqualTo(0);
        }

        @Test
        @DisplayName("substract 함수는 두 정수를 뺀 값을 반환한다.")
        void testSubstractOperation() {
            assertThat(SimpleCalculator.substract(1, 2)).isEqualTo(-1);
            assertThat(SimpleCalculator.substract(-1, -2)).isEqualTo(1);
            assertThat(SimpleCalculator.substract(2, 1)).isEqualTo(1);
            assertThat(SimpleCalculator.substract(1, -1)).isEqualTo(2);
        }

        @Test
        @DisplayName("multiply 함수는 두 정수를 곱한 값을 반환한다.")
        void testMultiplyOperation() {
            assertThat(SimpleCalculator.multiply(1, 2)).isEqualTo(2);
            assertThat(SimpleCalculator.multiply(-1, -2)).isEqualTo(2);
            assertThat(SimpleCalculator.multiply(2, 1)).isEqualTo(2);
            assertThat(SimpleCalculator.multiply(1, -1)).isEqualTo(-1);
        }

        @Test
        @DisplayName("divide 함수는 두 정수를 나눈 값을 반환한다.")
        void testDivideOperation() {
            assertThat(SimpleCalculator.divide(4, 2)).isEqualTo(2);
            assertThat(SimpleCalculator.divide(9, 3)).isEqualTo(3);
            assertThat(SimpleCalculator.divide(-4, 2)).isEqualTo(-2);
            assertThat(SimpleCalculator.divide(4, -2)).isEqualTo(-2);
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
