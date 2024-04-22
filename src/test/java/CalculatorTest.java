import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("계산기 JUnit5 테스트")
public class CalculatorTest {
    @DisplayName("계산기 덧셈 테스트")
    @Test
    public void addTest() {
        assertThat(Calculator.add("6","5")).isEqualTo(11);
        assertThatThrownBy(() -> {
            Calculator.add("text","4");
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            Calculator.add(Integer.toString(Integer.MAX_VALUE),"4");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("계산기 뺄셈 테스트")
    @Test
    public void subtractTest() {
        assertThat(Calculator.subtract("3","4")).isEqualTo(-1);
        assertThatThrownBy(() -> {
            Calculator.subtract(Integer.toString(Integer.MAX_VALUE),"-4");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("계산기 곱하기 테스트")
    @Test
    public void multiplyTest() {
        assertThat(Calculator.multiply("3","4")).isEqualTo(12);
    }

    @DisplayName("계산기 나누기 테스트")
    @Test
    public void divideTest() {
        assertThat(Calculator.divide("4","2")).isEqualTo(2);
        assertThatThrownBy(() -> {
            Calculator.divide("7","0");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("계산기 Input 예외처리 테스트")
    @Test
    void formatterExceptionTest() {
        assertThatThrownBy(() -> {
            Calculator.stringToDouble("이것은 한글");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("계산기 Input 변환 테스트")
    @ParameterizedTest
    @MethodSource("methodSourceTestArguments")
    public void formatterTest(double expected, String value) {
        assertThat(Calculator.stringToDouble(value)).isEqualTo(expected);
    }

    private static Stream<Arguments> methodSourceTestArguments() {
        return Stream.of(
                Arguments.arguments(1, "1"),
                Arguments.arguments(2.2, "2.2"),
                Arguments.arguments(753, "753")
        );
    }
}