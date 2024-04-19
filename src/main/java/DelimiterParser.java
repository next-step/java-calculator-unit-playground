import java.util.Arrays;
import java.util.List;

public class DelimiterParser {

    private static final String REGEX_NOT_NUMBER = "\\D+";
    private static final String REGEX_CAN_CUSTOM_DELIMITER = "^//.+\n.*";

    private List<String> delimiter = Arrays.asList(":", ",");

    public String[] parse(final String expression) {
        final String updatedExpression = updateDelimiter(expression);

        String[] operands = updatedExpression.split(String.join("|", delimiter));

        checkValidate(operands);

        return operands;
    }

    private String updateDelimiter(final String expression) {
        if (canChangeNewDelimiter(expression)) {
            delimiter = List.of(expression.substring(2, expression.indexOf("\n")));
            return expression.substring(expression.indexOf("\n") + 1);
        }
        return expression;
    }

    private boolean canChangeNewDelimiter(String expression) {
        return expression.matches(REGEX_CAN_CUSTOM_DELIMITER);
    }

    private void checkValidate(String[] operands) {
        if (Arrays.stream(operands).anyMatch(s -> s.matches(REGEX_NOT_NUMBER))) {
            throw new RuntimeException("문자열은 들어올 수 없습니다");
        }

        if (Arrays.stream(operands).anyMatch(s -> Integer.parseInt(s) < 0)) {
            throw new RuntimeException("음수는 들어올 수 없습니다");
        }
    }
}
