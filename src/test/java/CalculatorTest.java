import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    private final Calculator cal = new Calculator();

    @Nested
    @DisplayName("덧셈 테스트 클래스")
    class AddTest {
        @Test
        @DisplayName("덧셈 테스트 메서드")
        void add() {
            assertEquals(10, cal.add(3, 7), "덧셈 테스트 실패");
        }
    }

    @Nested
    @DisplayName("뺄셈 테스트 클래스")
    class SubtractTest {
        @Test
        @DisplayName("뺄셈 테스트 메서드")
        void subtract() {
            assertEquals(4, cal.subtract(7, 3), "뺄셈 테스트 실패");
        }
    }

    @Nested
    @DisplayName("곱셈 테스트 클래스")
    class MultiplyTest {
        @Test
        @DisplayName("곱셈 테스트 메서드")
        void multiply() {
            assertEquals(10, cal.multiply(2, 5), "곱셈 테스트 실패");
        }
    }

    @Nested
    @DisplayName("나눗셈 테스트 클래스")
    class DivideTest {
        @Test
        @DisplayName("나눗셈 테스트 메서드, 0으로 나누는 경우")
        void divideWithZero() {
            assertThrows(ArithmeticException.class, () -> cal.divide(10, 0), "0으로 나누어 테스트 실패");
        }

        @Test
        @DisplayName("나눗셈 테스트 메서드")
        void divide() {
            assertEquals(2, cal.divide(10, 5), "나눗셈 테스트 실패");
        }
    }

}
