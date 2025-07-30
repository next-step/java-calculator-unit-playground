import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class StringCalculatorAssertJTest {
    private final StringCalculator stringCalculator = new StringCalculator();

    @Nested
    @DisplayName("덧셈 테스트")
    class AddTest {
        @Test
        void 빈_문자열() {
            // Given
            String input = "";

            // When
            int result = stringCalculator.add(input);

            // Then
            assertThat(result).isEqualTo(0);
        }

        @Test
        void 하나의_숫자() {
            // Given
            String input = "1";

            // When
            int result = stringCalculator.add(input);

            // Then
            assertThat(result).isEqualTo(1);
        }

        @Test
        void 두_숫자_더하기() {
            // Given
            String input = "1,2";

            // When
            int result = stringCalculator.add(input);

            // Then
            assertThat(result).isEqualTo(3);
        }

        @Test
        void 여러_숫자_더하기() {
            // Given
            String input = "1,2,3";

            // When
            int result = stringCalculator.add(input);

            // Then
            assertThat(result).isEqualTo(6);
        }

        @Test
        void 커스텀_구분자() {
            // Given
            String input = "//;\n4;5,1:2";

            // When
            int result = stringCalculator.add(input);

            // Then
            assertThat(result).isEqualTo(12);
        }

        @Test
        void 음수_예외() {
            // Given
            String input = "-1";

            // When & Then
            assertThatThrownBy(() -> stringCalculator.add(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("음수는 허용되지 않습니다");

        }

        @Test
        void 숫자가_아닌_예외() {
            // Given
            String input = "1,a";

            // When & Then
            assertThatThrownBy(() -> stringCalculator.add(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("숫자가 아닌 값이 포함되어 있습니다");
        }
    }
}
