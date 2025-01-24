package calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @Test
    void testAdd(){
        Calculator calculator = new Calculator();
        int result = calculator.add(5,3);
        assertEquals(8,result,"예상결과 8");
        assertThat(result).isEqualTo(8)
    }
    @Test
    void testSub(){
        Calculator calculator = new Calculator();
        int result = calculator.subtract(5,3);
        assertEquals(2,result,"예상결과 2");
        assertThat(result).isEqualTo(2)
    }
    @Test
    void testdivide(){
        Calculator calculator = new Calculator();
        int result = calculator.divide(5,5);
        assertEquals(1,result,"예상결과 1");
        assertThat(result).isEqualTo(1)
    }
    @Test
    void testmultiply(){
        Calculator calculator = new Calculator();
        int result = calculator.multiply(5,3);
        assertEquals(15,result,"예상결과 15");
        assertThat(result).isEqualTo(15)
    }
    @Test
    void testmultiplyzero(){
        Calculator calculator = new Calculator();
        assertThrows(IllegalArgumentException.class,() -> calculator.divide(10,0),"0으로 나누면 오류");
        assertThatTrownBy( ()-> calculator.divide(10,0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0으로 나누면 오류");
    }
}