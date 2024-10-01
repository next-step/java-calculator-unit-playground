package view;

public class OutputView {
    // Normal Calculator
    public static final String ASK_FIRST_OPERATION_MESSAGE = "첫 번째 피연산자를 입력해주세요: ";
    public static final String ASK_TWICE_OPERATION_MESSAGE = "두 번째 피연산자를 입력해주세요: ";
    public static final String ASK_OPERATOR_MESSAGE = "연산자(+, -, *, /)를 입력해주세요: ";

    // String Calculator
    public static final String INFORMATION_MESSAGE = "구분자 '%s' 또는 '%s'를 기준으로 덧셈을 진행합니다.\n";
    public static final String CUSTOM_INFORMATION_MESSAGE = "문자열 앞에 '%s'와 '%s' 사이에 문자열을 넣어 커스텀 구분자를 지정할 수 있습니다.\n";
    public static final String ASK_STRING_EXPRESSION_MESSAGE = "계산을 진행할 문자열을 입력해주세요: ";

    public static void PrintMessage(String message) {
        System.out.print(message);
    }

    public static void PrintResult(int result) {
        System.out.println(result);
    }

}
