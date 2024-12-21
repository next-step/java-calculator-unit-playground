
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


@DisplayName("JUnit5 테스트")
public class JUnit5Test {
    @Nested
    @DisplayName("@Test 계산기 테스트")
    class TestAnnotationTest {
        @Test
        @DisplayName("덧셈 테스트")
        void Test_plus() {
            Calculation calc = new Calculation();
            if (calc.plus(1, 2) == 3) {
                System.out.println("정수 더하기 성공");
            } else {
                throw new RuntimeException(calc.plus(1, 2) + "정수 더하기 실패");
            }

            if (calc.plus(0.1, 2) == 2.1) {
                System.out.println("소숫점 더하기 성공");
            } else {
                throw new RuntimeException(calc.plus(0.1, 2) + "소숫점 더하기 실패");
            }

            if (calc.plus(1, -1) == 0) {
                System.out.println("양수 음수 더하기 성공");
            } else {
                throw new RuntimeException(calc.plus(1, -1) + "양수 음수 더하기 실패");
            }
        }

        @Test
        @DisplayName("뺄셈 테스트")
        void Test_minus() {
            Calculation calc = new Calculation();
            if (calc.minus(1, 2) == -1) {
                System.out.println("정수 빼기 성공");
            } else {
                throw new RuntimeException(calc.minus(1, 2) + "정수 빼기 실패");
            }

            if (calc.minus(0.1, 2) == -1.9) {
                System.out.println("소숫점 빼기 성공");
            } else {
                throw new RuntimeException(calc.minus(0.1, 2) + "소숫점 빼기 실패");
            }

            if (calc.minus(1, -1) == 2) {
                System.out.println("양수 음수 빼기 성공");
            } else {
                throw new RuntimeException(calc.minus(1, -1) + "양수 음수 빼기 실패");
            }
        }

        @Test
        @DisplayName("나눗셈 테스트")
        void Test_division() {
            Calculation calc = new Calculation();
            if (calc.division(1, 2) == 0.5) {
                System.out.println("소숫점 결과 나눗셈 성공");
            } else {
                throw new RuntimeException(calc.division(1, 2) + "소숫점 결과 나눗셈 실패");
            }

            if (calc.division(4, 2) == 2) {
                System.out.println("정수 결과 나눗셈 성공");
            } else {
                throw new RuntimeException(calc.division(4, 2) + "정수 결과 나눗셈 실패");
            }

            if (calc.division(1, -1) == -1) {
                System.out.println("음수 나눗셈 성공");
            } else {
                throw new RuntimeException(calc.division(1, -1) + "음수 나눗셈 실패");
            }
        }

        @Test
        @DisplayName("곱셈 테스트")
        void Test_multiplication() {
            Calculation calc = new Calculation();
            if (calc.multiplication(1, 2) == 2) {
                System.out.println("정수 곱셈 성공");
            } else {
                throw new RuntimeException(calc.multiplication(1, 2) + "정수 곱셈 실패");
            }

            if (calc.multiplication(-1, 2) == -2) {
                System.out.println("음수 정수 곱셈 성공");
            } else {
                throw new RuntimeException(calc.multiplication(-1, 2) + "음수 정수 곱셈 실패");
            }

            if (calc.multiplication(0.1, 0.2) == 0.02) {
                System.out.println("소숫점 곱셈 성공");
            } else {
                throw new RuntimeException(calc.multiplication(0.1, 0.2) + "소숫점 곱셈 실패");
            }
        }
    }
}
