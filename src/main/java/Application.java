import controller.CalculatorController;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CalculatorController calculatorController = new CalculatorController(inputView, outputView);
        calculatorController.startCalculator();
    }
}
