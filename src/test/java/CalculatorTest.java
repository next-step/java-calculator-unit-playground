import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest_JUnit5 {

  Calculator calculator = new Calculator();
  final int result = 10;

  @Test
  @DisplayName("정수_합_연산을_실행한다")
  void 정수_합_연산을_실행한다() {
    int a = 4;
    int b = 6;

    assertEquals(calculator.sum(a, b), result);
  }

  @Test
  @DisplayName("실수_합_연산을_실행한다")
  void 실수_합_연산을_실행한다() {
    double a = 3.5;
    double b = 6.5;

    assertEquals(calculator.sum(a, b), result);
  }

  @Test
  @DisplayName("정수_차_연산을_실행한다")
  void 정수_차_연산을_실행한다() {
    int a = 15;
    int b = 5;

    assertEquals(calculator.sub(a, b), result);
  }

  @Test
  @DisplayName("실수_차_연산을_실행한다")
  void 실수_차_연산을_실행한다() {
    double a = 15.5;
    double b = 5.5;

    assertEquals(calculator.sub(a, b), result);
  }

  @Test
  @DisplayName("정수_곱_연산을_실행한다")
  void 정수_곱_연산을_실행한다() {
    int a = 2;
    int b = 5;

    assertEquals(calculator.mul(a, b), result);
  }

  @Test
  @DisplayName("실수_곱_연산을_실행한다")
  void 실수_곱_연산을_실행한다() {
    double a = 2.0;
    double b = 5.0;

    assertEquals(calculator.mul(a, b), result);
  }

  @Test
  @DisplayName("정수_몫_연산을_실행한다")
  void 정수_몫_연산을_실행한다() {
    int a = 50;
    int b = 5;

    assertEquals(calculator.div(a, b), result);
  }

  @Test
  @DisplayName("실수_몫_연산을_실행한다")
  void 실수_몫_연산을_실행한다() {
    double a = 60.0;
    double b = 6.0;

    assertEquals(calculator.div(a, b), result);
  }
}

class CalculatorTest_AssertJ {

  Calculator calculator = new Calculator();
  final int result = 10;

  //  JUnit5Test
  @Test
  @DisplayName("정수_합_연산을_실행한다")
  void 정수_합_연산을_실행한다() {
    int a = 4;
    int b = 6;

    assertThat(calculator.sum(a, b))
        .isEqualTo(result);
  }

  @Test
  @DisplayName("실수_합_연산을_실행한다")
  void 실수_합_연산을_실행한다() {
    double a = 3.5;
    double b = 6.5;

    assertThat(calculator.sum(a, b))
        .isEqualTo(result);
  }

  @Test
  @DisplayName("정수_차_연산을_실행한다")
  void 정수_차_연산을_실행한다() {
    int a = 15;
    int b = 5;

    assertThat(calculator.sub(a, b))
        .isEqualTo(result);
  }

  @Test
  @DisplayName("실수_차_연산을_실행한다")
  void 실수_차_연산을_실행한다() {
    double a = 15.5;
    double b = 5.5;

    assertThat(calculator.sub(a, b))
        .isEqualTo(result);
  }

  @Test
  @DisplayName("정수_곱_연산을_실행한다")
  void 정수_곱_연산을_실행한다() {
    int a = 2;
    int b = 5;

    assertThat(calculator.mul(a, b))
        .isEqualTo(result);
  }

  @Test
  @DisplayName("실수_곱_연산을_실행한다")
  void 실수_곱_연산을_실행한다() {
    double a = 2.0;
    double b = 5.0;

    assertThat(calculator.mul(a, b))
        .isEqualTo(result);
  }

  @Test
  @DisplayName("정수_몫_연산을_실행한다")
  void 정수_몫_연산을_실행한다() {
    int a = 50;
    int b = 5;

    assertThat(calculator.div(a, b))
        .isEqualTo(result);
  }

  @Test
  @DisplayName("실수_몫_연산을_실행한다")
  void 실수_몫_연산을_실행한다() {
    double a = 60.0;
    double b = 6.0;

    assertThat(calculator.div(a, b))
        .isEqualTo(result);
  }
}