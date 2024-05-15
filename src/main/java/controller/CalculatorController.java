package controller;

import domain.StringCalculator;
import view.InputView;
import view.OutputView;

import java.rmi.NoSuchObjectException;
import java.util.List;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController(InputView inputView, OutputView outputView){
        this.inputView=inputView;
        this.outputView=outputView;
    }

    public void operate(){
        String input= inputView.inputString();
        StringCalculator stringCalculator= new StringCalculator(input);

        try {
            stringCalculator.checkBlankInput();
        } catch (NoSuchObjectException e) {
            throw new RuntimeException(e);
        }

        List<String> strings;

        if(stringCalculator.containCustomSplitStr()){
            strings=stringCalculator.splitCustom();
        }
        else{
            strings=stringCalculator.splitBasic();
        }

        List<Integer> numbers=stringCalculator.changeStrToInt(strings);
        int answer=stringCalculator.getSum(numbers);
        outputView.printAnswer(answer);
    }
}
