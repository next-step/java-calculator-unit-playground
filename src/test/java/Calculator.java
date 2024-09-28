import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
  public int add(int num1, int num2) {
    return num1+num2;
  }

  public int sub(int num1, int num2) {
    return num1-num2;
  }
  public int divis(int num1, int num2) {
    return num1/num2;
  }
  public int multi(int num1, int num2) {
    return num1*num2;
  }

  /**
   * 문자열을 (,) 또는 (:) 이나 커스텀 구분자로 합연산을 수행
   * @throws RuntimeException 숫자 이외의 값 또는 음수 입력시 예외발생
   */
  public int stringToSum(String string) {

    String regex = "[:,]";
    Pattern pattern = Pattern.compile("//([^0-9\\\\n])\\\\n");
    Matcher matcher = pattern.matcher(string);

    if (matcher.find()) {
      regex = "[" + ":," + matcher.group(1) +"]";
      string = string.substring(5);
    }

    String[] strArr = string.split(regex);

    int[] arr = Arrays.stream(strArr).mapToInt(Integer::parseInt).toArray();
    return Arrays.stream(arr).sum();
  }
}
