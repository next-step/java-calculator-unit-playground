import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";

    private final Calculator calculator;

    public StringCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public int add(String input) {
        validateInput(input);
        String[] tokens = splitNumbers(input);

        List<Integer> numbers = parseNumbers(tokens);
        int sum = 0;
        for (int value : numbers) {
            sum = calculator.add(sum, value);
        }
        return sum;
    }

    private void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new RuntimeException("Input cannot be null or empty");
        }
    }

    private String[] splitNumbers(String input) {
        if (input.startsWith("//")) {
            // 커스텀 구분자: "//[커스텀 구분자]\n[숫자]"
            return splitWithCustomDelimiter(input);
        }
        return input.split(DEFAULT_DELIMITER_REGEX);
    }

    private String[] splitWithCustomDelimiter(String input) {
        String[] parts = input.split("\n", 2);
        if (parts.length < 2) {
            throw new RuntimeException("Invalid custom delimiter format");
        }
        String customDelimiter = parts[0].substring(2);
        return parts[1].split(customDelimiter);
    }

    private List<Integer> parseNumbers(String[] tokens) {
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            int value = parseNumber(token);
            numbers.add(value);
        }
        return numbers;
    }

    private int parseNumber(String token) {
        try {
            int value = Integer.parseInt(token);
            if (value < 0) {
                throw new RuntimeException("Cannot use Negative numbers: " + token);
            }
            return value;
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid input: " + token);
        }
    }
}
