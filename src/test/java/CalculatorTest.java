import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {


    @Test
    @DisplayName("두 숫자의 덧셈을 확인")
    void addTest() {
        int num1 = 3;
        int num2 = 4;

        int actual = num1 + num2;

        int expected = Calculator.add(num1, num2);
        // 해당 클래스 내의 메소드 불러오기

        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("두 숫자의 뺄셈을 확인")
    void subtractTest() {
        int num1 = 10;
        int num2 = 4;

        int actual = num1 - num2;

        int expected = Calculator.subtract(num1, num2);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("두 숫자의 곱을 확인")
    void multiplyTest() {
        int num1 = 4;
        int num2 = 6;

        int actual = num1 * num2;

        int expected = Calculator.multiply(num1, num2);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("두 숫자의 몫을 확인")
    void divideTest() {
        int num1 = 30;
        int num2 = 7;

        int actual = num1 / num2;

        int expected = Calculator.divide(num1, num2);

        assertEquals(expected, actual);
    }
}
