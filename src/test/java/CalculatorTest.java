// import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
// import org.junit.jupiter.params.ParameterizedTest;
// import org.junit.jupiter.params.provider.Arguments;
// import org.junit.jupiter.params.provider.MethodSource;
// import org.junit.jupiter.params.provider.ValueSource;
// import org.junit.jupiter.api.TestMethodOrder;

// import java.util.List;
// import java.util.stream.Stream;

// import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertInstanceOf;
// import static org.junit.jupiter.api.Assertions.assertThrows;
// import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;


public class CalculatorTest {

    @Nested
    public class TestFunction {
        @Test
        @DisplayName("덧셈 테스트")
        void addTest() {
            Calculator c = new Calculator();
            assertEquals(3, c.add(1, 2), "실패 : 양수 + 양수");
            assertEquals(-1, c.add(1, -2), "실패 : 양수 + 음수");
            assertEquals(-1, c.add(-3, 2), "실패 : 음수 + 양수");
            assertEquals(-13, c.add(-11, -2), "실패 : 음수 + 음수");
        }

        @Test
        @DisplayName("뺄셈 테스트")
        void Test() {
            Calculator c = new Calculator();
            assertEquals(-1, c.sub(1, 2), "실패 : 양수 - 양수");
            assertEquals(-3, c.sub(-1, 2), "실패 : 음수 - 양수");
        }

        @Test
        @DisplayName("곱셈 테스트")
        void mulTest() {
            Calculator c = new Calculator();
            assertEquals(2, c.mul(1, 2), "실패 : 양수 * 양수");
            assertEquals(-6, c.mul(-3, 2), "실패 : 음수 * 양수");
        }

        @Test
        @DisplayName("나눗셈 테스트")
        void divTest() {
            Calculator c = new Calculator();
            assertEquals(4, c.div(8, 2), "실패 : 양수 / 양수");
            assertEquals(-2, c.div(-4, 2), "실패 : 음수 / 양수");
        }


    }
}
