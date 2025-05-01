import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import stringCalc.CustomDelimiterAndBodyExtractor;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomDelimiterAndBodyExtractorTest {


    @ParameterizedTest
    @MethodSource("inputStringArguments")
    void givenMatchedPattern_whenExtract_thenGiveInputInfo(String input,String expected_body, String expected_del){
        CustomDelimiterAndBodyExtractor.DelimeterAndBodyInfo actual  = CustomDelimiterAndBodyExtractor.extract(input);
        assertAll(
                () -> assertEquals(expected_body,actual.getBody()),
                () -> assertEquals(expected_del,actual.getDelimiter())
        );
    }

    private static Stream<Arguments> inputStringArguments(){
        return Stream.of(
          Arguments.arguments("//;\n1;2;3","1;2;3", ";" ),
                Arguments.arguments("//#\n 1;2;3", " 1;2;3" , "#"),
                Arguments.arguments("1,2,3","1,2,3" , ""),
                Arguments.arguments("","",""),
                Arguments.arguments(" "," ",""),
                Arguments.arguments("123","123","")
        );
    }

}
