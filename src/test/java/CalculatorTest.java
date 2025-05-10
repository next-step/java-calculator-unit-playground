import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    void addingTest(){
        final var a = 2;
        final var b = 3;
        final var actual = calc.add(a, b);
        final var expected = 5;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void SubtractingTest(){
        final var a = -2;
        final var b = 3;
        final var actual = calc.subtract(a, b);
        final var expected = -5;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void multiplyingTest(){
        final var a = -4;
        final var b = 2;
        final var actual = calc.multiply(a, b);
        final var expected = -8;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void dividingTest(){
        final var a = 3;
        final var b = 2;
        final var actual = calc.divide(a, b);
        final var expected = 1;
        assertThat(actual).isEqualTo(expected);
    }
}
