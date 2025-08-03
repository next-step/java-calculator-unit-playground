
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

@DisplayName("계산기 작동 테스트")
public class CalcTest {
    private final Calc calc = new Calc();

    @Test
    @DisplayName("더하기 테스트")
    void add() {
        final var a = 1;
        final var b = 2;
        final var actual = calc.add(a, b);
        
        assertThat(actual).isEqualTo(3);
    }

    @Test
    @DisplayName("빼기 테스트")
    void minus() {
        final var a = 3;
        final var b = 1;
        final var actual = calc.minus(a, b);
        
        assertThat(actual).isEqualTo(2);
    }

    @Test
    @DisplayName("곱하기 테스트")
    void times() {
        final var a = 2;
        final var b = 3;
        final var actual = calc.times(a, b);
        
        assertThat(actual).isEqualTo(6);
    }

    @Test
    @DisplayName("나누기 테스트")
    void divide() {
        final var a = 10;
        final var b = 5;
        final var actual = calc.divide(a, b);
        
        assertThat(actual).isEqualTo(2);
    }

    @Test
    @DisplayName("0으로 나누기 예외 테스트")
    void divideByZeroThrowsException() {
        final var a = 10;
        final var b = 0;
        
        assertThatThrownBy(() -> calc.divide(a, b))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("0 으로 나눌 수 없습니다.");
    }
}