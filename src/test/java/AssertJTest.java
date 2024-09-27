import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;



@DisplayName("JUnit5 테스트")
public class AssertJTest {

  Calculator calculator = new Calculator();

  @Nested
  @DisplayName("기본 계산 테스트")
  class CirculateTest{

    @Test
    @DisplayName("덧셈 테스트")
    void plus(){
      int a = 5;
      int b = 6;

      int expected = a + b;
      int actual = calculator.plus(a, b);

      assertThat(expected).isEqualTo(actual);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void minus(){
      int a = 5;
      int b = 6;

      int expected = a - b;
      int actual = calculator.minus(a, b);

      assertThat(expected).isEqualTo(actual);
    }

    @Test
    @DisplayName("곱셈 테스트")
    void multiply(){
      int a = 5;
      int b = 6;

      int expected = a * b;
      int actual = calculator.multiply(a, b);

      assertThat(expected).isEqualTo(actual);
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void divide(){
      int a = 10;
      int b = 5;

      int expected = a / b;
      int actual = calculator.divide(a, b);

      assertThat(expected).isEqualTo(actual);
    }
  }

  @Nested
  @DisplayName("문자열 계산 테스트")
  class StringCirculateTest{
    @Test
    @DisplayName("구분자가 앞에 있는 경우")
    void dividerAtFirstOfString(){
      int expected = 1 + 2 + 3;
      int actual = calculator.plus("//;\n1;2;3");

      assertThat(expected).isEqualTo(actual);
    }

    @Test
    @DisplayName("구분자가 뒤에 있는 경우")
    void dividerAtEndOfString(){
      int expected = 1 + 2 + 3;
      int actual = calculator.plus("1;2;3//;\n");

      assertThat(expected).isEqualTo(actual);
    }

    @Test
    @DisplayName("구분자가 한개 이상 있는 경우")
    void dividerIsBackward(){
      int expected = 1 + 2 + 3;
      int actual = calculator.plus("//*\n1;2;3//;\n");

      assertThat(expected).isEqualTo(actual);

      actual = calculator.plus("//*\n//;\n1;2;3");

      assertThat(expected).isEqualTo(actual);
    }

    @Test
    @DisplayName("숫자 이외의 값을 전달하는 경우")
    void valueIsNotNumeric(){
      assertThatThrownBy(() -> calculator.plus("//*\n-1?;2;3;l")).isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("음수를 전달하는 경우")
    void valueIsNegative(){
      assertThatThrownBy(() -> calculator.plus("//;\n-1;2;3;")).isInstanceOf(NumberFormatException.class);
    }
  }
}
