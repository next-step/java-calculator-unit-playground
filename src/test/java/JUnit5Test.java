import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("JUnit5 테스트")
public class JUnit5Test {

    @DisplayName("계산기 테스트")
    @Nested
    class CalculatorTest {

        @DisplayName("계산기 통합 테스트")
        @ParameterizedTest
        @MethodSource("methodSourceTestArguments")
        void totalTest(int a, int b){
            assertAll(
                    () -> assertEquals(a+b, Calculator.add(a,b)),
                    () -> assertEquals(a-b, Calculator.subtract(a,b)),
                    () -> assertEquals(a*b, Calculator.multiply(a,b)),
                    () -> assertEquals(a/b, Calculator.divide(a,b))
            );
        }

        private static Stream<Arguments> methodSourceTestArguments() {
            return Stream.of(
                    Arguments.arguments(1,2),
                    Arguments.arguments(2,4),
                    Arguments.arguments(6,3),
                    Arguments.arguments(65,24),
                    Arguments.arguments(23,56),
                    Arguments.arguments(753,345),
                    Arguments.arguments(753,1)
            );
        }
    }
}
