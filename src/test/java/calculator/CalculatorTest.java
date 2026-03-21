package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    @DisplayName("두 개의 정수를 더한 결과를 반환할 수 있다.")
    @Test
    void testAdd() {
        // given
        Calculator calculator = new Calculator();

        // when
        int actual = calculator.add(3, 6);


        // then
        assertThat(actual).isEqualTo(9);
    }

    @DisplayName("두 개의 정수를 뺀 결과를 반환할 수 있다.")
    @Test
    void testSubtract() {
        // given
        Calculator calculator = new Calculator();

        // when
        int actual = calculator.subtract(6, 3);


        // then
        assertThat(actual).isEqualTo(3);
    }

    @DisplayName("두 개의 정수를 곱한 결과를 반환할 수 있다.")
    @Test
    void testMultiply() {
        // given
        Calculator calculator = new Calculator();

        // when
        int actual = calculator.multiply(3, 6);


        // then
        assertThat(actual).isEqualTo(18);
    }

    @DisplayName("두 개의 정수를 나눈 결과를 반환할 수 있다.")
    @Test
    void testDivide() {
        // given
        Calculator calculator = new Calculator();

        // when
        int actual = calculator.divide(6, 3);


        // then
        assertThat(actual).isEqualTo(2);
    }

    @DisplayName("문자열을 분리해 더할 수 있다")
    @Test
    void testStringAdd(){
        Calculator calculator = new Calculator();

        int result = calculator.stringAdd("");
        // assertEquals(0, result);
        assertThat(result).isEqualTo(0);

        result = calculator.stringAdd("2,3");
        // assertEquals(5, result);
        assertThat(result).isEqualTo(5);

        result = calculator.stringAdd("2,3,5");
        // assertEquals(10, result);
        assertThat(result).isEqualTo(10);

        result = calculator.stringAdd("4:5");
        // assertEquals(9, result);
        assertThat(result).isEqualTo(9);

        result = calculator.stringAdd("4:5:2");
        // assertEquals(11, result);
        assertThat(result).isEqualTo(11);

        result = calculator.stringAdd("//;\n1;2;3");
        // assertEquals(6, result);
        assertThat(result).isEqualTo(6);

        result = calculator.stringAdd("//-\n1-2-3-4");
        // assertEquals(10, result);
        assertThat(result).isEqualTo(10);

        // assertThrows(RuntimeException.class, () -> calculator.stringAdd("//:\n-1:2:3:4"));
        assertThatThrownBy(() -> calculator.stringAdd("//:\n-1:2:3:4")).isInstanceOf(RuntimeException.class);

        // assertThrows(RuntimeException.class, () -> calculator.stringAdd("//:\n1:a:3:4"));
        assertThatThrownBy(() -> calculator.stringAdd("//:\n1:a:3:4")).isInstanceOf(RuntimeException.class);
    }

}