package simpleCalculator.controller;

import simpleCalculator.model.Calculator;
import simpleCalculator.model.StringCalculator;
import simpleCalculator.view.InputView;
import simpleCalculator.view.OutView;

public class CalculatorController {

    private InputView inputView;
    private OutView outView;
    private Calculator calculator;
    private StringCalculator stringCalculator;

    public CalculatorController() {
        this.inputView = new InputView();
        this.outView = new OutView();
        this.calculator = new Calculator();
        this.stringCalculator = new StringCalculator();
    }

    private void runSimpleCalculator() {
        String input = inputView.getSimpleNumber();
        calculator.setNumber(input);

        int resultAdd = calculator.addNumbers();
        int resultSub = calculator.subNumbers();
        int resultDiv = calculator.divideNumbers();
        int resultMul = calculator.multipleNumbers();

        outView.printResult(resultAdd);
        outView.printResult(resultSub);
        outView.printResult(resultDiv);
        outView.printResult(resultMul);
    }

    private void runStringCalculator() {
        String input = inputView.getStringNumber();
        int result = stringCalculator.add(input);

        outView.printResult(result);
    }
}