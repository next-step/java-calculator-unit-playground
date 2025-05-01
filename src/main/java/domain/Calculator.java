package domain;

import domain.operatorImpl.AddOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private static final String REGEX_PATTERN = "^\\/\\/(.)\\n([\\s\\S]*)";
    private final Operator[] operators;

    public Calculator(Operator[] operators) {
        this.operators = operators;
    }

    public int calculateStringExpression(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            return 0;
        }

        int result;
        if (expression.startsWith("//")) {
            String remainedExpression = this.extractCustomSymbol(expression);
            result = calculate(remainedExpression);
        } else{
            result = calculate(expression);
        }

        return result;
    }

    private String extractCustomSymbol(String expression) {
        Pattern pattern = Pattern.compile(REGEX_PATTERN);
        Matcher matcher = pattern.matcher(expression);

        if (matcher.matches()) {
            if (matcher.group(1).length() != 1) {
                throw new IllegalArgumentException("커스텀 구분자가 올바르지 않습니다.");
            }
            AddOperator.INSTANCE.addSymbol(matcher.group(1).charAt(0));
            return matcher.group(2);
        }

        throw new IllegalArgumentException("커스텀 문자열이 형식에 맞지 않습니다.");
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
