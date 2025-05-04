import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import stringCalc.CustomDelimiterAndBodyExtractor;
import stringCalc.DelimiterAndBodyInfo;

import java.util.stream.Stream;


import static org.assertj.core.api.Assertions.assertThat;

public class CustomDelimiterAndBodyExtractorTest {


    @ParameterizedTest
    @MethodSource("inputStringArguments")
    void givenMatchedPattern_whenExtract_thenGiveInputInfo(String input, String expected_body, String expected_del) {
        DelimiterAndBodyInfo actual = CustomDelimiterAndBodyExtractor.extract(input);
        assertThat(actual).extracting("customDelimiter", "body").containsExactly(expected_del, expected_body);
    }

    private static Stream<Arguments> inputStringArguments() {
        return Stream.of(
                Arguments.arguments("//;\n1;2;3", "1;2;3", ";"),
                Arguments.arguments("//#\n 1;2;3", " 1;2;3", "#"),
                Arguments.arguments("1,2,3", "1,2,3", ""),
                Arguments.arguments("", "", ""),
                Arguments.arguments(" ", " ", ""),
                Arguments.arguments("123", "123", "")
        );
        
    }

}
