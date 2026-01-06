package calculator;

import java.util.regex.Pattern;

public class StringCalculator {

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) { // 순서가 바뀌면 null 값에 대해 Empty()를 시도하여 오류가 날 수 있음
            return 0;
        }
        return sum(split(input));
    }

    private static String[] split(String input) {
        if (input.startsWith("//")) { // 커스텀 구분자가 있는 경우
            int newlineIndex = input.indexOf("\n"); // 커스텀 구분자의 끝 위치를 할당
            String delimiter = input.substring(2, newlineIndex); // 구분자를 delimiter 변수에 담음
            String target = input.substring(newlineIndex+1); // 계산할 대상들을 담음

            return target.split(Pattern.quote(delimiter)); // 정규식표현으로 해석하는 것을 방지
        }
        return input.split("[,:]"); // 커스텀 구분자가 없는 경우
    }

    private static int sum(String[] values) {
        int total = 0;
        for (String value : values) {
            total += parseAndValidate(value); // 구분된 토큰 단위로 유효성 검사
        }
        return total;
    }

    private static int parseAndValidate(String value) {

        if (value == null || value.isBlank()) {
            throw new RuntimeException("구분자 사이에 숫자가 누락되었거나 공백입니다.");
        }

        try {
            int number = Integer.parseInt(value); // 숫자라면 변환, 아니라면 포매팅 에러
            validateNonNegative(number); // 음수가 아닌지 확인
            return number;
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닙니다.", e);
        }
    }

    private static void validateNonNegative(int number) {
        if (number < 0) {
            throw new RuntimeException("음수가 입력되었습니다.");
        }
    }
}