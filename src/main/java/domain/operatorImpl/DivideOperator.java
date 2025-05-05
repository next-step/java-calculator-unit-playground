package domain.operatorImpl;

import domain.Operand;
import domain.Operator;

public class DivideOperator extends Operator {
    public DivideOperator() {
        super('/');
    }

    @Override
    public int process(Operand firstOperand, Operand secondOperand) {
        if (secondOperand.getValue() == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }

        return firstOperand.getValue() / secondOperand.getValue();
    }
}
