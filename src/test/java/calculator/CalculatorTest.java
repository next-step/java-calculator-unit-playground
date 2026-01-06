package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @DisplayName("두 정수 인자가 들어오면 성공적으로 덧셈을 실행한다.")
    @Test
    void add() {
        // given
        int a = 3;
        int b = 5;

        // when
        int result = calculator.add(a, b);

        // then
        assertThat(result).isEqualTo(8);
    }

    @DisplayName("두 정수 인자가 들어오면 성공적으로 뺄셈을 실행한다.")
    @Test
    void minus() {
        // given
        int a = 8;
        int b = 5;

        // when
        int result = calculator.minus(a, b);

        // then
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("두 정수 인자가 들어오면 성공적으로 곱셈을 실행한다.")
    @Test
    void multiply() {
        // given
        int a = 3;
        int b = 5;

        // when
        int result = calculator.multiply(a, b);

        // then
        assertThat(result).isEqualTo(15);
    }

    @DisplayName("나누는 수가 0이 아닌 두 정수가 들어오면 성공적으로 나눗셈을 실행한다.")
    @Test
    void divide() {
        // given
        int a = 8;
        int b = 3;

        // when
        int result = calculator.divide(a, b);

        // then
        assertThat(result).isEqualTo(2);
    }


    @DisplayName("0으로 나누게 되면 IllegalArgument 에러를 발생시킨다.")
    @Test
    void divideNonZeroException() {
        // given
        int a = 5;
        int b = 0;

        // when & then
        assertThatThrownBy(() -> calculator.divide(a, b))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로 나눌 수 없습니다.");
    }
}