package calculator;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class CalculatorTest {
    @DisplayName("두 개의 정수를 더한 결과를 반환할 수 있다.")
    @Test
    void testAdd() {
        // given
        Calculator calculator = new Calculator();

        // when
        int actual = calculator.add(3,6);

        // then
        //assertEquals(9,actual);
        assertThat(actual).isEqualTo(9);
    }

    @DisplayName("두 개의 정수를 뺀 결과를 반환할 수 있다.")
    @Test
    void testSubtract() {
        // given
        Calculator calculator = new Calculator();

        // when
        int actual = calculator.subtract(3,6);

        // then
        //assertEquals(-3, actual);
        assertThat(actual).isEqualTo(-3);
    }

    @DisplayName("두 개의 정수를 곱한 결과를 반환할 수 있다.")
    @Test
    void testMultiply() {
        // given
        Calculator calculator = new Calculator();

        // when
        int actual = calculator.multiply(3,6);

        // then
        //assertEquals(18,actual);
        assertThat(actual).isEqualTo(18);
    }

    @DisplayName("두 개의 정수를 나눈 결과를 반환할 수 있다.")
    @Test
    void testDivide() {
        // given
        Calculator calculator = new Calculator();

        // when
        int actual = calculator.divide(3,6);

        // then
        //assertEquals(0,actual);
        assertThat(actual).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource({
            "'1,2,3', 6",
            "'1:2:3', 6",
            "'//;\\n1;2;3', 6",
            "'', 0",
            "'7', 7"
    })
    void testCalculateStr(String input, int expected) {
        // Given & When
        Calculator calculator = new Calculator();
        int result = calculator.calculate_str(input);

        // Then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void negativeValueTest() {
        Calculator calculator = new Calculator();

        assertThatThrownBy(() -> {
            calculator.calculate_str("-1,2,3");
        })
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("입력 값이 0보다 작습니다");
    }

    @Test
    void nonNumberTest() {
        Calculator calculator = new Calculator();

        assertThatThrownBy(() -> {
            calculator.calculate_str("3,2,d");
        })
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("숫자가 아닌 값이 입력되었습니다");
    }


}