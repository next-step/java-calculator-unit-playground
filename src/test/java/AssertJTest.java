
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("AssertJ 테스트")
public class AssertJTest {
  @Nested
    @DisplayName("@Test 계산기 테스트")
    class calculatorTest {
        Calculator calculator = new Calculator();
        
        @Test
        @DisplayName("더하기 테스트")
        void add_test() {
            assertThat(calculator.add(1, 2)).isEqualTo(3).as("더하기 테스트 실패");
            assertThat(calculator.add("3,4:2")).isEqualTo(9).as("문자열 더하기 테스트 실패");
            assertThat(calculator.add("//[\\n3[6:5")).isEqualTo(11).as("커스텀 구분자 더하기 테스트 실패");
            
          }
          
          @Test
          @DisplayName("빼기 테스트")
          void subtract_test() {
            assertThat(calculator.subtract(4, 2)).isEqualTo(2).as("빼기 테스트 실패");
          }
          
          @Test
          @DisplayName("곱하기 테스트")
          void multiply_test() {
            assertThat(calculator.subtract(4, 2)).isEqualTo(8).as("곱하기 테스트 실패");
          }
          
          @Test
          @DisplayName("나누기 테스트")
          void divide_test() {
            assertThat(calculator.subtract(10, 2)).isEqualTo(5).as("나누기 테스트 실패");
        }


    }
}
