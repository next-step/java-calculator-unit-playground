package stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import simpleCalculator.model.StringCalculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringCalculatorTestAssertJ {

    private static final int EXPECT_VALUE_ZERO = 0;
    private static final int EXPECT_VALUE_SIX = 6;

    @DisplayName("연산기능 테스트")
    @Nested
    class functionTest {

        @Test
        @DisplayName("값이 없거나 빈 경우")
        public void nullAndEmpty() {
            StringCalculator calculator = new StringCalculator();
            assertThat(EXPECT_VALUE_ZERO).isEqualTo(calculator.add(null));
            assertThat(EXPECT_VALUE_ZERO).isEqualTo(calculator.add(""));
        }

        @Test
        @DisplayName("기본 구분자를 사용하는 경우")
        public void addWithDefault() {
            StringCalculator calculator = new StringCalculator();
            assertThat(EXPECT_VALUE_SIX).isEqualTo(calculator.add("1,2,3"));
            assertThat(EXPECT_VALUE_SIX).isEqualTo(calculator.add("1,2:3"));
            assertThat(EXPECT_VALUE_SIX).isEqualTo(calculator.add("1:2,3"));
            assertThat(EXPECT_VALUE_SIX).isEqualTo(calculator.add("1:2:3"));
        }

        @Test
        @DisplayName("커스텀 구분자를 사용하는 경우")
        public void addWithCustom() {
            StringCalculator calculator = new StringCalculator();
            assertThat(EXPECT_VALUE_SIX).isEqualTo(calculator.add("//;\n1;2;3"));
        }
    }

    @DisplayName("예외처리 테스트")
    @Nested
    public class exceptionTest {

        @DisplayName("숫자가 아닌 다른 값을 입력한 경우")
        @Nested
        public class isNotNumber {

            @Test
            @DisplayName("예외처리 확인")
            public void onlyException() {
                StringCalculator calculator = new StringCalculator();
                assertThatThrownBy(() -> {
                    calculator.add("hi,1,2");
                }).isInstanceOf(RuntimeException.class);
            }

            @Test
            @DisplayName("예외처리와 예외메세지 확인")
            public void messageWithException() {
                StringCalculator calculator = new StringCalculator();
                assertThatThrownBy(() -> {
                    calculator.add("hi,1,2");
                }).isInstanceOf(RuntimeException.class)
                        .hasMessage("숫자가 아닌 다른 형식이 포함되었습니다.");
            }
        }

        @DisplayName("음수를 입력한 경우")
        @Nested
        public class isNegative {

            @Test
            @DisplayName("예외처리 확인")
            public void onlyException() {
                StringCalculator calculator = new StringCalculator();
                assertThatThrownBy(() -> {
                    calculator.add("-1,1,2");
                }).isInstanceOf(RuntimeException.class);
            }

            @Test
            @DisplayName("예외처리와 예외메세지 확인")
            public void messageWithException() {
                StringCalculator calculator = new StringCalculator();
                assertThatThrownBy(() -> {
                    calculator.add("-1,1,2");
                }).isInstanceOf(RuntimeException.class)
                        .hasMessage("음수는 입력할 수 없습니다.");
            }
        }
    }
}
