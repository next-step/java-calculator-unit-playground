import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("JUnit5 테스트")
public class JUnit5Test {
    @Nested
    @DisplayName("@Test 계산기 테스트")
    class calculatorTest {
        Calculator calculator = new Calculator();
        
        @Test
        @DisplayName("더하기 테스트")
        void add_test() {
            assertEquals(calculator.add(1, 2), 3, "더하기 테스트 실패");
            assertEquals(calculator.add("3,4:2"), 9, "문자열 더하기 테스트 실패");
            assertEquals(calculator.add("//[\n3[6:5"), 11, "커스텀 구분자 더하기 테스트 실패");
        }

        @Test
        @DisplayName("빼기 테스트")
        void subtract_test() {
            assertEquals(calculator.subtract(4, 2), 2, "빼기 테스트 실패");
        }
        
        @Test
        @DisplayName("곱하기 테스트")
        void multiply_test() {
            assertEquals(calculator.multiply(4, 2), 8, "곱하기 테스트 실패");
        }
        
        @Test
        @DisplayName("나누기 테스트")
        void divide_test() {
            assertEquals(calculator.divide(10, 2), 5, "나누기 테스트 실패");
        }


    }
}
