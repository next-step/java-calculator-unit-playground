import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("문자열 계산기 테스트")
public class StringCalculatorTest {
    private StringCalculator calcul = new StringCalculator();

    @Test
    public void nonDelimiterTest(){
        assertEquals(6, calcul.strPlus("1,2,3"));
        assertEquals(6, calcul.strPlus("1:2:3"));
        assertEquals(6, calcul.strPlus("1,2:3"));
        assertEquals(6, calcul.strPlus("1,:2::3"));
        assertEquals(6, calcul.strPlus("1,,,,2:3"));
        assertEquals(1, calcul.strPlus("1"));

        assertEquals(60, calcul.strPlus("10,20,30"));
        assertEquals(60, calcul.strPlus("10:20:30"));
        assertEquals(60, calcul.strPlus("10,20:30"));
        assertEquals(60, calcul.strPlus("10,:20::30"));
        assertEquals(60, calcul.strPlus("10,,,,20:30"));

        assertEquals(0, calcul.strPlus(""));
    }

    @Test
    public void existDelimiterTest(){
        assertEquals(6, calcul.strPlus("//;\n1;2;3"));
        assertEquals(0, calcul.strPlus("//;\n"));
        
        assertEquals(6, calcul.strPlus("//\t\n1\t2\t3"));
        assertEquals(6, calcul.strPlus("//!!\n1!!2!!3"));
        assertEquals(6, calcul.strPlus("//\n\n1\n2\n3"));
        assertEquals(5, calcul.strPlus("//1\n213"));

        assertEquals(60, calcul.strPlus("//;\n10;20;30"));
        assertEquals(60, calcul.strPlus("//\t\n10\t20\t30"));
    }

    @Test
    public void exceptionTest(){
        assertThrows(RuntimeException.class, ()->calcul.strPlus("1!2!3"));
        assertThrows(RuntimeException.class, ()->calcul.strPlus("1 2 3"));
        assertThrows(RuntimeException.class, ()->calcul.strPlus("1000000000000,2000000000000"));
        assertThrows(RuntimeException.class, ()->calcul.strPlus("1000000000,1000000000,1000000000"));
        assertThrows(RuntimeException.class, ()->calcul.strPlus("1000000000,2000000000,3000000000"));
        assertThrows(RuntimeException.class, ()->calcul.strPlus("!!,@@"));
        assertThrows(RuntimeException.class, ()->calcul.strPlus("-1,-2"));        
    }

}
