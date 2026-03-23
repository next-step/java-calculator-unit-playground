package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {
    @DisplayName("문자열을 입력받아 구분자로 분리된 수의 합을 반환한다.")
    @Test 
    void testSumFromString() {
        //given
        Calculator calculator = new Calculator();

        //when
        int result1 = calculator.sumFromString("1,2,3");
        int result2 = calculator.sumFromString("1:2:3");
        int result3 = calculator.sumFromString("1,2:3");
        int result4 = calculator.sumFromString("1:2,3");
        int result5 = calculator.sumFromString("//;\n1;2;3");
        int result6 = calculator.sumFromString("//?\n1?2?3");

        //then
        assertThat(result1).isEqualTo(6);
        assertThat(result2).isEqualTo(6);
        assertThat(result3).isEqualTo(6);
        assertThat(result4).isEqualTo(6);
        assertThat(result5).isEqualTo(6);
        assertThat(result6).isEqualTo(6);
        

        assertThatThrownBy(() -> calculator.sumFromString("-1,2,3")).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> calculator.sumFromString("-1,2,a")).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("인자 두 개를 받아서 덧셈을 수행한다")
    @Test
    void testAdd() {
        //given
        Calculator calculator = new Calculator();
        //when
        int result = calculator.add(1, 2);
        //then
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("인자 두 개를 받아서 뺄셈을 수행한다")
    @Test
    void testSubtract() {
        //given
        Calculator calculator = new Calculator();
        //when
        int result = calculator.subtract(4, 2);
        //then
        assertThat(result).isEqualTo(2);
    }

    @DisplayName("인자 두 개를 받아서 곱셈을 수행한다")
    @Test
    void testMultiply() {
        //given
        Calculator calculator = new Calculator();
        //when
        int result = calculator.multiply(1, 2);
        //then
        assertThat(result).isEqualTo(2);
    }

    @DisplayName("인자 두 개를 받아서 나눗셈을 수행한다")
    @Test
    void testDivision() {
        //given
        Calculator calculator = new Calculator();
        //when
        int result = calculator.division(10, 2);
        //then
        assertThat(result).isEqualTo(5);
    }
}