import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    @DisplayName("두 수를 받아 덧셈을 한다.")
    void addTest(){
        assertThat(calculator.add(1, 2)).isEqualTo(3);
    }

    @Test
    @DisplayName("두 수를 받아 뺄셈을 한다.")
    void subtractTest(){
        assertThat(calculator.subtract(1, 2)).isEqualTo(-1);
    }

    @Test
    @DisplayName("두 수를 받아 곱셈을 한다.")
    void multipleTest(){
        assertThat(calculator.multiple(1, 2)).isEqualTo(2);
    }

    @Test
    @DisplayName("두 수를 받아 나눗셈을 한다.")
    void divideTest(){
        assertThat(calculator.divide(1, 2)).isEqualTo(0);
    }

    @Test
    @DisplayName("문자열을 입력받고, 문자열 내의 숫자들의 합을 계산한다.")
    void stringCalculatorTest(){
        assertThat(calculator.stringAdd("//;\n1,2;3:4")).isEqualTo(10);
        assertThat(calculator.stringAdd("1,2,3,4")).isEqualTo(10);
    }

    @Test
    @DisplayName("잘못된 문자열을 입력받는다. - 음수")
    void negativeNumberTest(){
        assertThatThrownBy(() -> {
            assertThat(calculator.stringAdd("//;\n1,-2;3:4")).isEqualTo(10);
        }).isInstanceOf(RuntimeException.class)
            .hasMessage("잘못된 문자열입니다. string: -2");
    }

    @Test
    @DisplayName("잘못된 문자열을 입력받는다. - 숫자가 아닌 문자열")
    void noneNumberTest(){
        assertThatThrownBy(() -> {
            assertThat(calculator.stringAdd("//;\n1,A;3:4")).isEqualTo(10);
        }).isInstanceOf(RuntimeException.class)
            .hasMessage("잘못된 문자열입니다. string: A");
    }

}
