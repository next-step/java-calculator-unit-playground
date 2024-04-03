import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class InputToNumberProviderTest {

    InputToNumberProvider inputToNumberProvider = new InputToNumberProvider();

    @Test
    void getNumbers() {
        int[] numbers = inputToNumberProvider.getNumbers("1:2,3;4");
        int[] expected = {1, 2, 3, 4};
        assertThat(numbers).isSameAs(expected);
        assertThatThrownBy(() -> {
            inputToNumberProvider.getNumbers("//;\n1:2,-3;4");
        }).isInstanceOf(RuntimeException.class);
    }
}
