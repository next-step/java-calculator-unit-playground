package domain;

import domain.operatorImpl.AddOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    // '//'와 '\n' 사이의 커스텀 기호와 뒤에 문자열을 분리하는 정규표현식
    private static final String CUSTOM_SYMBOL_EXPRESSION_REGEX_PATTERN = "^\\/\\/(.)\\n([\\s\\S]*)";
    private final Operator[] operators;

    public Calculator(Operator[] operators) {
        this.operators = operators;
    }

    public int calculateStringExpression(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            return 0;
        }

        if (expression.startsWith("//")) {
            String[] customSymbolAndRemainedExpression = separateCustomExpression(expression);
            char customSymbol = customSymbolAndRemainedExpression[0].charAt(0);
            addCustomSymbol(AddOperator.INSTANCE, customSymbol);
            String remainedExpression = customSymbolAndRemainedExpression[1];

            return calculate(remainedExpression);
        }

        return calculate(expression);
    }

    private String[] separateCustomExpression(String expression) {
        Pattern pattern = Pattern.compile(CUSTOM_SYMBOL_EXPRESSION_REGEX_PATTERN);
        Matcher matcher = pattern.matcher(expression);

        if (matcher.matches()) {
            if (matcher.group(1).length() != 1) {
                throw new IllegalArgumentException("커스텀 구분자가 올바르지 않습니다.");
            }

            return new String[]{matcher.group(1), matcher.group(2)};
        }

        throw new IllegalArgumentException("커스텀 문자열이 형식에 맞지 않습니다.");
    }

    private void addCustomSymbol(Operator operator, char customSymbol) {
        operator.addSymbol(customSymbol);
    }

    private int calculate(String expression) {
        expression = expression.trim();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch)){
                continue;
            }

            for (Operator operator : operators) {
                if (operator.checkSymbols(ch)) {
                    String leftExpression = expression.substring(0, i).trim();
                    String rightExpression = expression.substring(i + 1).trim();

                    Operand leftOperand = new Operand(leftExpression);
                    Operand rightOperand;

                    if (isInteger(rightExpression)) {
                        rightOperand = new Operand(rightExpression);
                    } else {
                        int rightValue = calculate(rightExpression);
                        rightOperand = new Operand(rightValue);
                    }

                    return operator.process(leftOperand, rightOperand);
                }
            }
        }

        return Integer.parseInt(expression);
    }

    private boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
