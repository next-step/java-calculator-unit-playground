package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class ArithmeticCalculatorTest {

    @DisplayName("더하기 테스트")
    @Test
    void 더하기_테스트() {

    }

    @DisplayName("뺴기 테스트")
    @Test
    void 빼기_테스트() {
        ArithmeticCalculator cal = new ArithmeticCalculator();
//        cal.minusCalculate(5, 3);
    }

    @DisplayName("나누기 테스트")
    @Test
    void 나누기_테스트() {
        ArithmeticCalculator cal = new ArithmeticCalculator();
//        cal.divideCalculate(6, 3);
    }

    @DisplayName("나누기테스트")
    @Test
    void 곱하기_테스트() {
        ArithmeticCalculator cal = new ArithmeticCalculator();
//        cal.multipleCaculate(3, 5);
    }
}