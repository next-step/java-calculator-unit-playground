package domain.operatorImpl;

import domain.Operand;
import domain.Operator;

public class AddOperator extends Operator {
    public AddOperator(){
        super('+');
    }

    @Override
    public int process(Operand firstOperand, Operand secondOperand) {
        return firstOperand.getValue() + secondOperand.getValue();
    }
}
