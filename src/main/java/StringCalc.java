import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalc {

    private static final String defaultDelimiters = "[,:]";

    public int add(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String delimiters = defaultDelimiters;
        String actualTextToParse = text;

        Pattern customDelimiterPattern = Pattern.compile("//(.)\n(.*)");
        Matcher matcher = customDelimiterPattern.matcher(text);

        if (matcher.find()) {
            String customDelimiter = Pattern.quote(matcher.group(1));
            delimiters = customDelimiter;
            actualTextToParse = matcher.group(2);
        }

        String[] numbersAsString = actualTextToParse.split(delimiters);
        int sum = 0;

        for (String numStr : numbersAsString) {
            if (numStr.isEmpty()) {
                continue;
            }

            try {
                int number = Integer.parseInt(numStr);

                if (number < 0) {
                    throw new RuntimeException("음수는 입력할 수 없습니다.");
                }
                sum += number;
            } catch (NumberFormatException e) {
                throw new RuntimeException("숫자 이외의 값이 포함되어 있습니다.");
            }
        }
        return sum;
    }
}