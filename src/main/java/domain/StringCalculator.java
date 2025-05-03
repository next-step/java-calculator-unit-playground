package domain;

import utils.ExpressionSplitter;

import java.util.List;

public class StringCalculator {

    private final Delimiters delimiters;
    private final ExpressionSplitter splitter;

    public StringCalculator() {
        this.delimiters = new Delimiters();
        this.splitter = new ExpressionSplitter(delimiters);
    }

    public int calculateSum(String expression) {
        if (isEmpty(expression)) {
            return 0;
        }

        String numbersExpression = extract(expression);
        List<String> tokens = splitter.split(numbersExpression);
        PositiveNumbers positiveNumbers = new PositiveNumbers(tokens);

        return positiveNumbers.sum();
    }

    private boolean isEmpty(String expression) {
        return expression == null || expression.isBlank();
    }

    private String extract(String expression) {
        final String prefix = "//";
        final String suffix = "\n";
        if (!expression.startsWith(prefix)) {
            return expression;
        }
        int endIndex = expression.indexOf(suffix);
        if (endIndex == -1) {
            throw new IllegalArgumentException("[ERROR] 커스텀 구분자 형식이 잘못되었습니다.");
        }
        String customDelimiter = expression.substring(prefix.length(), endIndex);
        delimiters.registerCustomDelimiter(customDelimiter);
        return expression.substring(endIndex + 1);
    }
}
