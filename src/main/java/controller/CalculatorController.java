package controller;

import domain.StringCalculator;
import view.InputView;
import view.OutputView;

import java.util.List;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startCalculator(){
        String inputStrings = inputView.getString();
        StringCalculator stringCalculator = new StringCalculator(inputStrings);
        List<String> paresStrings = stringCalculator.parseStrings();
        List<Integer> numberList = stringCalculator.changeStringsToNumbers(paresStrings);
        outputView.printNumber(stringCalculator.addNumbers(numberList));
    }

}
