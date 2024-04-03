import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final Pattern CUSTOM_SEPARATOR_CHECKER = Pattern.compile("^//(.*)\\n.*$");
    private static final int CUSTOM_SEPARATOR_IDX = 2;
    private static final int CUSTOM_EXPRESSION_BEGIN_IDX = 4;
    private static final String BASIC_SEPARATOR_REGX = "[,:]";

    public int add(final String expression) {
        if (expression == null) {
            throw new IllegalArgumentException("표현식의 입력이 잘못됐습니다. [NULL 입력 예외]");
        }
        List<Integer> numbers = convertToNumbers(expression);
        validateNegativeValue(numbers);

        return numbers.stream()
                .mapToInt(Integer::valueOf)
                .sum();
    }

    private void validateNegativeValue(final List<Integer> numbers) {
        boolean hasNegativeValue = numbers.stream()
                .anyMatch(n -> n < 0);

        if (hasNegativeValue) {
            throw new IllegalArgumentException("표현식의 입력이 잘못됐습니다. [음수 입력 예외]");
        }
    }

    private List<Integer> convertToNumbers(final String expression) {
        if (isCustomExpression(expression)) {
            return splitCustom(expression).stream()
                    .map(this::parseInt)
                    .toList();
        }
        return splitBasic(expression).stream()
                .map(this::parseInt)
                .toList();
    }

    private boolean isCustomExpression(final String expression) {
        return CUSTOM_SEPARATOR_CHECKER.matcher(expression)
                .matches();
    }

    private List<String> splitCustom(final String customExpression) {
        String numberExpression = customExpression.substring(CUSTOM_EXPRESSION_BEGIN_IDX);

        return Arrays.stream(numberExpression.split(customExpression.substring(CUSTOM_SEPARATOR_IDX, CUSTOM_SEPARATOR_IDX + 1)))
                .toList();
    }

    private List<String> splitBasic(final String basicExpression) {
        return Arrays.stream(basicExpression.split(BASIC_SEPARATOR_REGX))
                .toList();
    }

    private int parseInt(final String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }

        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("표현식의 입력이 잘못됐습니다. [잘못된 표현식 포맷]");
        }
    }
}
