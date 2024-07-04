import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringSumCalculaterTest {

    StringSumCalculater stringSumCalculater = new StringSumCalculater();

    @Test
    @DisplayName("배열의 모든 요소를 더한다.")
    void add() {
        int sum = stringSumCalculater.add("//;\n1:2,3;4");
        assertThat(sum).isEqualTo(10);
        assertThrows(RuntimeException.class, () -> stringSumCalculater.add("//;\n1:-2,3;4"));
    }
}
