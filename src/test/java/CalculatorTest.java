import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("계산기 테스트")
public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Nested
    @DisplayName("덧셈 테스트")
    class AddTest{

        @Test
        @DisplayName("주어진 인자 2개를 더한 결과를 반환한다")
        void Test_AddTest() {

            // given
            int a = 3;
            int b = 2;

            // when
            int expected = calculator.add(a,b);

            // then
            int actual = 5;

            assertEquals(expected,actual);
        }
    }

    @Nested
    @DisplayName("뺄셈 테스트")
    class SubtractTest{

        @Test
        @DisplayName("주어진 인자 2개를 뺀 결과를 반환한다")
        void Test_SubtractTest() {

            // given
            int a = 3;
            int b = 2;

            // when
            int expected = calculator.subtract(a,b);

            // then
            int actual = 1;

            assertEquals(expected,actual);
        }
    }

    @Nested
    @DisplayName("곱셈 테스트")
    class MultiplyTest{

        @Test
        @DisplayName("주어진 인자 2개를 곱한 결과를 반환한다")
        void Test_MultiplyTest() {

            // given
            int a = 3;
            int b = 2;

            // when
            int expected = calculator.multiply(a,b);

            // then
            int actual = 6;

            assertEquals(expected,actual);
        }
    }


}
