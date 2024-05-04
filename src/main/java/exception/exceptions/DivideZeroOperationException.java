package exception.exceptions;

public class DivideZeroOperationException extends RuntimeException {

    public DivideZeroOperationException() {
        super("0으로는 나눌 수 없습니다.");
    }
}
