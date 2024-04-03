import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringSumCalculaterTest {

    StringSumCalculater stringSumCalculater = new StringSumCalculater();

    @Test
    void add() {
        int sum = stringSumCalculater.add("//;\n1:2,3;4");
        assertEquals(10, sum);
        assertThrows(RuntimeException.class, () -> stringSumCalculater.add("//;\n1:-2,3;4"));
    }
}
