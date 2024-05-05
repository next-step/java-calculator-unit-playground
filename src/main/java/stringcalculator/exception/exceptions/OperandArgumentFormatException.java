package stringcalculator.exception.exceptions;

public class OperandArgumentFormatException extends RuntimeException {

    public OperandArgumentFormatException() {
        super("연산은 양수만 가능합니다.");
    }
}
