import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CalculatorAssertJTest {

    private final Calculator calculator = new Calculator();

    @Nested
    @DisplayName("덧셈 테스트")
    public class AddTest {

        @Test
        public void 정수_더하기() {
            // Given
            final int a = 2;
            final int b = 3;

            // When
            final int actual = calculator.add(a, b);

            // Then
            final int expected = 5;
            assertThat(actual).isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("뺄셈 테스트")
    public class SubtractTest {

        @Test
        public void 정수_빼기() {
            // Given
            final int a = 3;
            final int b = 2;

            // When
            final int actual = calculator.subtract(a, b);

            // Then
            final int expected = 1;
            assertThat(actual).isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("곱셈 테스트")
    public class MultiplyTest {

        @Test
        public void 정수_곱하기() {
            // Given
            final int a = 2;
            final int b = 3;

            // When
            final int actual = calculator.multiply(a, b);

            // Then
            final int expected = 6;
            assertThat(actual).isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("나눗셈 테스트")
    public class DivideTest {

        @Test
        public void 정수_나누기() {
            // Given
            final int a = 6;
            final int b = 3;

            // When
            final int actual = calculator.divide(a, b);

            // Then
            final int expected = 2;
            assertThat(actual).isEqualTo(expected);
        }

        @Test
        public void 예외_0_나누기() {
            // Given
            final int a = 1;
            final int b = 0;

            // When & Then
            assertThatThrownBy(() -> calculator.divide(a, b))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0 나누기 오류");

            assertThatCode(() -> calculator.divide(b, a))
                .doesNotThrowAnyException();
        }

        @Test
        public void 나누기_결과가_정수가_아닐때() {
            // Given
            final int a = 5;
            final int b = 2;

            // When
            final int actual = calculator.divide(a, b);

            // Then
            final int expected = 2; // 결과값은 정수로 나옴
            assertThat(actual).isEqualTo(expected);
        }
    }

}
