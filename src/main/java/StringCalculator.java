import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String[] DEFAULT_DELIMITERS = {",", ":"};
    private static final String SEPARATOR_DELIMITER = String.join("|", DEFAULT_DELIMITERS);
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final int CUSTOM_DELIMITER_GROUP = 1;
    private static final int NUMBERS_GROUP = 2;

    private final Calculator calculator;

    public StringCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public int add(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }

        String[] numbers = extractNumbers(input);

        return calculateSum(numbers);
    }

    private boolean isNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            return true;
        }
        return false;
    }

    private String[] extractNumbers(String input) {
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            return extractWithCustomDelimiter(input);
        }
        return input.split(SEPARATOR_DELIMITER);
    }

    private String[] extractWithCustomDelimiter(String input) {

        // 정규식 패턴: "//[구분자]\n숫자들"
        Pattern pattern = Pattern.compile("^//(.+)\n(.+)$");
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            throw new RuntimeException("커스텀 구분자 형식이 잘못되었습니다.");
        }

        String customDelimiter = matcher.group(CUSTOM_DELIMITER_GROUP).trim();
        String numbers = matcher.group(NUMBERS_GROUP);

        // 괄호, 대괄호, 중괄호 같은 특수문자 제거
        customDelimiter = customDelimiter.replaceAll("[\\[\\{\\(\\)\\]\\}]", "").replace(" ", "");

        Pattern splitPattern = Pattern.compile(Pattern.quote(customDelimiter));

        return splitPattern.split(numbers);
    }


    private int calculateSum(String[] numbers) {
        int sum = 0;

        for (String number : numbers) {
            int num = validateAndParseInteger(number);
            if (num < 0) {
                throw new RuntimeException("음수가 전달되었습니다.");
            }
            sum = calculator.add(sum, num);
        }
        return sum;
    }

    private int validateAndParseInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자 이외의 다른 값이 전달되었습니다.");
        }
    }
}
