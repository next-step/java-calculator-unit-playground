import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    StringCalculator stringCalculator = new StringCalculator();

    @Test
    @DisplayName("메소드가 잘 동작하는지")
    void multiply_두수의_곱을_반환() {
        assertAll(
                () -> assertEquals(0, stringCalculator.sum("")),
                () -> assertEquals(3, stringCalculator.sum("1,2")),
                () -> assertEquals(6, stringCalculator.sum("1,2,3")),
                () -> assertEquals(6, stringCalculator.sum("1,2:3")),
                () -> assertEquals(6, stringCalculator.sum("//;\n1;2;3"))
        );

    }


    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1,2:3", "//;\n1;2;3"})
    @DisplayName("여러 문자열 구분자를 입력받아 숫자들을 분리한 후 합산한다")
    void 메소드가_정상인지_반복테스트(String value) {
        assertEquals(stringCalculator.sum(value), 6);
    }

    @Test
    @DisplayName("숫자 이외의 값이 들어오면 RuntimeException을 던진다")
    void 숫자_이외의_값_입력_예외발생() {
        assertThrows(RuntimeException.class, () -> {
            stringCalculator.sum("//;\nㄱ;2;3");
        });
    }

    @Test
    @DisplayName("음수가 들어온다면 RuntimeException을 던진다")
    void 음수_입력_예외발생() {
        assertThrows(RuntimeException.class, () -> {
            stringCalculator.sum("-1,2,3");
        });
    }

}


