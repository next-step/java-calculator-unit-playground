package calculator;

import java.math.BigInteger;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    private static final String CUSTOM_DELIMITER_START = "//";
    private static final String CUSTOM_DELIMITER_NEWLINE = "\n";
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^-?[0-9]+$"); // 양의 정수 패턴
    private static final BigInteger MAX_LONG = BigInteger.valueOf(Long.MAX_VALUE); // Long 최대값

    public static long splitAndSum(String input) {
        if (input == null || input.isEmpty()) { // 순서가 바뀌면 null 값에 대해 Empty()를 시도하여 오류가 날 수 있음
            return 0;
        }
        return sum(split(input));
    }

    private static String[] split(String input) {
        if (input.startsWith(CUSTOM_DELIMITER_START)) { // 커스텀 구분자가 있는 경우
            int newlineIndex = input.indexOf(CUSTOM_DELIMITER_NEWLINE);

            if (newlineIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자 선언 후 개행 문자가 누락되었습니다.");
            }

            String delimiter = input.substring(2, newlineIndex);
            String target = input.substring(newlineIndex+1);

            return target.split(Pattern.quote(delimiter)); // 정규식표현으로 해석하는 것을 방지
        }
        return input.split(DEFAULT_DELIMITER_REGEX); // 커스텀 구분자가 없는 경우
    }

    private static long sum(String[] values) {
        long total = 0;
        for (String value : values) {
            try {
                total = Math.addExact(total, parseAndValidate(value)); // 오버플로우 체크
            } catch (ArithmeticException e) {
                throw new RuntimeException("전체 합계가 정수(Long) 범위를 초과하여 계산할 수 없습니다.", e);
            }
        }
        return total;
    }

    private static long parseAndValidate(String value) {

        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("구분자 사이에 숫자가 누락되었거나 공백입니다.");
        }

        if (!NUMBER_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("숫자 이외의 값은 입력할 수 없습니다.");
        }

        BigInteger bigInt = new BigInteger(value);

        if (bigInt.signum() == -1) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }

        if (bigInt.compareTo(MAX_LONG) > 0) {
            throw new IllegalArgumentException("입력값이 정수(Long) 범위를 초과했습니다: ");
        }

        return bigInt.longValue();
    }
}