import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private static final String default_delimiter = ",|:";
    private static final Pattern custum_delimiter = Pattern.compile("//(.)\\n(.*)");

    public static int sum(String input){
        if (input == null || input.isEmpty()) return 0;
        Matcher matcher = custum_delimiter.matcher(input);
        String delimiter = default_delimiter;
        if (matcher.find()) {
            delimiter = Pattern.quote(matcher.group(1));
            input = matcher.group(2);
        }

        String[] numbers = input.split("[" + delimiter + "]");
        int sum = 0;
        for (String num : numbers) {
            int number = parseNumber(num);
            if (number < 0) {
                throw new RuntimeException("음수가 입력되었습니다: " + num);
            }
            sum += number;
        }
        return sum;
    }

    private static int parseNumber(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new RuntimeException("유효하지 않은 숫자입니다.: " + str);
        }
    }
}
