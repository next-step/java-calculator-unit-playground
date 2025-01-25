import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("사칙연산 계산기 테스트")
public class FourBasicArithmaticOperationsTest {

    @Test
    public void plusTest(){
        FourBasicArithmaticOperations oper = new FourBasicArithmaticOperations();
        assertEquals(3, oper.plus(1, 2));
        assertEquals(1, oper.plus(-1, 2));
        assertEquals(-1, oper.plus(1, -2));
        assertEquals(-3, oper.plus(-1, -2));
        assertThrows(RuntimeException.class, ()->oper.plus(Integer.MAX_VALUE, 1));
        assertThrows(RuntimeException.class, ()->oper.plus(Integer.MIN_VALUE, -1));
        assertEquals(0, oper.plus(0, 0));
    }

    @Test
    public void minusTest(){
        FourBasicArithmaticOperations oper = new FourBasicArithmaticOperations();
        assertEquals(-1, oper.minus(1, 2));
        assertEquals(-3, oper.minus(-1, 2));
        assertEquals(3, oper.minus(1, -2));
        assertEquals(1, oper.minus(-1, -2));
        assertEquals(Integer.MIN_VALUE+1, oper.minus(0, Integer.MAX_VALUE));
        assertThrows(RuntimeException.class, ()->oper.minus(-10, Integer.MAX_VALUE));
        assertThrows(RuntimeException.class, ()->oper.minus(Integer.MIN_VALUE, 1));
        assertEquals(0, oper.minus(0, 0));
    }

    @Test
    public void multiplyTest(){
        FourBasicArithmaticOperations oper = new FourBasicArithmaticOperations();
        assertEquals(6, oper.multiply(2, 3));
        assertEquals(0, oper.multiply(2, 0));
        assertEquals(0, oper.multiply(0, 3));
        assertEquals(0, oper.multiply(0, 0));
        assertThrows(RuntimeException.class, ()->oper.multiply(1000000, 1000000));
    }

    @Test
    public void divideTest(){
        FourBasicArithmaticOperations oper = new FourBasicArithmaticOperations();
        assertEquals(5, oper.divide(10, 2));
        assertEquals(1, oper.divide(3, 2));
        assertEquals(-1, oper.divide(-3, 2));
        assertThrows(RuntimeException.class, ()->oper.divide(3, 0));
        assertEquals(0, oper.divide(0, 1));
    }

}
