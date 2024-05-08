package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    void standardStrings_parseStrings() {
        //given
        final String standardStrings = "1:2:3";
        final StringCalculator stringcalculator = new StringCalculator(standardStrings);
        final List<String> expected = new ArrayList<>(Arrays.asList("1","2","3"));

        //when
        final List<String> actual = stringcalculator.parseStrings();

        //then
        assertEquals(expected, actual);
    }

    @Test
    void customStrings_parseStrings() {
        //given
        final String customStrings = "//;\\n1;2;3";
        final StringCalculator stringcalculator = new StringCalculator(customStrings);
        final List<String> expected = new ArrayList<>(Arrays.asList("1","2","3"));

        //when
        final List<String> actual = stringcalculator.parseStrings();

        //then
        assertEquals(expected, actual);
    }

    @Test
    void standardStrings_changeStringsToNumbers() {
        //given
        final String standardStrings = "1:2:3";
        final StringCalculator stringcalculator = new StringCalculator(standardStrings);
        final List<String> splitStrings = stringcalculator.parseStrings();
        final List<Integer> expected = new ArrayList<>(Arrays.asList(1,2,3));

        //when
        final List<Integer> actual = stringcalculator.changeStringsToNumbers(splitStrings);

        //then
        assertEquals(expected, actual);
    }

    @Test
    void customStrings_changeStringsToNumbers() {
        //given
        final String standardStrings = "//;\\n1;2;3";
        final StringCalculator stringcalculator = new StringCalculator(standardStrings);
        final List<String> splitStrings = stringcalculator.parseStrings();
        final List<Integer> expected = new ArrayList<>(Arrays.asList(1,2,3));

        //when
        final List<Integer> actual = stringcalculator.changeStringsToNumbers(splitStrings);

        //then
        assertEquals(expected, actual);
    }

    @Test
    void IncorrectInputException_changeStringsToNumbers() {
        //given
        final String standardStrings = "//;\\nt;2;3";
        final StringCalculator stringcalculator = new StringCalculator(standardStrings);
        final List<String> splitStrings = stringcalculator.parseStrings();
        var expected = "제대로 입력하세요.";

        //when
        final RuntimeException actual = assertThrows(RuntimeException.class,()->stringcalculator.changeStringsToNumbers(splitStrings));

        //then
        assertEquals(expected,actual.getMessage());
    }

    @Test
    void minusInputException_changeStringsToNumbers() {
        //given
        final String standardStrings = "//;\\n-1;2;3";
        final StringCalculator stringcalculator = new StringCalculator(standardStrings);
        final List<String> splitStrings = stringcalculator.parseStrings();
        var expected = "음수 입력 불가.";

        //when
        final RuntimeException actual = assertThrows(RuntimeException.class,()->stringcalculator.changeStringsToNumbers(splitStrings));

        //then
        assertEquals(expected,actual.getMessage());
    }

    @Test
    void addNumbers() {
        //given
        final String standardStrings = "//;\\n1;2;3";
        final StringCalculator stringcalculator = new StringCalculator(standardStrings);
        final List<Integer> numberList = new ArrayList<>(Arrays.asList(1,2,3));
        final int expected = 6;

        //when
        final int actual = stringcalculator.addNumbers(numberList);

        //then
        assertEquals(expected, actual);
    }
}
