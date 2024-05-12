package domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class SplitExceptionCalTest {

    @Test
    void 숫자가_넘어오면_나눠준다() {
        // given
        String input = "//;\n1;2;3";
        SplitExceptionCal splitExceptionCal = new SplitExceptionCal();
        // when
        List<String> result = splitExceptionCal.getParsedInput(input);
        List<String> expected = Arrays.asList("1", "2", "3");
        // then
        assertEquals(expected, result);
    }

    @Test
    void 쉼표_경우에도_나눠준다() {
        // given
        String input = "//,\n1,2,3";
        SplitExceptionCal splitExceptionCal = new SplitExceptionCal();
        // when
        List<String> result = splitExceptionCal.getParsedInput(input);
        List<String> expected = Arrays.asList("1", "2", "3");
        // then
        assertEquals(expected, result);
    }

    @Test
    void 골뱅이_경우에도_나눠준다() {
        // given
        String input = "//@\n1@2@3";
        SplitExceptionCal splitExceptionCal = new SplitExceptionCal();
        // when
        List<String> result = splitExceptionCal.getParsedInput(input);
        List<String> expected = Arrays.asList("1", "2", "3");
        // then
        assertEquals(expected, result);
    }

    @Test
    void 음수가_넘어오면_예외를_발생시킨다() {
        // given
        String input = "//@\n1@2@-3";
        SplitExceptionCal splitExceptionCal = new SplitExceptionCal();
        // when
        List<String> values = splitExceptionCal.getParsedInput(input);
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            splitExceptionCal.getParseException(values);
        });
        // then
        assertNotNull(exception);
    }

    @Test
    void 숫자가_아니라면_예외가_발생한다() {
        // given
        String input = "//@\n1@b@a";
        SplitExceptionCal splitExceptionCal = new SplitExceptionCal();
        // when
        List<String> values = splitExceptionCal.getParsedInput(input);
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            splitExceptionCal.getParseException(values);
        });
        // then
        assertNotNull(exception);
    }

}