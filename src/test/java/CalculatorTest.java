import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("계산기 테스트")
class CalculatorTest {
  final Calculator calculator = new Calculator();

  @Nested
  @DisplayName("사칙연산 테스트")
  class ElemArithTest {

    @Test
    @DisplayName("덧셈 테스트")
    void addTest() {
      int num1 = 24;
      int num2 = 43;

      int expected = 67;
      int actual = calculator.add(num1, num2);

      assertEquals(expected, actual);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void subTest() {
      int num1 = 47;
      int num2 = -32;

      int expected = 79;
      int actual = calculator.sub(num1, num2);

      assertEquals(expected, actual);
    }

    @Test
    @DisplayName("곱셈 테스트")
    void multiTest() {
      int num1 = 23;
      int num2 = 11;

      int expected = 253;
      int actual = calculator.multi(num1, num2);

      assertEquals(expected, actual);
    }

    @Test
    @DisplayName("나눗셈 테스트 (나누어 떨어질 경우)")
    void DivisTest1() {
      int num1 = 35;
      int num2 = 5;

      int expected = 7;
      int actual = calculator.divis(num1, num2);

      assertEquals(expected, actual);
    }

    @Test
    @DisplayName("나눗셈 테스트 (나누어 떨어지지 않을 경우)")
    void DivisTest2() {
      int num1 = 35;
      int num2 = 8;

      int expected = 4;
      int actual = calculator.divis(num1, num2);

      assertEquals(expected, actual);
    }
  }

  @Nested
  @DisplayName("문자열 계산기 테스트")
  class StringCalculatorTest {

    @Test
    @DisplayName("(:) 구분자 입력 테스트")
    void ColonSplitTest() {
      String input = "3:4:7";

      int expected = 14;
      int actual = calculator.stringToSum(input);

      assertEquals(expected, actual);
    }

    @Test
    @DisplayName("(,) 구분자 입력 테스트")
    void commaSplitTest() {
      String input = "3,4,7";

      int expected = 14;
      int actual = calculator.stringToSum(input);

      assertEquals(expected, actual);
    }

    @Test
    @DisplayName("커스텀 구분자 입력 테스트")
    void customSplitTest() {
      String input = "// \\n3 4 7";

      int expected = 14;
      int actual = calculator.stringToSum(input);

      assertEquals(expected, actual);
    }

    @Test
    @DisplayName("음수 입력 테스트")
    void negativeInputTest() {
      String input = "//_\\n-3_4_7";

      assertThrows(RuntimeException.class, () -> calculator.stringToSum(input));
    }

    @Test
    @DisplayName("잘못된 문자열 테스트")
    void wrongInputTest() {
      String input = "// \\n-3_4_7";

      assertThrows(RuntimeException.class, () -> calculator.stringToSum(input));
    }

  }
}

