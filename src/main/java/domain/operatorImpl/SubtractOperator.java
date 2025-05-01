package domain.operatorImpl;

import domain.Operand;
import domain.Operator;

public class SubtractOperator extends Operator {
    public SubtractOperator() {
        super('-');
    }

    @Override
    public int process(Operand firstOperand, Operand secondOperand) {
        return firstOperand.getValue() - secondOperand.getValue();
    }
}
