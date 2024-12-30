import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssertJTest {
    @Nested
    @DisplayName("@Test 계산기 테스트")
    class TestAnnotationTest {

        @Test
        @DisplayName("덧셈 테스트")
        void Test_plus() {
            Calculation calc = new Calculation();

            assertThat(calc.plus(1, 2))
                    .as("정수 더하기")
                    .isEqualTo(3);

            assertThat(calc.plus(0.1, 2))
                    .as("소숫점 더하기")
                    .isEqualTo(2.1);

            assertThat(calc.plus(1, -1))
                    .as("양수 음수 더하기")
                    .isEqualTo(0);
        }

        @Test
        @DisplayName("뺄셈 테스트")
        void Test_minus() {
            Calculation calc = new Calculation();

            assertThat(calc.minus(1, 2))
                    .as("정수 빼기")
                    .isEqualTo(-1);

            assertThat(calc.minus(0.1, 2))
                    .as("소숫점 빼기")
                    .isEqualTo(-1.9);

            assertThat(calc.minus(1, -1))
                    .as("양수 음수 빼기")
                    .isEqualTo(2);
        }

        @Test
        @DisplayName("나눗셈 테스트")
        void Test_division() {
            Calculation calc = new Calculation();

            assertThat(calc.division(1, 2))
                    .as("소숫점 결과 나눗셈")
                    .isEqualTo(0.5);

            assertThat(calc.division(4, 2))
                    .as("정수 결과 나눗셈")
                    .isEqualTo(2);

            assertThat(calc.division(1, -1))
                    .as("음수 나눗셈")
                    .isEqualTo(-1);
        }

        @Test
        @DisplayName("곱셈 테스트")
        void Test_multiplication() {
            Calculation calc = new Calculation();

            assertThat(calc.multiplication(1, 2))
                    .as("정수 곱셈")
                    .isEqualTo(2);

            assertThat(calc.multiplication(-1, 2))
                    .as("음수 정수 곱셈")
                    .isEqualTo(-2);

            assertThat(calc.multiplication(0.1, 0.2))
                    .as("소숫점 곱셈")
                    .isEqualTo(0.02);
        }

        @Test
        @DisplayName("문자열 덧셈 테스트")
        void Test_stringPlusCalc() {
            Calculation calc = new Calculation();

            assertThatExceptionOfType(RuntimeException.class)
                    .isThrownBy(() -> calc.stringPlusCalc(""))
                    .withMessage("숫자와 구분자만 입력하세요");

            assertThat(calc.stringPlusCalc("1,2"))
                    .as("쉼표 구분자")
                    .isEqualTo(3);

            assertThat(calc.stringPlusCalc("1:2:3"))
                    .as("콜론 구분자")
                    .isEqualTo(6);

            assertThat(calc.stringPlusCalc("1,2:3,4"))
                    .as("기본 구분자 혼합")
                    .isEqualTo(10);

            assertThat(calc.stringPlusCalc("//;\n1;2;3"))
                    .as("커스텀 구분자")
                    .isEqualTo(6);

            assertThat(calc.stringPlusCalc("//-\n1-2-3,4:5"))
                    .as("커스텀 구분자와 기본 구분자 혼합")
                    .isEqualTo(15);

            assertThatExceptionOfType(RuntimeException.class)
                    .isThrownBy(() -> calc.stringPlusCalc("1,abc,3"))
                    .withMessage("숫자와 구분자만 입력하세요");
        }
    }
}
