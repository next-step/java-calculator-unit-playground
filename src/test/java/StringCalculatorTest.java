import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest_JUnit5 {

  StringCalculator sc = new StringCalculator();
  final int result = 10;

  @Test
  @DisplayName("기본_구분자로_문자열_계산기를_실행한다")
  void 기본_구분자로_문자열_계산기를_실행한다() {
    String expression = "1,3:6";

    assertEquals(sc.sum(expression), result);
  }

  @Test
  @DisplayName("커스텀_구분자로_문자열_계산기를_실행한다")
  void 커스텀_구분자로_문자열_계산기를_실행한다() {
    String expression = "//;\n3;2;5";

    assertEquals(sc.sum(expression), result);
  }
}

class StringCalculatorTest_AssertJ {

  StringCalculator sc = new StringCalculator();
  final int result = 10;

  @Test
  @DisplayName("기본_구분자로_문자열_계산기를_실행한다")
  void 기본_구분자로_문자열_계산기를_실행한다() {
    String expression = "1,3:6";

    assertThat(sc.sum(expression))
        .isEqualTo(result);
  }

  @Test
  @DisplayName("커스텀_구분자로_문자열_계산기를_실행한다")
  void 커스텀_구분자로_문자열_계산기를_실행한다() {
    String expression = "//;\n3;2;5";

    assertThat(sc.sum(expression))
        .isEqualTo(result);
  }
}