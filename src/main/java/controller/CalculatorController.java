package controller;

import domain.ArithmeticCalculator;
import domain.SplitExceptionCal;
import view.InputView;

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

        System.out.println("덧셈 결과: " + plusResult);
        System.out.println("뺄셈 결과: " + minusResult);
        System.out.println("나눗셈 결과: " + divideResult);
        System.out.println("곱셈 결과: " + multiplyResult);
    }
}
