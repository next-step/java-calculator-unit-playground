import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalc {

    private static final String DEFAULT_DELIMITERS = "[,:]";

    public int add(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }

        DelimiterInfo delimiterInfo = parseDelimiterInfo(text);
        String[] numbersAsString = splitByDelimiter(delimiterInfo.textToParse, delimiterInfo.delimiter);
        
        return calculateSum(numbersAsString);
    }

    private boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private DelimiterInfo parseDelimiterInfo(String text) {
        Pattern customDelimiterPattern = Pattern.compile("//(.)\n(.*)");
        Matcher matcher = customDelimiterPattern.matcher(text);

        if (matcher.find()) {
            String customDelimiter = Pattern.quote(matcher.group(1));
            String actualTextToParse = matcher.group(2);
            // 커스텀 구분자와 기본 구분자를 모두 포함
            String combinedDelimiters = DEFAULT_DELIMITERS + "|" + customDelimiter;
            return new DelimiterInfo(combinedDelimiters, actualTextToParse);
        }

        return new DelimiterInfo(DEFAULT_DELIMITERS, text);
    }

    private String[] splitByDelimiter(String text, String delimiter) {
        return text.split(delimiter);
    }

    private int calculateSum(String[] numbersAsString) {
        int sum = 0;
        for (String numStr : numbersAsString) {
            if (numStr.isEmpty()) {
                continue;
            }
            sum += parseAndValidateNumber(numStr);
        }
        return sum;
    }

    private int parseAndValidateNumber(String numStr) {
        try {
            int number = Integer.parseInt(numStr);
            validateNumber(number);
            return number;
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자 이외의 값이 포함되어 있습니다.");
        }
    }

    private void validateNumber(int number) {
        if (number < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
    }

    private static class DelimiterInfo {
        final String delimiter;
        final String textToParse;

        DelimiterInfo(String delimiter, String textToParse) {
            this.delimiter = delimiter;
            this.textToParse = textToParse;
        }
    }
}