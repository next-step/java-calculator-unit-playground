package controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import domain.ArithmeticCalculator;
import org.junit.jupiter.api.Test;
import view.InputView;
import view.OutputView;



public class CalculatorControllerTest {

    @Test
    void 통합_테스트() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();
        CalculatorController calculatorController = new CalculatorController(inputView, outputView, arithmeticCalculator);
        String input = "//;\n1;2;3";
        int expectedResult = 6;
        calculatorController.startCalculator(input);
        int actualResult = arithmeticCalculator.getResult();

        assertEquals(expectedResult,actualResult);
    }
}
