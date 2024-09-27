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
    String targetText = "//;\n1;2;4,4:5";

    int result = StringCalculator.parseAndSum(targetText);

    assertEquals(16, result);
  }

  @Test
  @DisplayName("덧셈_테스트_케이스_자리수가_여러개인_경우")
  void testAdditionCaseMultipleDigits() {
    String targetText = "//;\n12;24;0";

    int result = StringCalculator.parseAndSum(targetText);

    assertEquals(36, result);
  }

  @Test
  @DisplayName("덧셈_예외_테스트_케이스_음수인_경우")
  void testAdditionCaseNegativeNumbers() {
    String targetText = "//;\n12;-24;0,-13:123";

    assertThrows(RuntimeException.class, ()->{
      StringCalculator.parseAndSum(targetText);
    });

  }
}
