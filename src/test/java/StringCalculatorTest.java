import domain.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.rmi.NoSuchObjectException;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {


    @Test
    void 쉼표_콜론_구분자_테스트(){
        final String string="12,45:78";
        final Calculator calculator=new Calculator();
        final int[] expected={12,45,78};

        calculator.StringCalculator(string);
        final int[] actual= calculator.getNumArr();

        assertArrayEquals(expected,actual);
    }

    @Test
    void 커스텀_구분자_테스트(){
        final String string="//!|n15!78";
        final Calculator calculator=new Calculator();
        final int[] expected={15,78};

        calculator.StringCalculator(string);
        final int[] actual= calculator.getNumArr();

        assertArrayEquals(expected,actual);

    }

    @Test
    void 입력이_공백인_경우_테스트(){
        final String string="";
        final Calculator calculator=new Calculator();

        assertThrows(RuntimeException.class, ()->{
            calculator.StringCalculator(string);
        });
    }


    @Test
    void 음수를_입력한_경우(){
        final String string="3,5,7,-5";
        final Calculator calculator=new Calculator();

        assertThrows(RuntimeException.class, ()->{
            calculator.StringCalculator(string);
        });
    }

    @Test
    void 다른_문자를_입력한_경우(){
        final String string="3,5,7,num";
        final Calculator calculator=new Calculator();

        assertThrows(RuntimeException.class, ()->{
            calculator.StringCalculator(string);
        });


    }





}
