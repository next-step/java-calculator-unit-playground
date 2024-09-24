package calculator.controller;

import calculator.view.InputView;

import static calculator.view.OutputView.*;

public class CalculatorController {
    public static void start() {
        final int firstOperation;
        final int secondOperation;
        final char operation;

        PrintMessage(ASK_FIRST_OPERATION_MESSAGE);
        firstOperation = InputView.InputOperator();

        PrintMessage(ASK_TWICE_OPERATION_MESSAGE);
        secondOperation = InputView.InputOperator();

        PrintMessage(ASK_OPERATOR_MESSAGE);
        operation = InputView.InputOperator();
    }


}
