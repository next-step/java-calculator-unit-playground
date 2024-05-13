package simpleCalculator.controller;

import simpleCalculator.model.Calculator;
import simpleCalculator.view.CalculatorView;
import java.util.List;

public class CalculatorController {

    List<Integer> numbers = CalculatorView.getNumber();
    Calculator calculator = new Calculator(numbers.get(0), numbers.get(1));

    public void doAdd() {

        int addResult = calculator.addNumbers();
        System.out.println("덧셈 결과 : " + addResult);
    }

    public void doSub() {

        int subResult = calculator.subNumbers();
        System.out.println("뺄셈 결과 : " + subResult);
    }

    public void doDivide() {

        int divideResult = calculator.divideNumbers();
        System.out.println("나눗셈 결과 : " + divideResult);
    }

    public void doMultiple() {

        int multipleResult = calculator.multipleNumbers();
        System.out.println("곱셈 결과 : " + multipleResult);
    }
}