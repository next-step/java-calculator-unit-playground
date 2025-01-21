import java.util.StringTokenizer;

public class StringCalculate {

    private static final String DEFAULT_DELIMITERS = ",:";
    private static final String DELIMITER_PATTERN = "^//[^0-9]\\\\n.*";
    private static final String NUMBER_PATTERN = "^[0-9]+$";
    private static final int CUSTOM_DELIMITER_INDEX = 2;
    private static final int DELIMITED_STRING_START_INDEX = 5;

    public int sum(String input) {
        StringTokenizer tokenizer = new StringTokenizer(extractDelimitedString(input), extractDelimiters(input));
        int sum = 0;

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            int parseNumber = getParseNumber(token);
            sum += parseNumber;
        }

        return sum;
    }

    private int getParseNumber(String token) {
        validateNumber(token);
        int parseInt = Integer.parseInt(token);
        validateNonNegativeNumber(parseInt);

        return parseInt;
    }

    private void validateNonNegativeNumber(int parseInt) {
        if (parseInt < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }

    private void validateNumber(String token) {
        if (!token.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException("숫자를 입력 해야합니다.");
        }
    }

    private String extractDelimiters(String input) {
        if (validateDelimiterString(input)) {
            return DEFAULT_DELIMITERS + input.charAt(CUSTOM_DELIMITER_INDEX);
        }

        return DEFAULT_DELIMITERS;
    }

    private String extractDelimitedString(String input) {
        if (validateDelimiterString(input)) {
            return input.substring(DELIMITED_STRING_START_INDEX);
        }

        return input;
    }

    private boolean validateDelimiterString(String input) {
        return input.startsWith("/") && validateDelimiterPattern(input);
    }

    private boolean validateDelimiterPattern(String input) {
        if (!input.matches(DELIMITER_PATTERN)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        return true;
    }
}
