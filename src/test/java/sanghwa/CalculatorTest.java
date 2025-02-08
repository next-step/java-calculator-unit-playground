package sanghwa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//한글 메서드명 대신 @DisplayName으로 쓰자
@DisplayName("calculator tester")
class CalculatorTest {
    private final Calculator calculator = new Calculator();

    //@Nested 중첩 클래스 선언, 여러가지 메서드를 사용할 수 있음.
    @Nested
    @DisplayName("덧셈")
    class Add {
        @Test
        @DisplayName("일반 덧셈 테스트")
        void add() {
            assertEquals(5, calculator.add(2, 3));
        }
    }

    @Nested
    @DisplayName("뺄셈")
    class Subtract {
        @Test
        @DisplayName("일반 뺄셈 테스트")
        void subtract() {
            assertEquals(-3, calculator.subtract(3, 6));
        }
    }

    @Nested
    @DisplayName("곱셈")
    class Multiply {
        @Test
        @DisplayName("일반 곱셈 테스트")
        void multiply() {
            assertEquals(6, calculator.multiply(2, 3));
        }
    }

    @Nested
    @DisplayName("나눗셈")
    class DivideTest{
        @Test
        @DisplayName("ArithemticException오류 발생 테스트")
        void divideByZero() {
            assertThrows(ArithmeticException.class, () -> calculator.divide(3,0));
        }

        @Test
        @DisplayName("일반 나눗셈 테스트")
        void divideByNotZero() {
            assertEquals(2, calculator.divide(6, 3));
        }
    }
}
