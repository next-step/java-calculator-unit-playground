package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import model.StringCalculator;

public class StringCalculatorService {

    private final StringCalculator stringCalculator = new StringCalculator();

    private final List<String> separators = new ArrayList<>(Arrays.asList(",", ":"));
    private final Pattern PATTERN_OF_NEED_TO_ADD_CUSTOM_SEPARATOR = Pattern.compile("^//(.*)\\n.*$");
    private final String SEPARATOR_PREFIX = "[";
    private final String SEPARATOR_SUFFIX = "]";
    private final String SEPARATOR_DELIMITER = "|";


    public int calculate(String expression) {
        stringCalculator.resetResult();
        List<String> tokens = getTokens(expression);
        return plusAllTokens(tokens);
    }

    public List<String> getTokens(String expression) {
        if (isNeedToAddCustomSeparator(expression)) {
            expression = addCustomSeparatorAndGetExpression(expression);
        }
        String separateRegex = getSeparateRegex();
        return Arrays.asList(expression.split(separateRegex));
    }

    private String addCustomSeparatorAndGetExpression(String expression) {
        addCustomSeparator(expression);
        return getExpression(expression);
    }

    private void addCustomSeparator(String expression) {
        String customSeparator = getCustomSeparator(expression);
        if (isNeedEscapeString(customSeparator)) {
            customSeparator = "\\" + customSeparator;
        }
        separators.add(customSeparator);
    }

    public String getCustomSeparator(String expression) {
        return expression.substring(2, expression.indexOf("\n"));
    }

    private String getExpression(String expression) {
        return expression.substring(expression.indexOf("\n") + 1);
    }

    private String getSeparateRegex() {
        return separators.stream()
            .collect(Collectors.joining(SEPARATOR_DELIMITER, SEPARATOR_PREFIX, SEPARATOR_SUFFIX));
    }

    public int plusAllTokens(List<String> tokens) {
        for (String token : tokens) {
            if (!isNumber(token)) {
                stringCalculator.resetResult();
                throw new IllegalArgumentException(
                    String.format("[ERROR] %s은(는) 유효한 숫자가 아닙니다.", token)
                );
            }
            int value = Integer.parseInt(token);
            if (value < 0) {
                throw new IllegalArgumentException(
                    String.format("[ERROR] 음수 값 %s은(는) 입력하실 수 없습니다.", token)
                );
            }
            stringCalculator.plus(Integer.parseInt(token));
        }
        return stringCalculator.getResult();
    }

    private boolean isNumber(String token) {
        return token != null && token.matches("[+-]?\\d+");
    }

    public boolean isNeedToAddCustomSeparator(String expression) {
        return PATTERN_OF_NEED_TO_ADD_CUSTOM_SEPARATOR.matcher(expression)
            .matches();
    }

    private boolean isNeedEscapeString(String expression) {
        return expression.equals(SEPARATOR_PREFIX)
            || expression.equals(SEPARATOR_DELIMITER)
            || expression.equals(SEPARATOR_SUFFIX);
    }
}
