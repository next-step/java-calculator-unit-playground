import static org.assertj.core.api.Assertions.*;

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
            int a = 2;
            int b = 3;

            // When
            int actual = calculator.add(a, b);

            // Then
            int expected = 5;
            assertThat(actual).isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("뺄셈 테스트")
    public class SubtractTest {

        @Test
        public void 정수_빼기() {
            // Given
            int a = 3;
            int b = 2;

            // When
            int actual = calculator.subtract(a, b);

            // Then
            int expected = 1;
            assertThat(actual).isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("곱셈 테스트")
    public class MultiplyTest {

        @Test
        public void 정수_곱하기() {
            // Given
            int a = 2;
            int b = 3;

            // When
            int actual = calculator.multiply(a, b);

            // Then
            int expected = 6;
            assertThat(actual).isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("나눗셈 테스트")
    public class DivideTest {

        @Test
        public void 정수_나누기() {
            // Given
            int a = 6;
            int b = 3;

            // When
            int actual = calculator.divide(a, b);

            // Then
            int expected = 2;
            assertThat(actual).isEqualTo(expected);
        }

        @Test
        public void 예외_0_나누기() {
            // Given
            int a = 1;
            int b = 0;

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
            int a = 5;
            int b = 2;

            // When
            int actual = calculator.divide(a, b);

            // Then
            int expected = 2; // 결과값은 정수로 나옴
            assertThat(actual).isEqualTo(expected);
        }
    }

}
