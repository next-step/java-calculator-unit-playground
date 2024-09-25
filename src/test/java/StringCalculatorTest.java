import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("String Calculator 테스트")
public class StringCalculatorTest {

  @Test
  @DisplayName("덧셈_테스트")
  void testAddition() {
    String targetText = "1,2,3";

    int result = StringCalculator.parseAndSum(targetText);

    assertEquals(6, result);
  }
}
