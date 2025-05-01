import java.util.Arrays;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String BASIC_DELIMITERS_REGEX = "[,:]";
    private static final String CUSTOM_START_STRING = "//";
    private static final String CUSTOM_END_STRING = "\n";

    public int run(String input) {
        String[] strings = splitByDelimiters(input);
        int[] numbers = parseToInts(strings);
        return sumNumbers(numbers);
    }

    public String[] splitByDelimiters(String input) {
        if (input.isEmpty()) {
            return new String[]{"0"};
        }
        if (hasCustomDelimiter(input)) {
            String customDelimiter = extractCustomDelimiter(input);
            String numericField = input.substring(input.indexOf(CUSTOM_END_STRING) + CUSTOM_END_STRING.length());
            return numericField.split(customDelimiter);
        }
        return input.split(BASIC_DELIMITERS_REGEX);
    }

    public boolean hasCustomDelimiter(String input) {
        return input.startsWith(CUSTOM_START_STRING) && input.contains(CUSTOM_END_STRING);
    }

    public String extractCustomDelimiter(String input) {
        String customDelimiter = input.substring(CUSTOM_START_STRING.length(), input.indexOf(CUSTOM_END_STRING));
        return Pattern.quote(customDelimiter);
    }

    public int[] parseToInts(String[] strings) {
        return Arrays.stream(strings)
                .mapToInt(this::parseToInt)
                .toArray();
    }

    public int parseToInt(String string) {
        if (string.isEmpty()) {
            return 0;
        }
        try {
            int number = Integer.parseInt(string);
            if (number < 0) {
                throw new RuntimeException();
            }
            return number;
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
    }

    public int sumNumbers(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
