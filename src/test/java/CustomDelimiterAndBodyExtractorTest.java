import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import stringCalc.CustomDelimiterAndBodyExtractor;
import stringCalc.ExtractedDelimiterAndBody;

import java.util.stream.Stream;


import static org.assertj.core.api.Assertions.assertThat;

public class CustomDelimiterAndBodyExtractorTest {


    @ParameterizedTest
    @MethodSource("inputStringArguments")
    void givenMatchedPattern_whenExtract_thenGiveInputInfo(String input, ExtractedDelimiterAndBody extractedDelimiterAndBody) {
        ExtractedDelimiterAndBody actual = CustomDelimiterAndBodyExtractor.extract(input);
        assertThat(actual).extracting("customDelimiter", "body")
                .containsExactly(extractedDelimiterAndBody.getDelimiter(), extractedDelimiterAndBody.getBody());
    }

    private static Stream<Arguments> inputStringArguments() {
        return Stream.of(
                Arguments.arguments("//;\n1;2;3", new ExtractedDelimiterAndBody(";", "1;2;3")),
                Arguments.arguments("//#\n 1;2;3", new ExtractedDelimiterAndBody("#", " 1;2;3")),
                Arguments.arguments("1,2,3", new ExtractedDelimiterAndBody("", "1,2,3")),
                Arguments.arguments("", new ExtractedDelimiterAndBody("", "")),
                Arguments.arguments(" ", new ExtractedDelimiterAndBody("", " ")),
                Arguments.arguments("123", new ExtractedDelimiterAndBody("", "123"))
        );
    }

}
