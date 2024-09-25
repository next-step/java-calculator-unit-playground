import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Calculator 테스트")
public class CalculatorTest {

  @Nested
  @DisplayName("사칙 연산 테스트")
  class FourBasicOperationsTest {

    /**
     * `@Test` 애노테이션이 없다면 해당 메서드는 테스트 메서드가 아닙니다. 따라서 해당 메서드는 테스트 메서드가 아니기 때문에, 테스트 메서드로서의 역할을 수행하지
     * 않습니다. `@Test` 애노테이션을 사용하면 해당 메서드는 테스트 메서드가 되며, 테스트 메서드로서의 역할을 수행합니다.
     */
    @Test
    @DisplayName("덧셈_테스트")
    void testAddition() {
      final int a = 5;
      final int b = 4;

      final int result = Calculator.add(a, b);

      assertEquals(9, result);
    }

    @Test
    @DisplayName("뺄셈_테스트")
    void testSubtraction() {
      final int a = 4;
      final int b = 5;

      final int result = Calculator.subtractBFromA(a, b);

      assertEquals(-1, result);
    }
  }

}
