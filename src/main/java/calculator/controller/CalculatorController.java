package calculator.controller;

import calculator.domain.Calculator;
import calculator.view.InputView;

import static calculator.view.OutputView.*;

public class CalculatorController {
    public static void start() {
        final int firstOperation;
        final int secondOperation;
        final char operation;

        PrintMessage(ASK_FIRST_OPERATION_MESSAGE);
        firstOperation = InputView.InputOperation();

        PrintMessage(ASK_TWICE_OPERATION_MESSAGE);
        secondOperation = InputView.InputOperation();

        PrintMessage(ASK_OPERATOR_MESSAGE);
        operation = InputView.InputOperator();

        calculate(firstOperation, secondOperation, operation);
    }

    private static void calculate(int firstOperation, int secondOperation, char operation) {
        Calculator calculator = new Calculator(firstOperation, secondOperation, operation);

        int result = calculator.getResult();

        PrintResult(result);
    }


}
