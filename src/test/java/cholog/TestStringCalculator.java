package cholog;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    int expected = 6;

    //then
    assertEquals(expected, result);
  }
  @Test
  @DisplayName("구분자 정상 인식 확인")
  public void seperator() {
    //given
    String input = "//;\n1;2;3";

    //when
    int result = calculator.sum(input);
    int expected = 6;

    //then
    assertEquals(expected, result);
  }
}
