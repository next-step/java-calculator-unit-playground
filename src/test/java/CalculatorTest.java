import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    Calculator c = new Calculator();

    @Test
    @DisplayName("덧셈 테스트를 수행한다")
    void testAdd(){
        assertThat(c.add(2,3)).isEqualTo(5);
    }
    @Test
    @DisplayName("뺄셈 테스트를 수행한다")
    void testSubtract(){
        assertThat(c.subtract(2,3)).isEqualTo(-1);
    }

    @Test
    @DisplayName("곱셈 테스트를 수행한다")
    void testMultiply(){
        assertThat(c.multiply(2, 3)).isEqualTo(6);
    }
    @Test
    @DisplayName("나눗셈 테스트를 수행한다")
    void testDivide(){
        assertThat(c.divide(6, 3)).isEqualTo(2);
    }
}
