import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AssertJTest {
    public void NonDelimiterTest(){
        StringCalculrator calcul = new StringCalculrator();

        assertThat(calcul.strPlus("1,2,3")).isEqualTo(6);
        assertThat(calcul.strPlus("1:2,3")).isEqualTo(6);
        assertThat(calcul.strPlus("1,2:3")).isEqualTo(6);
        assertThat(calcul.strPlus("1,:2::3")).isEqualTo(6);
        assertThat(calcul.strPlus("1,,,,2:3")).isEqualTo(6);
        assertThat(calcul.strPlus("1")).isEqualTo(1);

        assertThat(calcul.strPlus("10,20,30")).isEqualTo(60);
        assertThat(calcul.strPlus("10:20:30")).isEqualTo(60);
        assertThat(calcul.strPlus("10,20:30")).isEqualTo(60);
        assertThat(calcul.strPlus("10,:20::30")).isEqualTo(60);
        assertThat(calcul.strPlus("10,,,,20:30")).isEqualTo(60);
        
        assertThat(calcul.strPlus("")).isEqualTo(0);
    }

    @Test
    public void ExistDelimiterTest(){
        StringCalculrator calcul = new StringCalculrator();

        assertThat(calcul.strPlus("//;\n1;2;3")).isEqualTo(6);
        assertThat(calcul.strPlus("//;\n")).isEqualTo(0);
        
        assertThat(calcul.strPlus("//\t\n1\t2\t3")).isEqualTo(6);
        assertThat(calcul.strPlus("//!!\n1!!2!!3")).isEqualTo(6);
        assertThat(calcul.strPlus("//\n\n1\n2\n3")).isEqualTo(6);
        assertThat(calcul.strPlus("//1\n213")).isEqualTo(6);

        assertThat(calcul.strPlus("//;\n10;20;30")).isEqualTo(60);
        assertThat(calcul.strPlus("//\t\n10\t20\t30")).isEqualTo(60);
    }

    @Test
    public void ExceptionTest(){
        StringCalculrator calcul = new StringCalculrator();

        assertThatThrownBy(()->calcul.strPlus("1!2!3")).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(()->calcul.strPlus("1 2 3")).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(()->calcul.strPlus("1000000000000,2000000000000")).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(()->calcul.strPlus("1000000000,1000000000,1000000000")).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(()->calcul.strPlus("1000000000,2000000000,3000000000")).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(()->calcul.strPlus("!!,@@")).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(()->calcul.strPlus("-1,-2")).isInstanceOf(RuntimeException.class);
    }

}
