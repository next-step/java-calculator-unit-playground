package domain.operatorImpl;

import domain.Operand;
import domain.Operator;

public class MultiplyOperator implements Operator {
    public String value = "*";

    @Override
    public int process(Operand firstOperand, Operand secondOperand) {
        return firstOperand.getValue() * secondOperand.getValue();
    }
}
