import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculaterTest {

    Calculater calculater = new Calculater();

    @Test
    void add() {
        int actual = calculater.add(1, 2);
        assertThat(actual).isEqualTo(3);
    }

    @Test
    void subtract() {
        int actual = calculater.subtract(1, 2);
        assertThat(actual).isEqualTo(-1);
    }

    @Test
    void multiply() {
        int actual = calculater.multiply(1, 2);
        assertThat(actual).isEqualTo(2);
    }

    @Test
    void divide() {
        int actual = calculater.divide(1, 2);
        assertThat(actual).isEqualTo(0);
    }
}
