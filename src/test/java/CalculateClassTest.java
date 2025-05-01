import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("계산기 테스트 ")
class CalculateClassTest {
    CalculateClass calculateClass = new CalculateClass();
    @Test
    void addTest(){
        assertEquals(5, calculateClass.add(2,3));
    }

    @Test
    void minTest(){
        assertEquals(3, calculateClass.min(9,6));
    }

    @Test
    void divTest(){
        assertEquals(8, calculateClass.div(24,3));
    }

    @Test
    void mulTest(){
        assertEquals(25, calculateClass.mul(5,5));
    }


}
