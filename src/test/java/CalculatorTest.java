import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Nested
    class Add {

        @Test
        @DisplayName("0에 0을 더한다")
        void zero_zero() {
            // given
            int a = 0;
            int b = 0;
            int expectedResult = a + b;

            // when
            int actualResult = calculator.add(a, b);

            // then
            assertEquals(expectedResult, actualResult);
        }

        @Test
        @DisplayName("오버플로우 발생")
        void overflow() {
            // given
            int a = Integer.MAX_VALUE;
            int b = 1;

            // then
            String message = assertThrows(IllegalArgumentException.class, () -> calculator.add(a, b))
                    .getMessage();
            assertEquals(String.format("(%d) + (%d)는 오버플로우가 발생합니다.", a, b), message);
        }

        @Test
        @DisplayName("언더플로우 발생")
        void underflow() {
            // given
            int a = Integer.MIN_VALUE;
            int b = -1;

            // then
            String message = assertThrows(IllegalArgumentException.class, () -> calculator.add(a, b))
                    .getMessage();
            assertEquals(String.format("(%d) + (%d)는 언더플로우가 발생합니다.", a, b), message);
        }

        @Test
        @DisplayName("양수에 양수를 더한다")
        void positive_positive() {
            // given
            int a = 6;
            int b = 3;
            int expectedResult = a + b;

            // when
            int actualResult = calculator.add(a, b);

            // then
            assertEquals(expectedResult, actualResult);
        }

        @Test
        @DisplayName("양수에 음수를 더한다")
        void positive_negative() {
            // given
            int a = 6;
            int b = -3;
            int expectedResult = a + b;

            // when
            int actualResult = calculator.add(a, b);

            // then
            assertEquals(expectedResult, actualResult);
        }

        @Test
        @DisplayName("음수에 양수를 더한다")
        void negative_positive() {
            // given
            int a = -6;
            int b = 3;
            int expectedResult = a + b;

            // when
            int actualResult = calculator.add(a, b);

            // then
            assertEquals(expectedResult, actualResult);
        }

        @Test
        @DisplayName("음수에 음수를 더한다")
        void negative_negative() {
            // given
            int a = -6;
            int b = -3;
            int expectedResult = a + b;

            // when
            int actualResult = calculator.add(a, b);

            // then
            assertEquals(expectedResult, actualResult);
        }
    }

    @Nested
    class Subtract {

        @Test
        @DisplayName("0에 0을 뺀다")
        void zero_zero() {
            // given
            int a = 0;
            int b = 0;
            int expectedResult = a - b;

            // when
            int actualResult = calculator.subtract(a, b);

            // then
            assertEquals(expectedResult, actualResult);
        }

        @Test
        @DisplayName("오버플로우 발생")
        void overflow() {
            // given
            int a = Integer.MAX_VALUE;
            int b = -1;

            // then
            String message = assertThrows(IllegalArgumentException.class, () -> calculator.subtract(a, b))
                    .getMessage();
            assertEquals(String.format("(%d) - (%d)는 오버플로우가 발생합니다.", a, b), message);
        }

        @Test
        @DisplayName("언더플로우 발생")
        void underflow() {
            // given
            int a = Integer.MIN_VALUE;
            int b = 1;

            // then
            String message = assertThrows(IllegalArgumentException.class, () -> calculator.subtract(a, b))
                    .getMessage();
            assertEquals(String.format("(%d) - (%d)는 언더플로우가 발생합니다.", a, b), message);
        }

        @Test
        @DisplayName("양수에 양수를 뺀다")
        void positive_positive() {
            // given
            int a = 6;
            int b = 3;
            int expectedResult = a - b;

            // when
            int actualResult = calculator.subtract(a, b);

            // then
            assertEquals(expectedResult, actualResult);
        }

        @Test
        @DisplayName("양수에 음수를 뺀다")
        void positive_negative() {
            // given
            int a = 6;
            int b = -3;
            int expectedResult = a - b;

            // when
            int actualResult = calculator.subtract(a, b);

            // then
            assertEquals(expectedResult, actualResult);
        }

        @Test
        @DisplayName("음수에 양수를 뺀다")
        void negative_positive() {
            // given
            int a = -6;
            int b = 3;
            int expectedResult = a - b;

            // when
            int actualResult = calculator.subtract(a, b);

            // then
            assertEquals(expectedResult, actualResult);
        }

        @Test
        @DisplayName("음수에 음수를 뺀다")
        void negative_negative() {
            // given
            int a = -6;
            int b = -3;
            int expectedResult = a - b;

            // when
            int actualResult = calculator.subtract(a, b);

            // then
            assertEquals(expectedResult, actualResult);
        }
    }

    @Nested
    class Multiply {

        @Test
        @DisplayName("0에 0을 곱한다")
        void zero_zero() {
            // given
            int a = 0;
            int b = 0;
            int expectedResult = a * b;

            // when
            int actualResult = calculator.multiply(a, b);

            // then
            assertEquals(expectedResult, actualResult);
        }

        @Test
        @DisplayName("오버플로우 발생")
        void overflow() {
            // given
            int a = Integer.MAX_VALUE;
            int b = 2;

            // then
            String message = assertThrows(IllegalArgumentException.class, () -> calculator.multiply(a, b))
                    .getMessage();
            assertEquals(String.format("(%d) * (%d)는 오버플로우가 발생합니다.", a, b), message);
        }

        @Test
        @DisplayName("언더플로우 발생")
        void underflow() {
            // given
            int a = Integer.MIN_VALUE;
            int b = 2;

            // then
            String message = assertThrows(IllegalArgumentException.class, () -> calculator.multiply(a, b))
                    .getMessage();
            assertEquals(String.format("(%d) * (%d)는 언더플로우가 발생합니다.", a, b), message);
        }

        @Test
        @DisplayName("양수에 양수를 곱한다")
        void positive_positive() {
            // given
            int a = 6;
            int b = 3;
            int expectedResult = a * b;

            // when
            int actualResult = calculator.multiply(a, b);

            // then
            assertEquals(expectedResult, actualResult);
        }

        @Test
        @DisplayName("양수에 음수를 곱한다")
        void positive_negative() {
            // given
            int a = 6;
            int b = -3;
            int expectedResult = a * b;

            // when
            int actualResult = calculator.multiply(a, b);

            // then
            assertEquals(expectedResult, actualResult);
        }

        @Test
        @DisplayName("음수에 양수를 곱한다")
        void negative_positive() {
            // given
            int a = -6;
            int b = 3;
            int expectedResult = a * b;

            // when
            int actualResult = calculator.multiply(a, b);

            // then
            assertEquals(expectedResult, actualResult);
        }

        @Test
        @DisplayName("음수에 음수를 곱한다")
        void negative_negative() {
            // given
            int a = -6;
            int b = -3;
            int expectedResult = a * b;

            // when
            int actualResult = calculator.multiply(a, b);

            // then
            assertEquals(expectedResult, actualResult);
        }
    }

    @Nested
    class Divide {

        @Test
        @DisplayName("0으로 나눌 경우 예외가 발생한다")
        void divideZero() {
            // given
            int a = 6;
            int b = 0;

            // then
            String message = assertThrows(IllegalArgumentException.class, () -> calculator.divide(a, b))
                    .getMessage();
            assertEquals("0으로 나눌 수 없습니다.", message);
        }

        @Test
        @DisplayName("양수에 양수를 나눈다")
        void positive_positive() {
            // given
            int a = 6;
            int b = 3;
            int expectedResult = a / b;

            // when
            int actualResult = calculator.divide(a, b);

            // then
            assertEquals(expectedResult, actualResult);
        }

        @Test
        @DisplayName("양수에 음수를 나눈다")
        void positive_negative() {
            // given
            int a = 6;
            int b = -3;
            int expectedResult = a / b;

            // when
            int actualResult = calculator.divide(a, b);

            // then
            assertEquals(expectedResult, actualResult);
        }

        @Test
        @DisplayName("음수에 양수를 나눈다")
        void negative_positive() {
            // given
            int a = -6;
            int b = 3;
            int expectedResult = a / b;

            // when
            int actualResult = calculator.divide(a, b);

            // then
            assertEquals(expectedResult, actualResult);
        }

        @Test
        @DisplayName("음수에 음수를 나눈다")
        void negative_negative() {
            // given
            int a = -6;
            int b = -3;
            int expectedResult = a / b;

            // when
            int actualResult = calculator.divide(a, b);

            // then
            assertEquals(expectedResult, actualResult);
        }
    }
}
