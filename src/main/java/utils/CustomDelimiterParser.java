package utils;

public class CustomDelimiterParser {

    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\n";
    private static final int CUSTOM_DELIMITER_PREFIX_LENGTH = CUSTOM_DELIMITER_PREFIX.length();
    private static final String ERROR_INVALID_CUSTOM_DELIMITER_FORMAT = "[ERROR] 커스텀 구분자 형식이 잘못되었습니다.";

    public boolean hasCustomDelimiter(String expression) {
        return expression.startsWith(CUSTOM_DELIMITER_PREFIX);
    }

    public String parseCustomDelimiter(String expression) {
        validate(expression);
        int delimiterEndIndex = expression.indexOf(CUSTOM_DELIMITER_SUFFIX);
        return expression.substring(CUSTOM_DELIMITER_PREFIX_LENGTH, delimiterEndIndex);
    }

    public String parseNumbersExpression(String expression) {
        int delimiterEndIndex = expression.indexOf(CUSTOM_DELIMITER_SUFFIX);
        return expression.substring(delimiterEndIndex + 1);
    }

    private void validate(String expression) {
        if (!expression.contains(CUSTOM_DELIMITER_SUFFIX)) {
            throw new IllegalArgumentException(ERROR_INVALID_CUSTOM_DELIMITER_FORMAT);
        }
    }
}
