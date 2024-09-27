import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("String Calculator 테스트")
public class StringCalculatorTest {

  @Test
  @DisplayName("덧셈_테스트_케이스_1")
  void testAdditionCase1() {
    String targetText = "1,2,3";

    int result = StringCalculator.parseAndSum(targetText);

//    assertEquals(6, result);
    assertThat(result).isEqualTo(6);
  }

  @Test
  @DisplayName("덧셈_테스트_케이스_2")
  void testAdditionCase2() {
    String targetText = "1,2";

    int result = StringCalculator.parseAndSum(targetText);

//    assertEquals(3, result);
    assertThat(result).isEqualTo(3);
  }

  @Test
  @DisplayName("덧셈_테스트_케이스_구분자가_다른_경우")
  void testAdditionCaseDifferentSeparator() {
    String targetText = "//;\n1;2;4,4:5";

    int result = StringCalculator.parseAndSum(targetText);

//    assertEquals(16, result);
    assertThat(result).isEqualTo(16);
  }

  @Test
  @DisplayName("덧셈_테스트_케이스_자리수가_여러개인_경우")
  void testAdditionCaseMultipleDigits() {
    String targetText = "//;\n12;24;0";

    int result = StringCalculator.parseAndSum(targetText);

//    assertEquals(36, result);
    assertThat(result).isEqualTo(36);
  }

  @Test
  @DisplayName("덧셈_예외_테스트_케이스_음수인_경우")
  void testAdditionCaseNegativeNumbers() {
    String targetText = "//;\n12;-24;0,-13:123";
//
//    assertThrows(RuntimeException.class, () -> {
//      StringCalculator.parseAndSum(targetText);
//    });
    assertThatThrownBy(() -> {
      StringCalculator.parseAndSum(targetText);
    }).isInstanceOf(RuntimeException.class);
  }

  @Test
  @DisplayName("덧셈_예외_테스트_케이스_문자인_경우")
  void testAdditionCaseTextToken() {
    String targetText = "//;\n12;-24;0,-really:test";

//    assertThrows(RuntimeException.class, () -> {
//      StringCalculator.parseAndSum(targetText);
//    });
    assertThatThrownBy(() -> {
      StringCalculator.parseAndSum(targetText);
    }).isInstanceOf(RuntimeException.class);
  }
}
