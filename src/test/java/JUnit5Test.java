import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("JUnit5 테스트")
public class JUnit5Test {

    @DisplayName("계산기 테스트")
    @Nested
    class CalculatorTest {
        //단위테스트
        @DisplayName("계산기 덧셈 테스트")
        @Test
        void addTest(){
            assertEquals(11, Calculator.add(6,5));
        }

        @DisplayName("계산기 뺄셈 테스트")
        @Test
        void subtractTest(){
            assertEquals(-1, Calculator.subtract(3,4));
        }

        @DisplayName("계산기 곱하기 테스트")
        @Test
        void multiplyTest(){
            assertEquals(12, Calculator.multiply(3,4));
        }

        @DisplayName("계산기 나누기 테스트")
        @Test
        void divideTest(){
            assertEquals(2, Calculator.divide(4,2));
        }
        @DisplayName("계산기 0 나누기 테스트")
        @Test
        void divide0Test(){
            assertThrows(ArithmeticException.class, () -> Calculator.divide(7,0));
        }


        @DisplayName("계산기 통합 테스트")
        @ParameterizedTest
        @MethodSource("methodSourceTestArguments")
        void totalTest(int a, int b, int sum, int sub, int mul, int div){

            assertAll(
                    () -> assertEquals(sum, Calculator.add(a,b)),
                    () -> assertEquals(sub, Calculator.subtract(a,b)),
                    () -> assertEquals(mul, Calculator.multiply(a,b)),
                    () -> assertEquals(div, Calculator.divide(a,b))
            );
        }

        private static Stream<Arguments> methodSourceTestArguments() {
            return Stream.of(
                    Arguments.arguments(1,2,3,-1,2,0),
                    Arguments.arguments(2,4,6,-2,8,0),
                    Arguments.arguments(753,1,754,752,753,753)
            );
        }
    }
}
