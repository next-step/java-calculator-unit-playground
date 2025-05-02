package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import domain.operatorImpl.AddOperator;
import domain.operatorImpl.DivideOperator;
import domain.operatorImpl.MultiplyOperator;
import domain.operatorImpl.SubtractOperator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("문자열 계산기 테스트")
public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator(new Operator[]{
            AddOperator.INSTANCE,
            new SubtractOperator(),
            new MultiplyOperator(),
            new DivideOperator()
        });
    }

    @Test
    @DisplayName("문자열 입력 유효성 검증 테스트: 예외 케이스")
    void validateInvalidInputExpression() {
        assertAll(
            () -> assertThatThrownBy(() -> calculator.calculateStringExpression("1+"))
                .isInstanceOf(RuntimeException.class),
            () -> assertThatThrownBy(() -> calculator.calculateStringExpression("+"))
                .isInstanceOf(RuntimeException.class),
            () -> assertThatThrownBy(() -> calculator.calculateStringExpression("-2"))
                .isInstanceOf(RuntimeException.class),
            () -> assertThatThrownBy(() -> calculator.calculateStringExpression("/;\n1;2"))
                .isInstanceOf(RuntimeException.class),
            () -> assertThatThrownBy(() -> calculator.calculateStringExpression("//\n1.2"))
                .isInstanceOf(RuntimeException.class),
            () -> assertThatThrownBy(() -> calculator.calculateStringExpression(";\n1;2"))
                .isInstanceOf(RuntimeException.class),
            () -> assertThatThrownBy(() -> calculator.calculateStringExpression(";\n1.2"))
                .isInstanceOf(RuntimeException.class),
            () -> assertThatThrownBy(() -> calculator.calculateStringExpression("1.2"))
                .isInstanceOf(RuntimeException.class)
        );
    }

    @Test
    @DisplayName("문자열 입력 유효성 검증 테스트: 정상 케이스")
    void validateValidInputExpression() {
        assertAll(
            () -> assertThatCode(() -> calculator.calculateStringExpression("1+2"))
                .doesNotThrowAnyException(),
            () -> assertThatCode(() -> calculator.calculateStringExpression(""))
                .doesNotThrowAnyException()
        );
    }

    @Test
    @DisplayName("문자열 덧셈 테스트")
    void calculateAddTest() {
        assertAll(
            () -> assertThat(calculator.calculateStringExpression("1+4")).isEqualTo(5),
            () -> assertThat(calculator.calculateStringExpression("1,4")).isEqualTo(5),
            () -> assertThat(calculator.calculateStringExpression("1:4")).isEqualTo(5),
            () -> assertThat(calculator.calculateStringExpression("1,2:3")).isEqualTo(6),
            () -> assertThat(calculator.calculateStringExpression("1,2,3")).isEqualTo(6)
        );
    }

    @Test
    @DisplayName("문자열 뺄셈 테스트")
    void calculateSubtractTest() {
        assertThat(calculator.calculateStringExpression("1-4")).isEqualTo(-3);
    }

    @Test
    @DisplayName("문자열 곱셈 테스트")
    void calculateMultiplyTest() {
        assertAll(
            () -> assertThat(calculator.calculateStringExpression("1*4")).isEqualTo(4),
            () -> assertThat(calculator.calculateStringExpression("1*0")).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("문자열 나눗셈 테스트")
    void calculateDivideTest() {
        assertAll(
            () -> assertThat(calculator.calculateStringExpression("1/4")).isEqualTo(0),
            () -> assertThat(calculator.calculateStringExpression("4/2")).isEqualTo(2)
        );
    }

    @Test
    @DisplayName("문자열 나눗셈 테스트: 0으로 나누면 예외 발생")
    void divideByZeroException() {
        assertThatThrownBy(() -> calculator.calculateStringExpression("1/0"))
            .isInstanceOf(ArithmeticException.class);
    }

    @Test
    @DisplayName("커스텀 문자열 테스트")
    void calculateCustomSymbolTest() {
        assertAll(
            () -> assertThat(calculator.calculateStringExpression("")).isEqualTo(0),
            () -> assertThat(calculator.calculateStringExpression("//;\n1;4")).isEqualTo(5),
            () -> assertThat(calculator.calculateStringExpression("//;\n1;2;3")).isEqualTo(6)
        );
    }
}
