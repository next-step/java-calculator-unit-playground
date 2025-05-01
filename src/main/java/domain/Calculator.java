package domain;

public class Calculator {
    private final Operator[] operators;

    public Calculator(Operator[] operators) {
        this.operators = operators;
    }

    public int calculateStringExpression(String expression) {
        for (int i = 0; i < expression.length(); i++) {
            char value = expression.charAt(i);

            if (Character.isDigit(value)) {
                continue;
            }

            for (Operator operator : operators) {
                if (operator.checkSymbols(value)) {
                    Operand leftOperand = new Operand(expression.substring(0, i).trim());
                    Operand rightOperand = new Operand(expression.substring(i + 1).trim());

                    return operator.process(leftOperand, rightOperand);
                }
            }
        }

        throw new IllegalArgumentException("계산할 수 없는 문자열입니다.");
    }
}
