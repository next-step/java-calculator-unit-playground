public class StringCalculator {

    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";

    private final Calculator calculator;

    public StringCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] numbers = splitNumbers(input);
        return sum(numbers);
    }

    private String[] splitNumbers(String input) {
        // 커스텀 구분자: "//[커스텀 구분자]\n[숫자]"
        if (input.startsWith("//")) {
            return splitWithCustomDelimiter(input);
        }
        return input.split(DEFAULT_DELIMITER_REGEX);
    }

    private String[] splitWithCustomDelimiter(String input) {
        String[] parts = input.split("\n", 2);
        if (parts.length < 2) {
            throw new RuntimeException("Cannot use Invalid custom delimiter format");
        }
        String customDelimiter = parts[0].substring(2);
        return parts[1].split(customDelimiter);
    }

    private int sum(String[] numbers) {
        int sum = 0;
        for (String num : numbers) {
            int value = parseNumber(num);
            sum = calculator.add(sum, value);
        }
        return sum;
    }

    private int parseNumber(String num) {
        try {
            int value = Integer.parseInt(num);
            if (value < 0) {
                throw new RuntimeException(String.format("Cannot use Negative numbers: %s", num));
            }
            return value;
        } catch (NumberFormatException e) {
            throw new RuntimeException(String.format("Cannot use Invalid input: %s", num));
        }
    }
}
