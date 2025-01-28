import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("문자열 계산기 테스트")
class StringCalculatorTest {

    @Test
    @DisplayName("빈 문자열이 0을 반환하는가?")
    void testEmptyString() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.addString(""), "빈 문자열은 0을 반환해야 합니다.");
    }

    @Test
    @DisplayName("단일 숫자를 입력하면 해당 숫자가 반환이 되는가?")
    void testSingleNumber() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(5, calculator.addString("5"), "단일 숫자는 해당 숫자를 반환해야 합니다.");
    }

    @Test
    @DisplayName("쉼표(,)로 구분된 숫자들의 합이 올바르게 반환되는가?")
    void testCommaSeparatedNumbers() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.addString("1,2,3"), "쉼표 구분자로 이루어진 숫자의 합이 올바르게 계산되어야 합니다.");
    }

    @Test
    @DisplayName("콜론(:)로 구분된 숫자들의 합이 올바르게 반환되는가?")
    void testColonSeparatedNumbers() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.addString("1:2:3"), "콜론 구분자로 이루어진 숫자의 합이 올바르게 계산되어야 합니다.");
    }

    @Test
    @DisplayName("쉼표와 콜론이 혼합된 경우에도 합을 올바르게 계산해야 합니다.")
    void testMixedDelimiters() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(10, calculator.addString("1,2:3,4"), "쉼표와 콜론 구분자로 이루어진 숫자의 합이 올바르게 계산되어야 합니다.");
    }

    @Test
    @DisplayName("커스텀 구분자가 있는 경우에도 합이 올바르게 반환되는가?")
    void testCustomDelimiter() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.addString("//;\\n1;2;3"), "커스텀 구분자가 올바르게 처리되지 않았습니다.");
    }


    @Test
    @DisplayName("음수가 포함된 입력이 RuntimeException을 발생시키는가?")
    void testNegativeNumberThrowsException() {
        StringCalculator calculator = new StringCalculator();
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> calculator.addString("1,-2,3"));
        assertEquals("허용되지 않는 값(음수) : -2", exception.getMessage());
    }

    @Test
    @DisplayName("숫자가 아닌 값이 포함된 입력이 RuntimeException을 발생시키는가?")
    void testInvalidNumberThrowsException() {
        StringCalculator calculator = new StringCalculator();
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> calculator.addString("1,a,3"));
        assertEquals("허용되지 않는 값(숫자가 아님) : a", exception.getMessage());
    }
}
