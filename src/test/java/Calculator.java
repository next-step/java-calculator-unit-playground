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

    // 문자열 해석
    if (matcher.find()) {
      regex = "[" + ":," + matcher.group(1) +"]";
      try {
        string = string.substring(5);
      }
      catch (Exception e) {
        throw new RuntimeException("올바르지 않은 문자열 입니다.");
      }
    }


    // 문자열 -> 정수배열로 변환
    String[] strArr = string.split(regex);
    int[] arr = Arrays.stream(strArr).mapToInt(Integer::parseInt).toArray();


    // 배열 합 계산
    int sum = 0;
    for (int i : arr) {

      // 음수 예외처리
      if (i < 0) throw new RuntimeException("음수가 포함되어 있습니다.");

      sum += i;
    }

    return sum;
  }
}
