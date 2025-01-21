import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculateTest {

    private final Calculate calculate = new Calculate();

    private final int a = 6;
    private final int b = 3;

    @Test
    @DisplayName("OK : 두 수 덧셈 성공")
    void sum() {
        assertThat(calculate.add(a, b)).isEqualTo(a + b);
    }

    @Test
    @DisplayName("OK : 두 수 뺄셈 성공")
    void subtract() {
        assertThat(calculate.subtract(a, b)).isEqualTo(a - b);
    }

    @Test
    @DisplayName("OK : 두 수 곱셈 성공")
    void multiply() {
        assertThat(calculate.multiply(a, b)).isEqualTo(a * b);
    }

    @Test
    @DisplayName("OK : 두 수 나누기 성공")
    void divide() {
        assertThat(calculate.divide(a, b)).isEqualTo(a / b);
    }

    @Test
    @DisplayName("OK : 문자열 덧셈 성공")
    void calculateFromString() {
        assertThat(calculate.calculateFromString("//;\\n1;2:3")).isEqualTo(6);
        assertThat(calculate.calculateFromString("1,2:3")).isEqualTo(6);
        assertThat(calculate.calculateFromString("7")).isEqualTo(7);
    }

    @Test
    @DisplayName("ERROR : 문자열 덧셈 실패 - 음수 포함")
    void calculateFromString_exception_negative() {
        assertThrows(IllegalArgumentException.class, () -> calculate.calculateFromString("//;\\n1,-2:3"));
        assertThrows(IllegalArgumentException.class, () -> calculate.calculateFromString("1,-2:3"));
    }

    @Test
    @DisplayName("ERROR : 문자열 덧셈 실패 - 잘못된 구분자")
    void calculateFromString_exception_Invalid_delimiter() {
        assertThrows(IllegalArgumentException.class, () -> calculate.calculateFromString("//;\\n1!2;3"));
        assertThrows(IllegalArgumentException.class, () -> calculate.calculateFromString("1!2;3"));
    }

    @Test
    @DisplayName("ERROR : 문자열 덧셈 실패 - 잘못된 형식 입력")
    void calculateFromString_exception_Invalid_Input() {
        assertThrows(IllegalArgumentException.class, () -> calculate.calculateFromString("@@;\\n1,2;3"));
        assertThrows(IllegalArgumentException.class, () -> calculate.calculateFromString("//;\\n1,#;3"));
        assertThrows(IllegalArgumentException.class, () -> calculate.calculateFromString("1,@;3"));
        assertThrows(IllegalArgumentException.class, () -> calculate.calculateFromString(" "));
    }
}
