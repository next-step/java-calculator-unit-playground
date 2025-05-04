import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;


class StringCalculatorTest {

    StringCalculator calc = new StringCalculator();



    @Test
    @DisplayName("빈 문자열이나 null 이라면 404를 반환한다")
    void StringCalculatorTest1() {
        assertEquals(404, calc.sum(""));
        assertEquals(404, calc.sum(null));
        // AssertJ 리팩토링
        assertThat(calc.sum(null)).isEqualTo(404);
        assertThat(calc.sum("")).isEqualTo(404);
    }

    @Test
    @DisplayName("기본 구분자 테스트")
    void StringCalculatorTest2() {
        assertEquals(6, calc.sum("1,2:3"));
        assertEquals(10, calc.sum("2,3:5"));
        assertThat(calc.sum("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자 확인")
    void StringCalculatorTest3() {
        assertEquals(6, calc.sum("//;\n1;2;3"));
        assertEquals(15, calc.sum("//|\n4|5|6"));
        assertThat(calc.sum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName("음수 입력시 예외처리")
    void StringCalculatorTest4() {
        assertThrows(RuntimeException.class, () -> calc.sum("1,-2,3"));
        assertThrows(RuntimeException.class, () -> calc.sum("//;\n1;-2;3"));

        Throwable thrown = catchThrowable(() -> calc.sum("1,-2,3"));
        // AssertJ 방식의 예외처리
        assertThat(thrown)
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("-2");
                // 메시지 검증
    }

    @Test
    @DisplayName("숫자 외 다른 문자 입력시 예외처리")
    void StringCalculatorTest5() {
        assertThrows(RuntimeException.class, () -> calc.sum("1,a,3"));
        assertThrows(RuntimeException.class, () -> calc.sum("2,#,3"));
        assertThrows(RuntimeException.class, () -> calc.sum("//;\n1;하이;3"));

        Throwable thrown2 = catchThrowable(() -> calc.sum("//;\n1;하이;3"));
        assertThat(thrown2)
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("하이");

    }

    @Test
    @DisplayName("잘못된 커스텀 구분자 작성시 예외처리")
    void StringCalculatorTest6() {
        assertThrows(RuntimeException.class, () -> calc.sum("//;\n"));
        assertThrows(RuntimeException.class, () -> calc.sum("//;\n;"));
        assertThrows(RuntimeException.class, () -> calc.sum("//"));

        Throwable thrown3 = catchThrowable(() -> calc.sum("//;\n;"));
        assertThat(thrown3)
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining(";");
    }

    @Test
    @DisplayName("구분자가 연속으로 들어와도 처리")
    void StringCalculatorTest7() {
        assertEquals(10, calc.sum("1,,2::3,4"));
        assertThat(calc.sum("1,,2::3,4")).isEqualTo(10);
    }
}
