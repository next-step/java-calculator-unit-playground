import java.util.Arrays;
import java.util.IllegalFormatException;

public class Calculator {

  public int plus(int a, int b) {
    return a + b;
  }

  public int plus(String value){
    return Arrays.stream(ValueExtractor.extractValueByString(value))
        .mapToInt(Integer::parseInt)
        .peek(v -> {
          if (Integer.signum(v) == -1)
            throw new NumberFormatException("음수는 유효한 숫자가 아닙니다.");
        }).sum();
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
