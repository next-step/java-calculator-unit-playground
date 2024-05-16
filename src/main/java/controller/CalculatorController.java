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

    public void operate() {
        String input = inputView.inputString();
        StringCalculator stringCalculator = new StringCalculator(input);

        List<String> strNumber;
        strNumber = stringCalculator.checkSplit();

        List<Integer> numbers = stringCalculator.changeStrToInt(strNumber);
        int answer = stringCalculator.getSum(numbers);
        outputView.printAnswer(answer);
    }
}
