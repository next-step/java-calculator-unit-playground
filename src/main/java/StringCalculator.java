import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int addString(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:"; // 기본 구분자
        String numbers = input;

        // 커스텀 구분자
        if (input.startsWith("//")) {
            // 구분자와 숫자 부분 추출 (이스케이프 처리)
            Matcher matcher = Pattern.compile("//(.+?)\\\\n(.*)").matcher(input);
            if (matcher.matches()) {
                delimiter = Pattern.quote(matcher.group(1)); // 커스텀 구분자
                numbers = matcher.group(2); // 숫자 부분
            } else {
                throw new RuntimeException("커스텀 구분자가 올바르게 처리되지 않았습니다.");
            }
        }

        // 기본 구분자 또는 커스텀 구분자를 기준으로 분리
        String[] tokens = numbers.split(delimiter);
        int sum = 0;

        // 각 토큰을 숫자로 변환하여 합산
        for (String token : tokens) {
            int number = parseNumber(token);
            if (number < 0) {
                throw new RuntimeException("허용되지 않는 값(음수) : " + number);
            }
            sum += number;
        }
        return sum;
    }

    private int parseNumber(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new RuntimeException("허용되지 않는 값(숫자가 아님) : " + token);
        }
    }
}
