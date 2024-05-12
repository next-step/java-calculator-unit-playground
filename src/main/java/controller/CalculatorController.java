package controller;

import domain.ArithmeticCalculator;
import domain.SplitExceptionCal;
import view.InputView;
import view.Outputview;

import java.util.ArrayList;
import java.util.List;

public class CalculatorController {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String input = inputView.getCalculator();
        SplitExceptionCal splitExceptionCal = new SplitExceptionCal();
        List<String> parsedInput = splitExceptionCal.getParsedInput(input);
        List<String> parsedValue = splitExceptionCal.getParseException(parsedInput);

        List<Integer> numbers = new ArrayList<>();
        for (String value : parsedValue) {
            numbers.add(Integer.parseInt(value));
        }

        ArithmeticCalculator calculator = new ArithmeticCalculator(numbers);
        int plusResult = calculator.plusCalculate();
        int minusResult = calculator.minusCalculate();
        int divideResult = calculator.divideCalculate();
        int multiplyResult = calculator.multipleCalculate();
        Outputview outputview = new Outputview();
        outputview.resultLast(plusResult, minusResult, divideResult, multiplyResult);
    }
}
