import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final char CUSTOM_DELIMITER_END = '\n';

    public int add(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        Parsed parsed = parseDelimiters(text);

        String[] words = parsed.numbersText().split(parsed.delimiters());
        return sum(words);
    }

    private Parsed parseDelimiters(String text) {
        if (!text.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            return new Parsed(DEFAULT_DELIMITERS, text);
        }

        int newlineIndex = text.indexOf(CUSTOM_DELIMITER_END);
        if (newlineIndex == -1) {
            throw new RuntimeException("\n이 없어 커스텀 구분자 형식이 올바르지 않습니다.");
        }

        String customDelimiter = text.substring(CUSTOM_DELIMITER_PREFIX.length(), newlineIndex);
        if (customDelimiter.isEmpty()) {
            throw new RuntimeException("커스텀 구분자가 비어있습니다.");
        }

        String delimiters = DEFAULT_DELIMITERS + "|" + Pattern.quote(customDelimiter);
        String numbersText = text.substring(newlineIndex + 1);

        return new Parsed(delimiters, numbersText);

    }
    private int sum(String[] words) {
        int sum = 0;
        for (String word : words) {
            int num = Integer.parseInt(word);

            if (num < 0) {
                throw new RuntimeException("음수는 허용되지 않습니다");
            }
            sum += num;
        }
        return sum;
    }

    private record Parsed(String delimiters, String numbersText) {
    }
}
