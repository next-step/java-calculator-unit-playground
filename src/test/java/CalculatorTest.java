import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    @DisplayName("두 수를 받아 덧셈을 한다.")
    void addTest(){
        assertEquals(3, calculator.add(1, 2));
    }

    @Test
    @DisplayName("두 수를 받아 뺄셈을 한다.")
    void substractTest(){
        assertEquals(-1, calculator.substract(1, 2));
    }

    @Test
    @DisplayName("두 수를 받아 곱셈을 한다.")
    void multipleTest(){
        assertEquals(2, calculator.multiple(1, 2));
    }

    @Test
    @DisplayName("두 수를 받아 나눗셈을 한다.")
    void divideTest(){
        assertEquals(0, calculator.divide(1, 2));
    }

    @Test
    @DisplayName("두 수를 받아 사칙 연산을 한다.")
    void calculatorTest(){
        assertAll(
            () -> assertEquals(3, calculator.add(1, 2)),
            () -> assertEquals(-1, calculator.substract(1, 2)),
            () -> assertEquals(2, calculator.multiple(1, 2)),
            () -> assertEquals(0, calculator.divide(1, 2))
        );
    }

}
