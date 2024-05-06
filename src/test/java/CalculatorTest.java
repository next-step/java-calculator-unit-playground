import domain.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CalculatorTest {

    Calculator calculator=new Calculator();


    @Nested
    class calculationTest{

        final int a=8;
        final int b=4;
        @Test
        void 더하기_테스트(){
            assertEquals(calculator.add(a,b),a+b);
        }

        @Test
        void 빼기_테스트(){
            assertEquals(calculator.subtract(a,b),a-b);
        }

        @Test
        void 곱하기_테스트(){
            assertEquals(calculator.multiply(a,b),a*b);
        }

        @Test
        void 나누기_테스트(){
            assertEquals(calculator.divide(a,b),a/b);
        }


    }

    void 공백_입력_확인_테스트(){

    }








}
