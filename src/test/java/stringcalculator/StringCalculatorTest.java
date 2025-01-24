package stringcalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    private final StringCalculator calculator =new StringCalculator();
    @Test
    void testEmptyString() {
        assertEquals(0,calculator.add(""),"공백은 0을 반환해야함.");
        assertThat(calculator.add("")).isEqualTo(0);
    }
    @Test
    void testSingleNumber() {
        assertEquals(1,calculator.add("1"),"1이 나와야함.");
        assertThat(calculator.add("1")).isEqualTo(1);
    }
    @Test
    void testTwoNumbersWithComma() {
        assertEquals(3,calculator.add("1,2"),"1+2이므로 3나와야함");
        assertThat(calculator.add("1,2")).isEqualTo(3);
    }
    @Test
    void testmultipleNumberswithCommaandColon(){
        assertEquals(6,calculator.add("1,2:3"),"6이 나와야함");
        assertThat(calculator.add("1,2:3")).isEqualTo(6);
    }
    @Test
    void testCustomDelimiter(){
        assertEquals(3,calculator.add("//-\n1-2"),"3이 나와야함");
        assertThat(calculator.add("//-\n1-2")).isEqualTo(3);
    }
    @Test
    void testInvalidInput(){
        RuntimeException exception = assertThrows(RuntimeException.class, () -> calculator.add("1,아,3"));
        assertEquals("숫자를 입력해주세요." , exception.getMessage());
        assertThatTrownBy(()-> calculator.add("1,아,3"))
                .isInstanceOf(RuntimeException.class)
                .MessageContaining("숫자를 입력해주세요.");
    }
    @Test
    void testNegativeNumber(){
        RuntimeException exception = assertThrows(RuntimeException.class, () -> calculator.add("1,-2,3"));
        assertEquals("음수는 허용이 안된다.", exception.getMessage());
        assertThatTrwonBy(()-> calculator.add("1,-2,3"))
                .isInstanceOf(RuntimeException.class)
                .MessageContaining("음수는 허용이 안된다.");
    }
}
