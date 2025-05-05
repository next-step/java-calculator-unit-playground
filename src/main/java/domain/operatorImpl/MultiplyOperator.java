package domain.operatorImpl;

import domain.Operand;
import domain.Operator;

public class MultiplyOperator extends Operator {
    public MultiplyOperator() {
        super('*');
    }

    @Override
    public int process(Operand firstOperand, Operand secondOperand) {
        return firstOperand.getValue() * secondOperand.getValue();
    }
}
