/*
- [ ] 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
  - [ ] 쉼표(,) 또는 콜론 (:)을 구분자로 가지는 문자열을 전달한다.
  - [ ] 커스텀 구분자를 지정할 수 있다. 문자열 앞 부분의 // 와 \n 사이의 문자를 사용
  - [ ] 구분자는 혼합하여 사용할 수 있다. ex) "1,2:3” => 6
- [ ] 예외 처리
  - [ ] 숫자 이외의 값을 전달하는 경우 RuntimeException 예외를 던진다.
  - [ ] 음수를 전달하는 경우 RuntimeException 예외를 던진다.
 */


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import stringCalc.StringCalculator;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("문자열 계산기 unit 테스트")
public class StringCalculatorTest {
    @Nested
    @DisplayName("기본 구분자 처리 테스트")
    class BasicDelimiterTest{
        @DisplayName("빈 문자열은 0을 반환한다.")
        void emptyStringInputTest(){
            int actual = StringCalculator.add("");
            assertEquals(0,actual);
        }

        @DisplayName("숫자 하나만 있을 경우, 그 숫자를 반환한다.")
        void oneSizeStringInputTest(){
            int actual = StringCalculator.add("1");
            assertEquals(1,actual);
        }

        @ParameterizedTest
        @MethodSource("basicDelimeterStringInputArguments")
        @DisplayName("쉼표와 콜론으로 구분된 숫자들의 합을 반환한다.")
        void basicDelimeterStringInputTest(String value, int expected){
            int actual = StringCalculator.add(value);
            assertEquals(expected,actual);
        }

        @DisplayName("")
        private static Stream<Arguments> basicDelimeterStringInputArguments(){
            return Stream.of(
                    Arguments.arguments("1:2",3),
                    Arguments.arguments("1,2",3),
                    Arguments.arguments("1,2:3",6)
            );
        }


    }
    @Nested
    @DisplayName("커스텀 구분자 처리 테스트")
    class CustomDelimiterTest{

    }

    @Nested
    @DisplayName("커스텀 구분자 처리 테스트")
    class ExceptionThrowingTest{

    }

}
