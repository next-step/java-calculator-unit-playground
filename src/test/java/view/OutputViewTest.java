package view;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    @Test
    void 입력값_테스트() {
        //given
        OutputView outputView = new OutputView();
        List<Integer> expectedValue = new ArrayList<>();
        expectedValue.add(1);
        expectedValue.add(2);
        expectedValue.add(3);
        //when
        List<Integer> actualValue = outputView.parseString("//;\n1;2;3");
        //then
        assertEquals(expectedValue, actualValue);
    }
}