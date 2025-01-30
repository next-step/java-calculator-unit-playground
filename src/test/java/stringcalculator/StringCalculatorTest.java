package stringcalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    private final StringCalculator calculator =new StringCalculator();
    @Test
    void testEmptyString() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> calculator.delimiters(""),"값이 없거나 0이면 안된다.");
        //assertThat(calculator.delimiers(("")).isEqualTo(0);
    }
    @Test
    void testSingleNumber() {
        assertEquals(1,calculator.delimiters("1"),"1이 나와야함.");
        //assertThat(calculator.delimiters(("1")).isEqualTo(1);
    }
    @Test
    void testTwoNumbersWithComma() {
        assertEquals(3,calculator.delimiters("1,2"),"1+2이므로 3나와야함");
        //assertThat(calculator.delimiters(("1,2")).isEqualTo(3);
    }
    @Test
    void testmultipleNumberswithCommaandColon(){
        assertEquals(6,calculator.delimiters("1,2:3"),"6이 나와야함");
        //assertThat(calculator.delimiters(("1,2:3")).isEqualTo(6);
    }
    @Test
    void testCustomDelimiter(){
        assertEquals(7,calculator.delimiters("//-\n1-2:4"),"7이 나와야함");
        //assertThat(calculator.delimiters(("//-\n1-2")).isEqualTo(3);
    }
    @Test
    void testInvalidInput(){
        RuntimeException exception = assertThrows(RuntimeException.class, () -> calculator.delimiters(("1,아,3")));
        assertEquals("숫자를 입력해주세요." , exception.getMessage());
        //assertThatThrownBy(()-> calculator.delimiters(("1,아,3"))
//                .isInstanceOf(RuntimeException.class)
//                .MessageContaining("숫자를 입력해주세요.");
    }
    @Test
    void testNegativeNumber(){
        RuntimeException exception = assertThrows(RuntimeException.class, () -> calculator.delimiters("1,-2,3"));
        assertEquals("음수는 허용이 안된다.", exception.getMessage());
        //assertThatThrownBy(()-> calculator.delimiters(("1,-2,3"))
//                .isInstanceOf(RuntimeException.class)
//                .MessageContaining("음수는 허용이 안된다.");
    }
}
