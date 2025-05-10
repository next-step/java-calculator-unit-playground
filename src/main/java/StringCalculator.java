import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DELIMITER = "[,|:]";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.*?)\n(.*)");

    public int calculate(String input){
        String delimiter = DELIMITER;
        String rawNumbers = input;

        Matcher matcher = CUSTOM_PATTERN.matcher(input);

        if(matcher.find()){
            String customDelimiter = Pattern.quote(matcher.group(1));
            delimiter += '|' + customDelimiter;
            rawNumbers = matcher.group(2);
        }

        String[] numberArray = rawNumbers.split(delimiter);
        return addNumbers(numberArray);
    }

    private int addNumbers(String[] numberArray){
        return Arrays.stream(numberArray)
                .map(String::trim)
                .mapToInt(this::parseAndValidateNumber)
                .sum();
    }

    public int parseAndValidateNumber(String number){
        try {
            int num = Integer.parseInt(number);
            if (num < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num);
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + number);
        }
    }
}
