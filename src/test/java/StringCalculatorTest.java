import domain.StringCalculator;
import org.junit.jupiter.api.Test;

import java.rmi.NoSuchObjectException;
import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    void 쉼표_콜론_구분자_테스트() {
        final String string = "12,45:78";
        final StringCalculator stringCalculator = new StringCalculator(string);
        List<Integer> expected = Arrays.asList(12, 45, 78);

        List<String> splitStrings = stringCalculator.checkSplit();
        List<Integer> actual = stringCalculator.changeStrToInt(splitStrings);

        assertEquals(expected, actual);
    }

    @Test
    void 커스텀_구분자_테스트() {
        final String string = "//;\n15;78";
        final StringCalculator stringCalculator = new StringCalculator(string);
        List<Integer> expected = Arrays.asList(15, 78);

        List<String> splitStrings = stringCalculator.checkSplit();
        List<Integer> actual = stringCalculator.changeStrToInt(splitStrings);

        assertEquals(expected, actual);
    }

    @Test
    void 입력이_공백인_경우_예외를_발생시킨다() {
        final String string = "";
        final StringCalculator stringCalculator = new StringCalculator(string);
        String expected = "공백은 입력할 수 없습니다.";

        Exception exception = assertThrows(RuntimeException.class, stringCalculator::checkSplit);
        String actual = exception.getCause().getMessage();

        assertEquals(expected, actual);
    }

    @Test
    void 음수를_입력한_경우_예외를_발생시킨다() {
        final String string = "3,5,7,-5";
        final StringCalculator stringCalculator = new StringCalculator(string);
        String expected = "음수를 입력할 수 없습니다.";

        List<String> splitStrings = stringCalculator.checkSplit();
        List<Integer> actualNumbers = stringCalculator.changeStrToInt(splitStrings);
        Exception exception = assertThrows(RuntimeException.class, () ->
                stringCalculator.getSum(actualNumbers)
        );

        String actual = exception.getMessage();
        assertEquals(expected, actual);

    }

    @Test
    void 다른_문자를_입력한_경우_예외를_발생시킨다() {
        final String string = "3,5,7,num";
        final StringCalculator stringCalculator = new StringCalculator(string);
        String expected = "숫자를 입력해주세요.";

        List<String> splitStrings = stringCalculator.checkSplit();
        Exception exception = assertThrows(RuntimeException.class, () ->
                stringCalculator.changeStrToInt(splitStrings)
        );
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }
}