import java.util.StringTokenizer;

public class StringCalculate {

    private static final String DEFAULT_DELIMITERS = ",:";
    private static final String DELIMITER_PATTERN = "^//[^0-9]\\\\n.*";
    private static final int CUSTOM_DELIMITER_INDEX = 2;
    private static final int DELIMITED_STRING_START_INDEX = 5;

    public int sum(String input) {
        StringTokenizer tokenizer = new StringTokenizer(extractDelimitedString(input), extractDelimiters(input));
        int sum = 0;

        while (tokenizer.hasMoreTokens()) {
            try {
                int parseInt = Integer.parseInt(tokenizer.nextToken());
                if (parseInt < 0) {
                    throw new IllegalArgumentException("음수는 들어올 수 없습니다.");
                }
                sum += parseInt;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }

        return sum;
    }

    private String extractDelimiters(String input) {
        if (input.startsWith("/") && validateDelimiterPattern(input)) {
            return DEFAULT_DELIMITERS + input.charAt(CUSTOM_DELIMITER_INDEX);
        }

        return DEFAULT_DELIMITERS;
    }

    private String extractDelimitedString(String input) {
        if (input.startsWith("/") && validateDelimiterPattern(input)) {
            return input.substring(DELIMITED_STRING_START_INDEX);
        }

        return input;
    }

    private boolean validateDelimiterPattern(String input) {
        if (!input.matches(DELIMITER_PATTERN)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        return true;
    }
}
