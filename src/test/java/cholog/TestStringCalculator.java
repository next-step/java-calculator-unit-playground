package cholog;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestStringCalculator {

  private static StringCalculator calculator;

  @BeforeAll
  public static void setUp() {
    calculator = new StringCalculator();
  }

  @Test
  @DisplayName("sum 정상 작동 확인")
  public void sum() {
    //given
    String input = "1,2:3";

    //when
    int result = calculator.sum(input);
    int expect = 6;

    //then
    assertThat(result).isEqualTo(expect);
  }
  @Test
  @DisplayName("구분자 정상 인식 확인")
  public void seperator() {
    //given
    String input = "//;\n1;2;3";

    //when
    int result = calculator.sum(input);
    int expect = 6;

    //then
    assertThat(result).isEqualTo(expect);
  }
  @Test
  @DisplayName("지정되지 않은 구분자 에러 확인")
  public void unknownSeperator() {
    //given
    String input = "1;2;3";

    //when


    //then
    assertThatThrownBy(() -> calculator.sum(input)).isInstanceOf(Throwable.class);
  }
}
