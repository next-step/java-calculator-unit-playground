
@DisplayName("계산기 작동 테스트")
public class CalcTest {
    @Test
    @DisplayName("더하기 테스트")
    void add() {
        final var a = 1;
        final var b = 2;
        final var actual = a + b;
        final var expected = 3;
        
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("빼기 테스트")
    void add() {
        final var a = 3;
        final var b = 1;
        final var actual = a - b;
        final var expected = 2;
        
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("곱하기 테스트")
    void add() {
        final var a = 2;
        final var b = 3;
        final var actual = a * b;
        final var expected = 6;
        
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("나누기 테스트")
    void add() {
        final var a = 10;
        final var b = 5;
        final var actual = a / b;
        final var expected = 2;
        
        assertEquals(expected, actual);
    }
}