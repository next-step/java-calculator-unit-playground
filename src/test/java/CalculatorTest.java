import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("계산기 기능 테스트")
class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    @DisplayName("더하기 기능을 테스트한다")
    void addTest() {
        assertThat(calculator.add(5, 3)).isEqualTo(8);
    }

    @Test
    @DisplayName("빼기 기능을 테스트한다")
    void minusTest() {
        assertThat(calculator.minus(5, 3)).isEqualTo(2);
    }

    @Test
    @DisplayName("곱하기 기능을 테스트한다")
    void multipleTest() {
        assertThat(calculator.multiple(5, 3)).isEqualTo(15);
    }

    @Test
    @DisplayName("나누기 기능을 테스트한다")
    void divideTest() {
        assertThat(calculator.divide(5, 3)).isEqualTo(1);
    }

    @Test
    @DisplayName("문자열 더하기 기능을 테스트한다")
    void stringAddTest() {
        assertThat(calculator.stringAdd("5,3")).isEqualTo(8);
    }

    @Test
    @DisplayName("문자열 커스텀더하기 기능을 테스트한다")
    void stringCustomAddTest() {
        assertThat(calculator.stringAdd("//;\n5;3")).isEqualTo(8);
    }

    @Test
    @DisplayName("음수가 있으면 RuntimeExcrption")
    void negativeRuntimeException() {
        assertThatThrownBy(() -> {
            calculator.stringAdd("-5,3");
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("빈 문자열은 0")
    void emptyString() {
        assertThat(calculator.stringAdd("")).isZero();
    }
}
