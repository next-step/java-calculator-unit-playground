import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("String Calculator 테스트")
public class StringCalculatorTest {

  @Test
  @DisplayName("덧셈_테스트_케이스_1")
  void testAdditionCase1() {
    String targetText = "1,2,3";

    int result = StringCalculator.parseAndSum(targetText);

    assertEquals(6, result);
  }

  @Test
  @DisplayName("덧셈_테스트_케이스_2")
  void testAdditionCase2() {
    String targetText = "1,2";

    int result = StringCalculator.parseAndSum(targetText);

    assertEquals(3, result);
  }

  @Test
  @DisplayName("덧셈_테스트_케이스_구분자가_다른_경우")
  void testAdditionCaseDifferentSeparator() {
    String targetText = "//;\n1;2;4";

    int result = StringCalculator.parseAndSum(targetText);

    assertEquals(7, result);
  }
}
