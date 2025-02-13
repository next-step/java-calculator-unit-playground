import java.util.regex.Pattern;

public class StringCalculator {

    // 기본 구분자
    private static final String DEFAULT_DELIMITER = "[,|:]";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String NEW_LINE = "\n";
    private static final int CUSTOM_DELIMITER_PREFIX_LENGTH = 2;

    public static int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String delimiter = DEFAULT_DELIMITER; // 기본 구분자 정의

        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) { // 커스텀 구분자 처리 (여러 글자 지원)
            int delimiterEnd = input.indexOf(NEW_LINE);
            String customDelimiter = input.substring(CUSTOM_DELIMITER_PREFIX_LENGTH, delimiterEnd);
            delimiter = DEFAULT_DELIMITER + "|" + Pattern.quote(customDelimiter);
            input = input.substring(delimiterEnd + 1);
        }

        Pattern pattern = Pattern.compile(delimiter);
        String[] numbers = pattern.split(input);
        return sum(numbers);
    }

    private static int sum(String[] numbers) { // 문자열을 숫자로 변환하여 합을 계산
        int sum = 0;

        for (String num : numbers) {
            int value = parseAndValidateNumber(num); // 숫자 변환 및 검증
            sum += value;
        }

        return sum;
    }

    private static int parseAndValidateNumber(String num) {
        int value;

        try {
            value = Integer.parseInt(num.trim());
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid input: 숫자가 아닌 값이 포함되었습니다.");
        }

        if (value < 0) {
            throw new RuntimeException("입력한 값 중 음수 값이 존재합니다: " + value);
        }

        return value;
    }
}
