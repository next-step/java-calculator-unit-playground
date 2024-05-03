package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class arithmeticCalculatorTest {

    @DisplayName("더하기 테스트")
    @Test
    void 더하기_테스트() {
        arithmeticCalculator cal = new arithmeticCalculator();
        cal.plusCalculate(3, 5);
    }

    @DisplayName("뺴기 테스트")
    @Test
    void 빼기_테스트() {
        arithmeticCalculator cal = new arithmeticCalculator();
        cal.minusCalculate(5, 3);
    }

    @DisplayName("나누기 테스트")
    @Test
    void 나누기_테스트() {
        arithmeticCalculator cal = new arithmeticCalculator();
        cal.divideCalculate(6, 3);
    }

    @DisplayName("나누기테스트")
    @Test
    void 곱하기_테스트() {
        arithmeticCalculator cal = new arithmeticCalculator();
        cal.multipleCaculate(3, 5);
    }
}