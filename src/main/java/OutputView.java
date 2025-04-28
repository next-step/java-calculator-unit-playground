public class OutputView {

    private static final String FIRST_NUMBER_PROMPT = "첫 번째 숫자를 입력하세요: ";
    private static final String SECOND_NUMBER_PROMPT = "두 번째 숫자를 입력하세요: ";
    private static final String RESULT_MESSAGE = "계산 결과: ";

    public void printFirstNumberPrompt() {
        System.out.print(FIRST_NUMBER_PROMPT);
    }

    public void printSecondNumberPrompt() {
        System.out.print(SECOND_NUMBER_PROMPT);
    }

    public void printResult(int result) {
        System.out.println(RESULT_MESSAGE + result);
    }
}