import java.util.Collections;

public final class StringCalculator {

  /**
   *
   * @param text 파싱할 문자열
   * @return 문자열로 덧셈 계산한 값
   */
  public static int parseAndSum(String text) {
    int[] parsedNumbers = parse(text);

    int sum = 0;
    for (final int parsedNumber : parsedNumbers) {
      sum += parsedNumber;
    }

    return sum;
  }

  /**
   * TODO: parse 메서드 구현
   * @param text 파싱할 문자열
   * @return 파싱결과로 생성된 숫자 배열
   */
  private static int[] parse(final String text) {
    return new int[]{1, 2, 3};
  }
}
