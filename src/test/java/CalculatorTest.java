import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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

//      assertEquals(9, result);
      assertThat(result).isEqualTo(9);
    }

    @Test
    @DisplayName("뺄셈_테스트")
    void testSubtraction() {
      final int a = 4;
      final int b = 5;

      final int result = Calculator.subtractBFromA(a, b);

//      assertEquals(-1, result);
      assertThat(result).isEqualTo(-1);
    }

    @Test
    @DisplayName("곱셈_테스트")
    void testMultiplication() {
      final int a = 4;
      final int b = 5;

      final int result = Calculator.multiply(a, b);

//      assertEquals(20, result);
      assertThat(result).isEqualTo(20);
    }

    @Test
    @DisplayName("나눗셈_테스트")
    void testDivision() {
      final int a = 8;
      final int b = 4;

      final int result = Calculator.divideAByB(a, b);

//      assertEquals(2, result);
      assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("예외_나눗셈_분모가_0일때_테스트")
    void testDivisionZero() {
      final int divided = 4;

      final int divider = 0;

//      assertThrows(ArithmeticException.class, ()->{
//        Calculator.divideAByB(divided, divider);
//      });
      assertThatThrownBy(() -> {
        Calculator.divideAByB(divided, divider);
      }).isInstanceOf(ArithmeticException.class);
    }
  }

}
