package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class splitStringTest {

    @Test
    @DisplayName("스플릿 테스트")
    void 스플릿_테스트() {
        SplitString sp = new SplitString();
        sp.splitStr("1,2,3");
    }

    @Test
    @DisplayName("더하기 테스트")
    void 덧셈_테스트() {
        SplitString sp = new SplitString();
        ArithmeticCalculator ar = new ArithmeticCalculator();
        sp.splitStr("1,2,3");
        ar.plusCalculate();
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void 뺄셈_테스트() {
        SplitString sp = new SplitString();
        ArithmeticCalculator ar = new ArithmeticCalculator();
        sp.splitStr("1,2,3");
        ar.minusCalculate();
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void 나눗셈_테스트() {
        SplitString sp = new SplitString();
        ArithmeticCalculator ar = new ArithmeticCalculator();
        sp.splitStr("4,2");
        ar.divideCalculate();
    }

    @Test
    @DisplayName("곱셈 테스트")
    void 곱셈_테스트() {
        SplitString sp = new SplitString();
        ArithmeticCalculator ar = new ArithmeticCalculator();
        sp.splitStr("1,2,3");
        ar.multipleCaculate();
    }

    @Test
    @DisplayName("예외처리 테스트")
    void 예외처리_테스트() {
        SplitString sp = new SplitString();
        ArithmeticCalculator ar = new ArithmeticCalculator();
        assertThrows(IllegalArgumentException.class, () -> {
            sp.splitStr("1,2,-3");
        });
    }
}