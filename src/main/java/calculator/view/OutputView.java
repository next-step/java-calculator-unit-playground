package calculator.view;

public class OutputView {
    public static final String ASK_FIRST_OPERATION_MESSAGE = "첫 번째 피연산자를 입력해주세요: ";
    public static final String ASK_TWICE_OPERATION_MESSAGE = "두 번째 피연산자를 입력해주세요: ";
    public static final String ASK_OPERATOR_MESSAGE = "연산자(+, -, *, /)를 입력해주세요: ";

    public static void PrintMessage(String message) {
        System.out.print(message);
    }

    public static void PrintResult(int result) {
        System.out.println(result);
    }

}
