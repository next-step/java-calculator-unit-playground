package calculator;

import java.util.List;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest_AJ{

    @DisplayName("인자 두 개를 받아서 더한 값을 반환한다.")
    @Test
    void testAdd(){
        Calculator calculator = new Calculator();

        int result = calculator.add(1, 2);

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("인자 두 개를 받아서 뺀 값을 반환한다.")
    @Test
    void testSubtract(){
        Calculator calculator = new Calculator();

        int result = calculator.subtract(3, 2);

        assertThat(result).isEqualTo(1);
    }

    @DisplayName("인자 두 개를 받아서 곱한 값을 반환한다.")
    @Test
    void testMultiply(){
        Calculator calculator = new Calculator();

        int result = calculator.multiply(3, 2);

        assertThat(result).isEqualTo(6);
    }

    @DisplayName("인자 두 개를 받아서 나눈 값을 반환한다.")
    @Test
    void testDivide(){
        Calculator calculator = new Calculator();

        int result = calculator.divide(4, 2);

        assertThat(result).isEqualTo(2);
    }

}