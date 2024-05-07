package model;

import view.InputView;

import java.util.List;

public class Calculator {
    List<Integer> realNumber = InputView.getNumber();
    int num1 = realNumber.get(0);
    int num2 = realNumber.get(1);

    public int addNumbers(){
        return num1 + num2;
    }

    public int subNumbers(){
        return num1 - num2;
    }

    public int divideNumbers(){
        return num1/num2;
    }

    public int multipleNumbers(){
        return num1 * num2;
    }
}
