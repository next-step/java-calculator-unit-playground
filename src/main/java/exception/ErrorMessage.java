package exception;

public class ErrorMessage {

    public static final String NULL_STRING = "문자열에 null 값이 전달되었습니다.";
    public static final String CUSTOM_DELIMITER_NOT_FOUND = "커스텀 구분자를 찾을 수 없습니다.";
    public static final String NEGATIVE_NUMBER_NOT_ALLOWED = "음수는 처리할 수 없습니다.";
    public static final String INVALID_STRING = "문자열은 처리할 수 없습니다.";
    public static final String DIVIDE_BY_ZERO = "0으로 나눌 수 없습니다.";

    private ErrorMessage() {
        throw new RuntimeException();
    }
}
