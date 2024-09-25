import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void Test_Addition() {
      final int a = 5;
      final int b = 4;

      assertEquals(a + b, Calculator.add(a, b));
    }
  }

}
