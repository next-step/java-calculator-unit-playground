import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("문자열 계산기 테스트")
public class StringCalculratorTest {
    @Test
    public void NonDelimiterTest(){
        StringCalculrator calcul = new StringCalculrator();
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
    public void ExistDelimiterTest(){
        StringCalculrator calcul = new StringCalculrator();
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
    public void ExceptionTest(){
        StringCalculrator calcul = new StringCalculrator();
        assertThrows(RuntimeException.class, ()->calcul.strPlus("1!2!3"));
        assertThrows(RuntimeException.class, ()->calcul.strPlus("1 2 3"));
        assertThrows(RuntimeException.class, ()->calcul.strPlus("1000000000000,2000000000000"));
        assertThrows(RuntimeException.class, ()->calcul.strPlus("1000000000,1000000000,1000000000"));
        assertThrows(RuntimeException.class, ()->calcul.strPlus("1000000000,2000000000,3000000000"));
        assertThrows(RuntimeException.class, ()->calcul.strPlus("!!,@@"));
        assertThrows(RuntimeException.class, ()->calcul.strPlus("-1,-2"));        
        
    }

}
