import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static stringCalc.ValueValidator.validate;

public class ValueValidatorTest {

    @Test
    @DisplayName("음수 값이 포함되면 RuntimeException을 던진다.")
    void givenNegative_whenValidate_thenThrowsRuntimeException() {
        assertThatThrownBy(
                () -> validate(List.of("1", "2", "-1"))
        ).isInstanceOf(RuntimeException.class).hasMessageContaining("-1");
    }

    @Test
    void givenNotNumberValue_whenValidate_thenThrowsRuntimeException() {
        assertThatThrownBy(()->{validate(List.of("a", "2", "1"));})
                .isInstanceOf(RuntimeException.class).hasMessageContaining("a");
    }
}
