public class StringCalculator {

    private static final String SEPARATOR_DELIMITER = ",|:";

    private final Calculator calculator;

    public StringCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public int add(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }

        String[] numbers = tokenize(input);

        return calculateSum(numbers);
    }

    private boolean isNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            return true;
        }
        return false;
    }

    private String[] tokenize(String input) {
        if (input.startsWith("//")) {
            return tokenizeWithCustomDelimiter(input);
        }
        return input.split(SEPARATOR_DELIMITER);
    }

    private String[] tokenizeWithCustomDelimiter(String input) {
        int newlineIndex = input.indexOf("\n");

        String customDelimiter = input.substring(2, newlineIndex);
        String numbers = input.substring(newlineIndex + 1);

        return numbers.split(customDelimiter);
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

