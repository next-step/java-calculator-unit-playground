import java.util.Collections;

public final class StringCalculator {

  /**
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
   * @param text 파싱할 문자열
   * @return 파싱결과로 생성된 숫자 배열
   */
  private static int[] parse(String text) {

    if (text.startsWith("//")) {
      text = text.replace("//", "").replace("\n", "");
      char newToken = text.charAt(0);
      text = text.replace(newToken + "", ",");
    }
    text = text.replace(":", ",");

    String[] tokens = text.split(",");
    int[] tokensResult = new int[tokens.length];

    for (int i = 0; i < tokens.length; i++) {
      if (!tokens[i].isEmpty()) {
        tokensResult[i] = Integer.parseInt(tokens[i]);
        if (tokensResult[i] < 0) {
          throw new RuntimeException();
        }
      }
    }

    return tokensResult;
  }
}
