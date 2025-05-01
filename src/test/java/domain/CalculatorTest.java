package domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("계산기 테스트")
public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Nested
    @DisplayName("덧셈 테스트")
    class AddTest {
        @Test
        @DisplayName("정수 덧셈 테스트")
        void addIntegerTest() {
            // Given

            // When & Then
            assertAll(
                () -> assertEquals(5,calculator.add(1,4)),
                () -> assertEquals(0,calculator.add(0,0)),
                () -> assertEquals(-5,calculator.add(0,-5))
            );
        }
    }
    
    @Nested
    @DisplayName("뺄셈 테스트")
    class SubtractTest {
        @Test
        @DisplayName("정수 뺄셈 테스트")
        void subtractIntegerTest() {
            // Given
            
            // When & Then
            assertAll(
                () -> assertEquals(3,calculator.subtract(4,1)),
                () -> assertEquals(5,calculator.subtract(0,-5)),
                () -> assertEquals(-5,calculator.subtract(0,5)),
                () -> assertEquals(0,calculator.subtract(0,0))
            );
        }
    }
    
    @Nested
    @DisplayName("곱셈 테스트")
    class MultiplyTest {
        @Test
        @DisplayName("정수 곱셈 테스트")
        void multiplyIntegerTest() {
            // Given

            // When & Then
            assertAll(
                () -> assertEquals(4,calculator.multiply(4,1)),
                () -> assertEquals(0,calculator.multiply(0,3)),
                () -> assertEquals(-6,calculator.multiply(3,-2)),
                () -> assertEquals(0,calculator.multiply(0,0))
            );
        }
    }

    @Nested
    @DisplayName("나눗셈 테스트")
    class DivideTest {
        @Test
        @DisplayName("정수 나눗셈 테스트")
        void divideIntegerTest() {
            // Given

            // When & Then
            assertAll(
                () -> assertEquals(4,calculator.divide(4,1)),
                () -> assertEquals(2,calculator.divide(4,2)),
                () -> assertEquals(-2,calculator.divide(4,-2)),
                () -> assertEquals(0,calculator.divide(0,2))
            );

            assertThrows(ArithmeticException.class, () -> calculator.divide(4,0));
        }
    }
}
