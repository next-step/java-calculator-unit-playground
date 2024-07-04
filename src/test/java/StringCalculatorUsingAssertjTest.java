import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringCalculatorUsingAssertjTest {
    private final StringCalculator calculator = new StringCalculator();

    @Test
    void addEmptyString() {
        assertThat(calculator.add("")).isEqualTo(0);
    }

    @Test
    void addNormal() {
        assertThat(calculator.add("1,2")).isEqualTo(3);
    }

    @Test
    void addWithSeparator() {
        assertThat(calculator.add("1,2:3")).isEqualTo(6);
    }

    @Test
    void addWithCustomSeparator() {
        assertThat(calculator.add("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void addWithNegative() {
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> calculator.add("-1,2,3"));
    }
}
