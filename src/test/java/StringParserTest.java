import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import stringCalc.NonNegativeInteger;
import stringCalc.StringParser;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("string input이 주어질때 구분자로 파싱하여 ")
public class StringParserTest {

    @ParameterizedTest(name = "문자열 파싱 및 value 리스트 반환 테스트 - 커스텀 구분자 포함 ")
    @MethodSource("customDelimieterAndBodyInputArguments")
    void givenCustomDelAndBody_whenParse_thenReturnValueList(String customDel, String body, List<NonNegativeInteger> expected) {
        List<NonNegativeInteger> actual = StringParser.parseStringToNumValues(customDel, body);
        assertThat(actual).containsExactlyElementsOf(expected);
    }

    @ParameterizedTest(name = "문자열 파싱 및 value 리스트 반환 테스트 - 기본 구분자만 포함")
    @CsvSource({"'1,2,3'", "1:2:3", "'1:2,3'"})
    void givenBody_whenParse_thenReturnValueList(String body) {
        List<NonNegativeInteger> actual = StringParser.parseStringToNumValues("", body);
        List<NonNegativeInteger> expected = List.of(new NonNegativeInteger("1"), new NonNegativeInteger("2"), new NonNegativeInteger("3"));
        assertThat(actual).containsExactlyElementsOf(expected);
    }


    private static Stream<Arguments> customDelimieterAndBodyInputArguments() {
        return Stream.of(
                Arguments.of(";", "1;2;3", List.of(new NonNegativeInteger("1"), new NonNegativeInteger("2"), new NonNegativeInteger("3"))),
                Arguments.of(";", "1,2;3", List.of(new NonNegativeInteger("1"), new NonNegativeInteger("2"), new NonNegativeInteger("3"))),
                Arguments.of("[", "1[2[3", List.of(new NonNegativeInteger("1"), new NonNegativeInteger("2"), new NonNegativeInteger("3"))),
                Arguments.of("*", "1*2*3", List.of(new NonNegativeInteger("1"), new NonNegativeInteger("2"), new NonNegativeInteger("3")))
        );
    }

}
