import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void add() {
        assertThat(calculator.add(1, 2)).isEqualTo(3);
    }

    @Test
    void subtract() {
        assertThat(calculator.subtract(1, 2)).isEqualTo(-1);
    }

    @Test
    void multiply() {
        assertThat(calculator.multiply(2, 3)).isEqualTo(6);
        assertThat(calculator.multiply(4, 5)).isEqualTo(20);
    }

    @Test
    void divide() {
        assertThat(calculator.divide(2, 3)).isZero();
        assertThat(calculator.divide(8, 4)).isEqualTo(2);

        assertThrows(ArithmeticException.class, () -> calculator.divide(3, 0));
    }

    @Test
    void parseAndSum() {
        assertThat(calculator.parseAndSum("")).isZero();
        assertThat(calculator.parseAndSum(" ")).isZero();
        assertThat(calculator.parseAndSum(",")).isZero();

        assertThat(calculator.parseAndSum("1,2,3")).isEqualTo(6);
        assertThat(calculator.parseAndSum("1,2:3")).isEqualTo(6);
        assertThat(calculator.parseAndSum("1:2:3")).isEqualTo(6);
    }

    @Test
    void pareAndSumWithCustomSep() {
        assertThat(calculator.parseAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void parseAndSumWithWrongString() {
        assertThrows(RuntimeException.class, () -> calculator.parseAndSum("//a\n1;2;3"));
        assertThrows(RuntimeException.class, () -> calculator.parseAndSum("1;2;3"));
    }
}
