import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stringCalc.ValueValidator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValueValidatorTest {

    @Test
    @DisplayName("음수 값이 포함되면 RuntimeException을 던진다.")
    void givenNegative_whenValidate_thenThrowsRuntimeException() {
        assertThrows(RuntimeException.class, () -> ValueValidator.validate(List.of("1", "2", "-1")));
    }

    @Test
    void givenNotNumberValue_whenValidate_thenThrowsRuntimeException() {
        assertThrows(RuntimeException.class, () -> ValueValidator.validate(List.of("a", "2", "1")));
    }
}
