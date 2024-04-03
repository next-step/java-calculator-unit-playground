import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class StringSumCalculaterTest {

    StringSumCalculater stringSumCalculater = new StringSumCalculater();

    @Test
    @DisplayName("배열의 모든 요소를 더한다.")
    void add() {
        int sum = stringSumCalculater.add("//;\n1:2,3;4");
        assertEquals(10, sum);
        assertThrows(RuntimeException.class, () -> stringSumCalculater.add("//;\n1:-2,3;4"));
    }
}
