package controller;
import domain.Calculator;
import view.Input;
import view.Output;

import java.rmi.NoSuchObjectException;

public class CalculateController {
    private final Input input;
    private final Output output;

    public CalculateController(Input input, Output output) {
        this.input =input;
        this.output=output;
    }


    public void Operate() throws Exception {
        Calculator calculator=new Calculator();
        String s=input.getString();
        if (s.isEmpty()) throw new NoSuchObjectException("공백은 입력할 수 없습니다.");
        calculator.StringCalculator(s);
    }


}
