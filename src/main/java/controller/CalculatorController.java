package controller;

import domain.ArithmeticCalculator;
import domain.SplitString;
import view.InputView;

public class CalculatorController {

    public void controller() {

        SplitString ss = new SplitString();
        ArithmeticCalculator ac = new ArithmeticCalculator();
        InputView inputview = new InputView();

        ss.splitStr("1,2,3");
        ac.plusCalculate();
        inputview.printing();
    }


}
