import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    private static final String REGEX_NOT_NUMBER = "[\\D]*";
    private static final String REGEX_CAN_CUSTOM_DELIMITER = "^//.+\n.*";
    private List<String> delimiter = Arrays.asList(":", ",");

    private String strings;
    private String[] operands;

    public StringCalculator(final String expression) {
        updateDelimiter(expression);
        makeOperands();
        checkValidate();
    }

    private void updateDelimiter(final String expression) {
        if (canChangeNewDelimiter(expression)) {
            delimiter = List.of(expression.substring(2, expression.indexOf("\n")));
            strings = expression.substring(expression.indexOf("\n") + 1);
        } else {
            strings = expression; // 원래 if 문에 return으로 끝내고 else를 주는 편인데, 이 편이 좀 더 가독성이 좋아보여 else로 해봄
        }
    }

    private boolean canChangeNewDelimiter(String expression) {
        return expression.matches(REGEX_CAN_CUSTOM_DELIMITER);
    }

    private void makeOperands() {
        operands = strings.split(String.join("|", delimiter));
    }

    private void checkValidate() {
        try {
            if (Arrays.stream(operands).anyMatch(s -> s.matches(REGEX_NOT_NUMBER))) {
                throw new RuntimeException("문자열은 들어올 수 없습니다");
            }

            if (Arrays.stream(operands).anyMatch(s -> Integer.parseInt(s) < 0)) {
                throw new RuntimeException("음수는 들어올 수 없습니다");
            }

        } catch (NumberFormatException e) {
            throw new RuntimeException("유효하지 않은 포맷입니다");
        }
    }

    public int calculate() {

        if (operands.length == 0) {
            return 0;
        }

        return Arrays.stream(operands)
            .mapToInt(Integer::parseInt)
            .sum();
    }
}
