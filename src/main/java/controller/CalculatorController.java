package controller;

import domain.ArithmeticCalculator;
import view.InputView;
import view.OutputView;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController(InputView inputView, OutputView outputView, ArithmeticCalculator arithmeticCalculator) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    void startCalculator(String str) {
        ArithmeticCalculator calculator = new ArithmeticCalculator();
        String input = inputView.calculatorInput();
        calculator.plusCalculate(outputView.splitStr(input));
    }
}
