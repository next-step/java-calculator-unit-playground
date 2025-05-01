package domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import domain.operatorImpl.AddOperator;
import domain.operatorImpl.DivideOperator;
import domain.operatorImpl.MultiplyOperator;
import domain.operatorImpl.SubtractOperator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("계산기 테스트")
public class CalculatorTest {

    Calculator calculator = new Calculator(new Operator[]
        {new AddOperator(), new SubtractOperator(), new MultiplyOperator(), new DivideOperator()});

    @Nested
    @DisplayName("문자열 계산기 테스트")
    class StringExpressionTest {
        @Test
        @DisplayName("문자열 입력 유효성 검증 테스트")
        void validateInputExpressionTest() {
            // Given

            // When & Then
            assertThrows(IllegalArgumentException.class, () -> calculator.calculateStringExpression("1"));
            assertThrows(IllegalArgumentException.class, () -> calculator.calculateStringExpression("1+"));
            assertThrows(IllegalArgumentException.class, () -> calculator.calculateStringExpression("1+2+3"));
            assertDoesNotThrow(() -> calculator.calculateStringExpression("1+2"));
        }

        @Test
        @DisplayName("문자열 덧셈 테스트")
        void calculateAddTest() {
            // Given

            // When & Then
            assertEquals(5,calculator.calculateStringExpression("1+4"));
            assertEquals(-3,calculator.calculateStringExpression("1+-4"));
            assertEquals(-3,calculator.calculateStringExpression("1+ -4"));
        }

        @Test
        @DisplayName("문자열 뺄셈 테스트")
        void calculateSubtractTest() {
            // Given

            // When & Then
            assertEquals(-3,calculator.calculateStringExpression("1-4"));
            assertEquals(5,calculator.calculateStringExpression("1--4"));
            assertEquals(5,calculator.calculateStringExpression("1- -4"));
        }

        @Test
        @DisplayName("문자열 곱셈 테스트")
        void calculateMultiplyTest() {
            // Given

            // When & Then
            assertEquals(4,calculator.calculateStringExpression("1*4"));
            assertEquals(0,calculator.calculateStringExpression("1*0"));
            assertEquals(-4,calculator.calculateStringExpression("1*-4"));
        }

        @Test
        @DisplayName("문자열 나눗셈 테스트")
        void calculateDivideTest() {
            // Given

            // When & Then
            assertEquals(0,calculator.calculateStringExpression("1/4"));
            assertEquals(2,calculator.calculateStringExpression("4/2"));

            assertThrows(ArithmeticException.class,() -> calculator.calculateStringExpression("1/0"));
        }
    }
}
