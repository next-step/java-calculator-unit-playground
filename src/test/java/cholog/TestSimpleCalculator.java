package cholog;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestSimpleCalculator {

  private static SimpleCalculator calculator;

  @BeforeAll
  static void setUp() {
    calculator = new SimpleCalculator();
  }

  @Test
  @DisplayName("add 정상 동작 확인")
  void add(){
    //given
    int a = 10, b = 5;

    //when
    int result = calculator.add(a, b);
    int expect = 15;

    //then
    assertThat(result).isEqualTo(expect);
  }
  @Test
  @DisplayName("subtract 정상 동작 확인")
  void subtract(){
    //given
    int a = 10, b = 5;

    //when
    int result = calculator.subtract(a, b);
    int expect = 5;

    //then
    assertThat(result).isEqualTo(expect);
  }
  @Test
  @DisplayName("multiply 정상 동작 확인")
  void multiply(){
    //given
    int a = 10, b = 5;

    //when
    int result = calculator.multiply(a, b);
    int expect = 50;

    //then
    assertThat(result).isEqualTo(expect);
  }
  @Test
  @DisplayName("divide 정상 동작 확인")
  void divide(){
    //given
    int a = 10, b = 5;

    //when
    int result = calculator.divide(a, b);
    int expect = 2;

    //then
    assertThat(result).isEqualTo(expect);
  }
  @Test
  @DisplayName("divide by zero 에러 발생 확인")
  void divideByZero(){
    //given
    int a = 10, b = 0;

    //when

    //then
    assertThatThrownBy(() -> calculator.divide(a, b)).isInstanceOf(ArithmeticException.class);
  }

}