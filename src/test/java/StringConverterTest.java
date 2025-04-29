import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringConverterTest {

    @Test
    @DisplayName("입력된 문자열을 정상적으로 숫자로 변환한다.")
    void shouldConvertNumber_whenInputString() {
        // given
        String[] token = new String[]{"1", "2", "3"};
        StringConverter stringConverter = new StringConverter();

        // when
        List<Integer> converterNumbers = stringConverter.convertAndValidateNumbers(token);

        // then
        assertEquals(converterNumbers, List.of(1, 2, 3));
    }

    @Test
    @DisplayName("숫자가 아닌 값을 입력했을 경우 예외가 발생한다.")
    void shouldThrowException_whenUn() {
        // given
        String[] token = new String[]{"1", "ab", "3"};
        StringConverter stringConverter = new StringConverter();

        // when
        RuntimeException e = assertThrows(RuntimeException.class,
                () ->stringConverter.convertAndValidateNumbers(token)
        );

        // then
        assertEquals(e.getMessage(), "숫자가 아닌 다른 값이 입력되었습니다.");
    }

    @Test
    @DisplayName("음수를 입력했을 경우 예외가 발생한다.")
    void shouldThrowException_whenNegativeNumber() {
        // given
        String[] token = new String[]{"-1", "2", "3"};
        StringConverter stringConverter = new StringConverter();

        // when
        RuntimeException e = assertThrows(RuntimeException.class,
                () ->stringConverter.convertAndValidateNumbers(token)
        );

        // then
        assertEquals(e.getMessage(), "양의 정수만 입력할 수 있습니다.");
    }
}
