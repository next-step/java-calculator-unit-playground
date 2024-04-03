import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculaterTest {

    Calculater calculater = new Calculater();

    @Test
    @DisplayName("두 숫자를 더하다.")
    void add() {
        int actual = calculater.add(1, 2);
        assertThat(actual).isEqualTo(3);
    }

    @Test
    @DisplayName("두 숫자를 빼다.")
    void subtract() {
        int actual = calculater.subtract(1, 2);
        assertThat(actual).isEqualTo(-1);
    }

    @Test
    @DisplayName("두 숫자를 곱하다.")
    void multiply() {
        int actual = calculater.multiply(1, 2);
        assertThat(actual).isEqualTo(2);
    }

    @Test
    @DisplayName("두 숫자를 나누다.")
    void divide() {
        int actual = calculater.divide(1, 2);
        assertThat(actual).isEqualTo(0);
    }
}
