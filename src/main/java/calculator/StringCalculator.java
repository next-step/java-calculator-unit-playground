package calculator;

import java.util.regex.Pattern;

public class StringCalculator {

    int add(String input) {

        if (input == null || input.isBlank()) { // Null 값을 공백으로 가정, 공백이면 0 반환
            return 0;
        }

        String numbers = input;
        String regex = "[:,]";

        if (input.startsWith("//")) {
            int enterIndex = input.indexOf("\n");

            if (enterIndex == -1) {
                throw new RuntimeException("커스텀 구분자 입력 형식이 올바르지 않습니다.");
            }
            // 2 ~ enterIndex 사이에 있는 문자를 구분자로 설정
            String customRegex = input.substring(2, enterIndex);

            if (customRegex == null || customRegex.isBlank()) {
                throw new RuntimeException("커스텀 구분자 입력 형식이 올바르지 않습니다.");
            }

            regex = Pattern.quote(customRegex); // 정규식 특수문자일 경우도 포함
            numbers = input.substring(enterIndex + 1); // 헤더 부분을 제외한 나머지 문자열들로 교체
        }

        String[] tokens = numbers.split(regex);

        int result = 0;

        for (String token : tokens) {
            int value;
            try {
                value = Integer.parseInt(token);
            } catch (NumberFormatException e) {
                throw new RuntimeException("숫자가 아닌 값이 포함되어 있습니다.");
            }
            if (value < 0) {
                throw new RuntimeException("음수가 포함되어 있습니다.");
            }
            result += value;
        }

        return result;
    }
}
