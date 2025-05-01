package domain.operatorImpl;

import domain.Operand;
import domain.Operator;

public class SubtractOperator implements Operator {
    public String[] symbols = {"-"};

    @Override
    public int process(Operand firstOperand, Operand secondOperand) {
        return firstOperand.getValue() - secondOperand.getValue();
    }

    @Override
    public String[] getSymbols() {
        return this.symbols;
    }
}
