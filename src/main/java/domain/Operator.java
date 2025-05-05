package domain;

import java.util.ArrayList;
import java.util.List;

public abstract class Operator {
    protected List<Character> symbols;

    public Operator(Character... symbols) {
        this.symbols = new ArrayList<>(List.of(symbols));
    }

    public abstract int process(Operand firstOperand, Operand secondOperand);

    public boolean checkSymbols(Character operatorExpression) {
        return symbols.contains(operatorExpression);
    }

    public void addSymbol(Character symbol){
        symbols.add(symbol);
    }
}
