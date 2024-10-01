package StringCalculator.controller;

import StringCalculator.domain.StringCalculator;
import view.InputView;

import static StringCalculator.util.Config.*;
import static java.lang.String.format;
import static view.OutputView.*;

public class StringCalculatorController {
    public static void execute() {
        PrintMessage(format(INFORMATION_MESSAGE, FIRST_SEPARATOR, SECOND_SEPARATOR));
        PrintMessage(format(CUSTOM_INFORMATION_MESSAGE, FIRST_CUSTOM_SETTING_STRING, SECOND_CUSTOM_SETTING_STRING));
        PrintMessage(ASK_STRING_EXPRESSION_MESSAGE);

        String expression = InputView.InputExpression();

        int result = StringCalculator.stringCalculate(expression);

        PrintResult(result);
    }
}
