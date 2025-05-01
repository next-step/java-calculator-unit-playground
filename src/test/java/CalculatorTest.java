import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    Calculator c = new Calculator();

    @Test
    void testAdd(){
        int result = c.add(2,3);
        assertEquals(5,result);
    }
    @Test
    void testSubtract(){
        int result = c.subtract(2,3);
        assertEquals(-1,result);
    }

    @Test
    void testMultiply(){
        int result = c.multiply(2,3);
        assertEquals(6,result);
    }
    @Test
    void testDivide(){
        int result = c.divide(6,3);
        assertEquals(2,result);
    }

    @Test
    void testCalculateString(){
        int result = c.calculateString("1,2:3");
        assertEquals(6,result);
        result = c.calculateString("");
        assertEquals(0,result);
        result = c.calculateString("1,2");
        assertEquals(3,result);
        result = c.calculateString("1,2,3");
        assertEquals(6,result);
    }
}
