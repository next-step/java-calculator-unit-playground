import java.util.Arrays;

public class Calculator {

  public int plus(int a, int b) {
    return a + b;
  }

  public int plus(String value){
    return Arrays.stream(ValueExtractor.extractValueByString(value)).mapToInt(Integer::parseInt).sum();
  }

  public int minus(int a, int b) {
    return a - b;
  }

  public int multiply(int a, int b) {
    return a * b;
  }

  public int divide(int a, int b) {
    return a / b;
  }

}
