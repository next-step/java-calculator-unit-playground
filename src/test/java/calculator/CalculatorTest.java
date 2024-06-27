package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    void addTest() {
        assertEquals(3, calculator.add(1, 2));
    }

    @Test
    void minusTest() {
        assertEquals(1, calculator.minus(2, 1));
    }

    @Test
    void multipleTest() {
        assertEquals(2, calculator.multiply(2, 1));
        assertEquals(8, calculator.multiply(2, 4));
    }

    @Test
    void divideTest() {
        assertEquals(2, calculator.divide(8, 4));
    }

    @Test
    void stringSumTest() {
        assertEquals(15, calculator.stringSum("1;2;3;4,5"));
    }

    @Test
    void stringSumTestWithCustomSeq() {
        assertEquals(11, calculator.stringSum("//y\n1y5y1y1y1y2"));
    }

    @Nested
    class withWrongString {

        @Test
        void stringSumTestWithWrongString() {
            assertThrows(RuntimeException.class, () -> {
                calculator.stringSum("//y\n1t2t3");
            });
        }

        @Test
        void stringSumTestWithWrongString2() {
            assertThrows(RuntimeException.class, () -> {
                calculator.stringSum("/y\n1y2y3");
            });
        }

        @Test
        void stringSumTestWithWrongString3() {
            assertThrows(RuntimeException.class, () -> {
                calculator.stringSum("1,2,3,44:5");
            });
        }
    }
}
