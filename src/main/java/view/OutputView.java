package view;

import model.Calculator;

public class OutputView {
    Calculator calculator = new Calculator();
    public void printAddResult(){
        System.out.println("덧셈 결과는 " + calculator.addNumbers() + "입니다.");
    }


    public void printSubResult(){
        System.out.println("뺄셈 결과는 " + calculator.subNumbers() + "입니다.");
    }

    public void printDivideResult(){
        System.out.println("나눗셈 결과는 " + calculator.divideNumbers() + "입니다.");
    }

    public void printMultipleResult(){
        System.out.println("곱셈 결과는 " + calculator.multipleNumbers() + "입니다.");
    }
}
